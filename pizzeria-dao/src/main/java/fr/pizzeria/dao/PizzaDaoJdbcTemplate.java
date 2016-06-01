package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoJdbcTemplate implements IPizzaDao {
	

	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	private String url;
	private String user;
	private String pass;
	private JdbcTemplate jdbcTemplate; 
	
	public PizzaDaoJdbcTemplate() {
		
	}

	public PizzaDaoJdbcTemplate(DataSource datasource)  throws DaoException{
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

		
	
	private Connection connexion() throws SQLException {
		return DriverManager.getConnection(url,user,pass);
	}
	
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		String sql = "SELECT * FROM PIZZA";
//		 this.jdbcTemplate.query(sql, new RowMapper<Pizza>
		
		return this.jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setNom(rs.getString("nom"));
			return p;
		});
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		String sql = "INSERT INTO `pizza` (`categorie`, `code`, `nom`, `prix`) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, newPizza.getCategorie(), newPizza.getCode(), newPizza.getNom(), newPizza.getPrix());
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		String sql = "update `pizza` set `nom` = ? where code = ?)";
		this.jdbcTemplate.update(sql, updatePizza.getNom(), updatePizza.getCode());
		
	}
	

	public void updatePizza(Pizza updatePizza) {
		String sql = "update `pizza` set `nom` = ? where code = ?)";
		this.jdbcTemplate.update(sql, updatePizza.getNom(), updatePizza.getCode());
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		String sql = "DELETE FROM `pizza` where code = ?)";
		this.jdbcTemplate.update(sql, codePizza);
	}



	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	
	public String getUrl() {
		return url;
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	@Value("${jdbc.user}")
	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	@Value("${jdbc.pass}")
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Integer countPizzas() {
		String sql = "SELECT COUNT(*) FROM PIZZA";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
