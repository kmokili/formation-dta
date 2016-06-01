package fr.pizzeria.console;

import java.io.IOException;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJDBC;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;


public class PizzaAdminApp {
	
	private static final Logger LOG = Logger.getLogger("PizzaAdminApp");
	

	private PizzaAdminApp() {
		
	}
	
	
	/**
	 * Point d'entrée de l'application.
	 * @param args
	 * @throws IOException
	 * @throws DaoException
	 */
	public static void main(String[] args) throws IOException, DaoException {
		Logger.getLogger("org").setLevel(Level.SEVERE);
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.afficher();
		}
	}


}
