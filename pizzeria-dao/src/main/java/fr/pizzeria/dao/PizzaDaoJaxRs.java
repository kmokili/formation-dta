package fr.pizzeria.dao;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

//import com.sun.jersey.api.client.Client;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

//@Repository
@Lazy
public class PizzaDaoJaxRs implements IPizzaDao {
	
//	Client client = ClientBuilder.newClient().register(JacksonFeature.class);

	public PizzaDaoJaxRs() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub

	}

}
