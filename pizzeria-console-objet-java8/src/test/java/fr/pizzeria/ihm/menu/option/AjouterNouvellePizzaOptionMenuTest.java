package fr.pizzeria.ihm.menu.option;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterNouvellePizzaOptionMenuTest {
	
	private AjouterNouvellePizzaOptionMenu optionMenu;
	private IPizzaDao pizzaDao;
	
	@Rule public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Rule public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Locale.setDefault(Locale.FRANCE);
		Scanner scanner = new Scanner(System.in);
		pizzaDao = new PizzaDaoImpl();
		optionMenu = new AjouterNouvellePizzaOptionMenu(scanner, pizzaDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() throws DaoException, IOException {
		systemInMock.provideLines("NEW", "NewPizza", "12.5", "0");
		boolean next = optionMenu.execute();
		assertTrue(next);
		List<Pizza> allPizzas = pizzaDao.findAllPizzas();
		Optional<Pizza> pizzaOpt = allPizzas.stream().filter(p -> "NEW".equals(p.getCode())).findFirst();
		assertTrue(pizzaOpt.isPresent());
		Pizza pizza = pizzaOpt.get();
		assertEquals("NewPizza", pizza.getNom());
		assertTrue(12.5 == pizza.getPrix());
		assertEquals(CategoriePizza.VIANDE, pizza.getCategorie());
		
		String outAttendu = Files.lines(Paths.get("src/test/resources/resultatAjouterNouvellePizza.txt"))
				.collect(Collectors.joining(System.lineSeparator()));
		outAttendu += System.lineSeparator();
		assertEquals(outAttendu, systemOutRule.getLog());
	}

}
