package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.config.SpringJpaConfig;
import fr.pizzeria.dao.IPizzaDao;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = SpringJpaConfig.class)
public class PizzaDaoDataJpaSpringTest extends PizzaDaoTest {

	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoDataJpaSpring") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	
	
}