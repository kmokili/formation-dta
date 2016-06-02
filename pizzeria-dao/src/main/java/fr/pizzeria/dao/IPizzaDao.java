package fr.pizzeria.dao;


import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	IPizzaDao DEFAULT_IMPLEMENTATION = new PizzaDaoImpl();
	
	default Pizza findOnePizza(String code) throws DaoException {
	       throw new NotImplementedException("findOnePizza non implémenté");
	};
	
	List<Pizza> findAllPizzas() throws DaoException;
	void savePizza(Pizza newPizza) throws DaoException;
	void updatePizza(String codePizza, Pizza updatePizza) throws DaoException;
	void deletePizza(String codePizza) throws DaoException;
	void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException;

}
