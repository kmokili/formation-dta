package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {
	
	private EntityManagerFactory emFactory;
	

	public PizzaDaoJpa(EntityManagerFactory emf) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

}
