package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.PizzaDaoJdbcTemplate;
import fr.pizzeria.model.Pizza;
@Component
public class BatchInsertPizza {
	
	 private PizzaDaoJdbcTemplate pizzaDaoJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BatchInsertPizza(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertPizza(List<Pizza> listPizzas) {
		listPizzas.forEach(pizzaDaoJdbcTemplate::savePizza);
	}

}
