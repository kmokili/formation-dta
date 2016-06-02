package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.IPizzaDao;
import org.springframework.test.annotation.DirtiesContext;

public class PizzaDaoJdbcTemplateTest extends PizzaDaoTest {

	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJdbcTemplate") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	
	
}