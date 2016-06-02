package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.pizza.BatchInsertPizza;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
@Transactional
public class PizzaDaoJdbcTemplate implements IPizzaDao {
	
	private static final Logger LOG = Logger.getLogger(PizzaDaoJdbcTemplate.class.toString());

	

	private String url;
	private String user;
	private String pass;
	private JdbcTemplate jdbcTemplate;
//	private PlatformTransactionManager txManager;
	@Autowired private BatchInsertPizza batchInsertPizza; 


	@Autowired
	public PizzaDaoJdbcTemplate(DataSource datasource)  throws DaoException{
		this.jdbcTemplate = new JdbcTemplate(datasource);
		LOG.log(Level.INFO, "Fonctionnement de PizzaDaoJdbcTemplate");
	}

//		
//	
//	private Connection connexion() throws SQLException {
//		return DriverManager.getConnection(url,user,pass);
//	}
//	
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		String sql = "SELECT * FROM PIZZA";
//		 this.jdbcTemplate.query(sql, new RowMapper<Pizza>
		
		return this.jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Pizza p = new Pizza();
			p.setCode(rs.getString("code"));
			p.setNom(rs.getString("nom"));
			p.setPrix(rs.getBigDecimal("prix"));
			p.setCategorie(CategoriePizza.valueOf(rs.getString("categorie")));
			return p;
		});
	}

	@Override
	public void savePizza(Pizza newPizza) {
		String sql = "INSERT INTO `pizza` (`categorie`, `code`, `nom`, `prix`, `url_image`) VALUES(?,?,?,?,?)";
		this.jdbcTemplate.update(sql, newPizza.getCategorie().name(), newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(), newPizza.getUrl_image());
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) {
		String sql = "update `pizza` set code = ?, nom = ?, prix = ?, categorie = ?, url_image = ?)";
		this.jdbcTemplate.update(sql, updatePizza.getCode(), updatePizza.getNom(), updatePizza.getPrix(),
				updatePizza.getCategorie(), updatePizza.getUrl_image());
		
	}
	

	public void updatePizza(Pizza updatePizza) {
		String sql = "update pizza set code = ?, nom = ?, prix = ?, categorie = ?, url_image = ?";
		this.jdbcTemplate.update(sql, updatePizza.getCode(), updatePizza.getNom(), updatePizza.getPrix(),
				updatePizza.getCategorie(), updatePizza.getUrl_image());
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		String sql = "DELETE FROM pizza where code = ?";
		this.jdbcTemplate.update(sql, codePizza);
	}



	@Override
	@Transactional
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		List<List<Pizza>> listPartitionnee = ListUtils.partition(listPizzas, nb);
		listPartitionnee.forEach(batchInsertPizza::insertPizza);
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

	@Override
	public Pizza findOnePizza(String code) throws DaoException {
		 try {
	            return this.jdbcTemplate.queryForObject("select * from pizza where code=?", (rs, rowNum) -> new Pizza(rs.getString("code"), rs.getString("nom"), rs.getBigDecimal("prix"), CategoriePizza.valueOf(rs
	                    .getString("categorie"))), code);
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
}
