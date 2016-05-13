package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
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
	
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();

	public PizzaDaoJDBC() {
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00,  CategoriePizza.SANS_VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00,  CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		pizzas.put("SAU", new Pizza("SAU", "La Saumonéta", 14.00, CategoriePizza.POISSON));
	}
	
	
	private Connection connexion() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
	}
	
	
	private void deconnexion(Connection conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		try (Connection connection = connexion();Statement statement = connection.createStatement();){
			
			ResultSet resultats = statement.executeQuery("SELECT * FROM	PIZZA");
			while(resultats.next()) {
				Pizza pizza = new Pizza();
				pizza.setId(resultats.getInt("id"));
				pizza.setNom(resultats.getString("nom")); ;
				pizza.setPrix(resultats.getDouble("prix"));
				System.out.println("[id = " + pizza.getId() + " - name = " + pizza.getNom() + " - price = " + pizza.getPrix() + "]");
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
				Statement statement = connection.createStatement();	
			)
		{
			
			int nbPizzaInsere = statement.executeUpdate("INSERT INTO PIZZA(nom, prix)"
					+ "VALUES('Regina', 12.0)");
			String message = nbPizzaInsere < 2 ? nbPizzaInsere + " pizza insérée" : nbPizzaInsere + " pizza insérées";
			System.out.println(message);
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Pas de statement créé");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new UpdatePizzaException("code pizza non trouvé");
		}
		pizzas.put(codePizza, updatePizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new DeletePizzaException("code pizza non trouvé");
		}
		pizzas.remove(codePizza);
	}

}
