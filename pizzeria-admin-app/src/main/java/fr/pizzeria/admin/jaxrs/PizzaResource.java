package fr.pizzeria.admin.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {
	@Inject private PizzaService pizzaService;

	public PizzaResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAllPizzas() throws DaoException {
		// pizze : pluriel de pizza (italien)
		List<Pizza> pizze = new ArrayList<Pizza>();
		return pizze;
		
	}
	
	public void savePizza(Pizza newPizza) throws DaoException {
		
	}
	
	
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		
	}
	
	public void deletePizza(String codePizza) throws DaoException {
		
	}
	
	
}
