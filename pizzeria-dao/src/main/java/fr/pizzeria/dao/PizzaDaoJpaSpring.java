package fr.pizzeria.dao;


import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoJpaSpring implements IPizzaDao {
//    private static final Logger LOG = Logger.;
	
	@PersistenceContext
	private EntityManager em;
	
	
	public PizzaDaoJpaSpring() {
		super();
	}

	@Override
	@Transactional
	public List<Pizza> findAllPizzas() throws DaoException {
		
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> resultat = query.getResultList();
		return resultat;
	}

	@Override
	@Transactional
	public void savePizza(Pizza newPizza) throws DaoException {
		em.persist(newPizza);
	}

	@Override
	@Transactional
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		
			TypedQuery<Pizza> updateQuery = 
					em.createQuery("select p from Pizza p where code=:codePizza", Pizza.class);
			updateQuery.setParameter("codePizza", codePizza);
			Pizza p = updateQuery.getSingleResult();
			p.setCode(updatePizza.getCode());
			p.setNom(updatePizza.getNom());
			p.setPrix(updatePizza.getPrix());
			p.setCategorie(updatePizza.getCategorie());			
	}

	@Override
	@Transactional
	public void deletePizza(String codePizza) throws DaoException {
			TypedQuery<Pizza> query = 
					em.createQuery("select p from Pizza p where code=:codePizza", Pizza.class);
			query.setParameter("codePizza", codePizza);
			Pizza p = query.getSingleResult();
			em.remove(p);
	}

	@Override
	@Transactional
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		
		
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		
		ListUtils.partition(listPizzas, nb).forEach(list -> {
			
			list.forEach(em::persist);
			
		});
	}
	
	@Override
	@Transactional
	public Pizza findOnePizza(String code) throws DaoException {
		TypedQuery<Pizza> updateQuery = 
				em.createQuery("select p from Pizza p where code=:code", Pizza.class);
		updateQuery.setParameter("code", code);
		Pizza p = updateQuery.getSingleResult();
		return p;
	}
	
}
