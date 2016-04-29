package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
//	private List<Pizza> pizzas = new ArrayList<Pizza>(100);
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();

	public PizzaDaoImpl() {
		pizzas.put("PEP", new Pizza("PEP", "Peperoni", 12.50));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00));
	}
	

	@Override
	public List<Pizza> findAllPizzas() {
		return new ArrayList<Pizza>(pizzas.values());
	}

	@Override
	public void savePizza(Pizza newPizza) {
		if (pizzas.containsKey(newPizza.getCode()))
		{
			throw new SavePizzaException
		}
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) {
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
