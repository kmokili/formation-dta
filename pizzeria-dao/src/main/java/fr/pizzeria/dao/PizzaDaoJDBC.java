package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaDaoJDBC implements IPizzaDao {
	

	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	
	private String url;
	private String user;
	private String pass;
	
	public PizzaDaoJDBC(String driver, String url2, String user2, String pass2)  throws DaoException{
		try {
			Class.forName(driver);
			this.url = url2;
			this.user = user2;
			this.pass = pass2;
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}

		
	
	private Connection connexion() throws SQLException {
		return DriverManager.getConnection(url,user,pass);
	}
	
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		try (Connection connection = connexion();
			Statement statement = connection.createStatement();
			){
			
			ResultSet resultats = statement.executeQuery("SELECT * FROM	PIZZA");
			while(resultats.next()) {
				Pizza pizza = new Pizza();
				pizza.setId(resultats.getInt("id"));
				pizza.setCode(resultats.getString("code"));
				pizza.setNom(resultats.getString("nom")); 
				pizza.setPrix(resultats.getDouble("prix"));
				pizza.setCategorie(CategoriePizza.valueOf(resultats.getString("categorie")));
				System.out.println("[id = " + pizza.getId() 
					+ " code = " + pizza.getCode()
					+ " - nom = " + pizza.getNom() 
					+ " - prix = " + pizza.getPrix() 
					+ " - categorie = " + pizza.getCategorie().getLibelle()
					+ "]");
				pizzas.add(pizza);
			}
			connection.close();
		} catch (SQLException e) {
			System.err.println("Pas de statement créé");
			e.printStackTrace();
		}
		
		return pizzas;	
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		
		
		try (
				Connection connection = connexion();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO PIZZA(code, nom, prix, categorie) VALUES(?, ?, ?, ?)");	
			)
		{
			statement.setString(1, newPizza.getCode());
			statement.setString(2, newPizza.getNom());
			statement.setDouble(3, newPizza.getPrix());
			statement.setString(4, newPizza.getCategorie().name());
			
			CategoriePizza.valueOf("VIANDE");
			
			statement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Pas de statement créé");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {

		try (
				Connection connection = connexion();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE	PIZZA SET prix=? WHERE code=? and nom=?");	
			)
		{
			statement.setDouble(1, updatePizza.getPrix());
			statement.setString(2, codePizza);
			statement.setString(3, updatePizza.getNom());
			statement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Pas de statement créé");
			e.printStackTrace();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		try (
				Connection connection = connexion();
				PreparedStatement statement = connection.prepareStatement(
						"DELETE FROM `pizza` WHERE code=?");	
			)
		{
			statement.setString(1, codePizza);
			statement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Pas de statement créé");
			e.printStackTrace();
		}
	}



	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
