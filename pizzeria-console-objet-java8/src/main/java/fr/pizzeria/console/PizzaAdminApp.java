package fr.pizzeria.console;

import java.io.IOException;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	public static void main(String[] args) throws IOException, DaoException {
		LOG.log(Level.INFO, "Démarrage de l'application");
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		
		switch (daoImplConf) {
		case 0:
			System.out.println("DAO mémoire");
			lancerApplication(new PizzaDaoImpl());
			break;
		case 1:
			System.out.println("DAO fichiers");
			lancerApplication(new PizzaDaoFichierImpl());
			break;
		case 2:
			System.out.println("DAO Jdbc");
			ResourceBundle jdbcBundle = ResourceBundle.getBundle("jdbc");
			String driver = jdbcBundle.getString("jdbc.driver");
			String url = jdbcBundle.getString("jdbc.url");
			String user = jdbcBundle.getString("jdbc.user");
			String pass = jdbcBundle.getString("jdbc.pass");
			
			lancerApplication(new PizzaDaoJDBC(driver,url,user,pass));
			break;
		case 3:
			System.out.println("DAO JPA");
//			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");			
			lancerApplication(new PizzaDaoJpa(emf));
			break;
		default:
			System.err.println("Aucune configuration Dao trouvée. Le fichier application.properties est-il vraiment configuré ?");
			break;
		}
	}

	
		
	private static void lancerApplication(IPizzaDao dao){
		try(Scanner sc = new Scanner(System.in)) {
			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
	}

}
