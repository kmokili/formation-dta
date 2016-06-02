package fr.pizzeria.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSpringTest.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PizzaDaoJdbcTemplate2Test {

	@Autowired private PizzaDaoJdbcTemplate pizzaDaoJdbcTemplate;
	
	@Test
	public void testFindAllPizzas() throws DaoException {
		List<Pizza> pizzas = pizzaDaoJdbcTemplate.findAllPizzas();
		Assert.assertEquals(9, pizzas.size());
	}
	
	@Test
	public void testInsertPizza() throws DaoException {
		List<Pizza> pizzas = pizzaDaoJdbcTemplate.findAllPizzas();
		Assert.assertEquals(9, pizzas.size());
	}
}
