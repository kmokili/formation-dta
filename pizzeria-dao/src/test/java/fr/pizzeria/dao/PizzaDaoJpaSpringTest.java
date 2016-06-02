package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.IPizzaDao;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = SpringJpaConfig.class)
public class PizzaDaoJpaSpringTest extends PizzaDaoTest {

	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJpaSpring") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	
	
}