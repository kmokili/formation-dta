package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean savePizza(Pizza newPizza);
	boolean updatePizza(String codePizza, Pizza updatePizza);
	boolean deletePizza(String codePizza);

}
