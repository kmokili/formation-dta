package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Component
public class PizzaDaoJpa implements IPizzaDao {
	
	@Autowired
	private EntityManagerFactory emFactory;
	
	
	public PizzaDaoJpa(EntityManagerFactory emf) {
		super();
		this.emFactory = emf;
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> resultat = query.getResultList();
		em.close();
		return resultat;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(newPizza);
		transaction.commit();
		em.close();
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		EntityManager em = emFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			TypedQuery<Pizza> updateQuery = 
					em.createQuery("select p from Pizza p where code=:codePizza", Pizza.class);
			updateQuery.setParameter("codePizza", codePizza);
			Pizza p = updateQuery.getSingleResult();
			p.setCode(updatePizza.getCode());
			p.setNom(updatePizza.getNom());
			p.setPrix(updatePizza.getPrix());
			p.setCategorie(updatePizza.getCategorie());
			
			et.commit();
		} finally {
			em.close();
		}
		

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		EntityManager em = emFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			TypedQuery<Pizza> query = 
					em.createQuery("select p from Pizza p where code=:codePizza", Pizza.class);
			query.setParameter("codePizza", codePizza);
			Pizza p = query.getSingleResult();
			em.remove(p);
			
			et.commit();
		} finally {
			em.close();
		}

	}

	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		EntityManager em = emFactory.createEntityManager();
		
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		
		ListUtils.partition(listPizzas, nb).forEach(list -> {
			em.getTransaction().begin();
			list.forEach(em::persist);
			em.getTransaction().commit();
		});
	}
	
}
