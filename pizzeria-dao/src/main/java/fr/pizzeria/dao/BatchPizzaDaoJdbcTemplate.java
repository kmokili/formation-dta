package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

//@Repository
//@Lazy
public class BatchPizzaDaoJdbcTemplate  {
	
	private static final Logger LOG = Logger.getLogger(BatchPizzaDaoJdbcTemplate.class.toString());
	private JdbcTemplate jdbcTemplate;

//	@Autowired
	public BatchPizzaDaoJdbcTemplate(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
		LOG.log(Level.INFO, "Création du bean PizzaDaoJdbcTemplate");
	}
	
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public void insertPizzaTransactional(List<Pizza> listPizzas) {
//		listPizzas.forEach(p -> savePizza(p));
//	}
	
}
