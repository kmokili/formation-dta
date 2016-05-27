package fr.pizzeria.admin.metier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaService implements Serializable{
	
	/**
	 * For serialization
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="pizza-db") private EntityManager em;

	public PizzaService() {
		super();
	}
	
	public List<Pizza> findAllPizzas() throws DaoException {
		TypedQuery<Pizza> query =
			      em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> resultats = query.getResultList();
		
		return resultats;
		
	}
	
	public void savePizza(Pizza newPizza) throws DaoException {
		em.persist(newPizza);
	}
	
	
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		TypedQuery<Pizza> query = 
				em.createQuery("select p from Pizza p where p.code=:codePizza", Pizza.class)
				.setParameter("codePizza", codePizza);
		
		Pizza p = query.getResultList().get(0);
		
		p.setCode(updatePizza.getCode());
		p.setNom(updatePizza.getNom());
		p.setPrix(updatePizza.getPrix());
		p.setCategorie(updatePizza.getCategorie());
		em.merge(p);
	}
	
	public void deletePizza(String codePizza) throws DaoException {
		TypedQuery<Pizza> query = 
				em.createQuery("select p from Pizza p where p.code=:codePizza", Pizza.class)
				.setParameter("codePizza", codePizza);
		Pizza p = query.getResultList().get(0);
		
		if (p != null) {
			em.remove(p);
		}
	}

	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		for(Pizza pizza : listPizzas) {
			savePizza(pizza);
		}
	}
	/*
	@PostConstruct
	public void init() {
		Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE, null));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", BigDecimal.valueOf(14.00),  CategoriePizza.SANS_VIANDE, null));
		pizzas.put("REI", new Pizza("REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.VIANDE, null));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", BigDecimal.valueOf(12.00),  CategoriePizza.SANS_VIANDE, null));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE, null));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE, null));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE, null));
		pizzas.put("IND", new Pizza("IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE, null));
		pizzas.put("SAU", new Pizza("SAU", "La Saumonéta", BigDecimal.valueOf(14.00), CategoriePizza.POISSON, null));
		
		pizzas.values().forEach(p-> em.persist(p));
		
	}
	*/
}
