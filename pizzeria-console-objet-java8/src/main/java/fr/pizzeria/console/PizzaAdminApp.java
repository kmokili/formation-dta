package fr.pizzeria.console;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaAdminApp {

	public static void main(String[] args) throws IOException {
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		
		switch (daoImplConf) {
		case 0:
			lancerApplication(new PizzaDaoImpl());
			break;
		case 1:
			lancerApplication(new PizzaDaoFichierImpl());
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
