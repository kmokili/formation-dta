package fr.pizzeria.admin.metier;

import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaService {
	
	private IPizzaDao pizzaDao;

	public PizzaService() {
		super();
	}
	
	public List<Pizza> findAllPizzas() throws DaoException{
		return pizzaDao.findAllPizzas();
		
	}
	
	public void savePizza(Pizza newPizza) throws DaoException {
		pizzaDao.savePizza(newPizza);
	}
	
	
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		pizzaDao.updatePizza(codePizza, updatePizza);
	}
	
	public void deletePizza(String codePizza) throws DaoException {
		pizzaDao.deletePizza(codePizza);
	}

	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		pizzaDao.saveAllPizzas(listPizzas, nb);
	}
	
}
