package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	private PizzaDaoImpl pizzaDaoImpl;
	private List<Pizza> listePizzaInitiales;
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pizzaDaoImpl = new PizzaDaoImpl();
		listePizzaInitiales = new ArrayList<Pizza>();
		listePizzaInitiales.add(new Pizza("PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));           
		listePizzaInitiales.add(new Pizza("MAR", "Margherita", BigDecimal.valueOf(14.00),  CategoriePizza.SANS_VIANDE));   
		listePizzaInitiales.add(new Pizza("REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.VIANDE));           
		listePizzaInitiales.add(new Pizza("FRO", "La 4 fromages", BigDecimal.valueOf(12.00),  CategoriePizza.SANS_VIANDE));
		listePizzaInitiales.add(new Pizza("CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE));       
		listePizzaInitiales.add(new Pizza("SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE));       
		listePizzaInitiales.add(new Pizza("ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE));        
		listePizzaInitiales.add(new Pizza("IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE));         
		listePizzaInitiales.add(new Pizza("SAU", "La Saumonéta", BigDecimal.valueOf(14.00), CategoriePizza.POISSON));      
		listePizzaInitiales.sort(Comparator.comparing(Pizza::getCode));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPizzaDaoImpl() {

	}

	@Test
	public void testFindAllPizzas() {
		List<Pizza> resultat = pizzaDaoImpl.findAllPizzas();
		resultat.sort(Comparator.comparing(Pizza::getCode));
		Pizza[] tabPizzasInitiales = listePizzaInitiales.<Pizza>toArray(new Pizza[0]);
		Pizza[] tabResultatObtenu = resultat.<Pizza>toArray(new Pizza[0]);
		assertArrayEquals(tabPizzasInitiales, tabResultatObtenu);
	}

	@Test
	public void testSavePizzaCodeNonExistant() throws DaoException {
		Pizza newPizza = new Pizza("CODE_INEXISTANT", "Nouveau nom", BigDecimal.valueOf(15), CategoriePizza.VIANDE);
		pizzaDaoImpl.savePizza(newPizza);
		List<Pizza> listPizzas = pizzaDaoImpl.findAllPizzas();
		assertTrue(listPizzas.contains(newPizza));
	}

	
	@Test (expected = SavePizzaException.class)
	public void testSavePizzaCodeExistant() throws DaoException {
		Pizza newPizza = new Pizza("PEP", "Nouveau nom", BigDecimal.valueOf(15), CategoriePizza.VIANDE);
		pizzaDaoImpl.savePizza(newPizza);
	}
	
	@Test
	public void testUpdatePizzaCodeExistant() throws DaoException {
		Pizza updatePizza = new Pizza("PEP", "PEP2", BigDecimal.valueOf(15), CategoriePizza.VIANDE);
		pizzaDaoImpl.updatePizza("PEP", updatePizza);
		List<Pizza> listPizzas = pizzaDaoImpl.findAllPizzas();
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertTrue(pizzaOpt.isPresent());
		Pizza pizzaTrouve = pizzaOpt.get();
		assertEquals("PEP", pizzaTrouve.getCode());
		assertEquals("PEP2", pizzaTrouve.getNom());
		assertTrue(pizzaTrouve.getPrix().compareTo(BigDecimal.valueOf(15.0))==0);
		assertEquals(CategoriePizza.VIANDE, pizzaTrouve.getCategorie());
	}

	@Test
	public void testDeletePizza() throws DaoException {
		List<Pizza> listPizzas = pizzaDaoImpl.findAllPizzas();
		assertEquals(9, listPizzas.size());
		pizzaDaoImpl.deletePizza("PEP");
		listPizzas = pizzaDaoImpl.findAllPizzas();
		assertEquals(8, listPizzas.size());
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertFalse(pizzaOpt.isPresent());
	}
	
	@Test(expected = DeletePizzaException.class)
	public void testDeletePizzaCodeInexistant() throws DaoException {
		pizzaDaoImpl.deletePizza("PEP1");
	}

}
