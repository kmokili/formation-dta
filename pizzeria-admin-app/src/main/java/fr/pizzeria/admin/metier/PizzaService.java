package fr.pizzeria.admin.metier;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import fr.pizzeria.exception.DaoException;
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
				em.createQuery("select p from Pizza p where p.code='codePizza'", Pizza.class);
		Pizza p = query.getResultList().get(0);
		
		p.setCode(updatePizza.getCode());
		p.setNom(updatePizza.getNom());
		p.setPrix(updatePizza.getPrix());
		p.setCategorie(updatePizza.getCategorie());
		em.merge(p);
	}
	
	public void deletePizza(String codePizza) throws DaoException {
		TypedQuery<Pizza> query = 
				em.createQuery("delete p from Pizza p where p.code='codePizza'", Pizza.class);
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
	
}
