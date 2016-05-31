package fr.pizzeria.console;

import java.io.IOException;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	 * 
	 * @param args
	 * @throws IOException
	 * @throws DaoException
	 */
	public static void main(String[] args) throws IOException, DaoException {
		try(ClassPathXmlApplicationContext context 
				= new ClassPathXmlApplicationContext("application-config.xml","dao-memoire-config.xml")) {
			Menu menu = context.getBean(Menu.class);
			IPizzaDao pizzaDao = context.getBean(PizzaDaoImpl.class);
			menu.afficher();
		}
	}

	
		
//	private static void lancerApplication(IPizzaDao dao){
//		try(Scanner sc = new Scanner(System.in)) {
//			Menu menu = new Menu(sc,dao);
//			menu.afficher();
//		}
//		
//	}

}
