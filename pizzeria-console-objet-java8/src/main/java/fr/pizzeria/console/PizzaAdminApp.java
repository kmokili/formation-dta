package fr.pizzeria.console;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.ihm.menu.Menu;import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaAdminApp {

	public static void main(String[] args) throws IOException {
		


		// hack pour faire planter si la librairie commons-lang est absente
		new Pizza().equals(new Pizza());
		
		try(Scanner sc = new Scanner(System.in)) {
			IPizzaDao dao = new PizzaDaoFichierImpl();
			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
	}

}
