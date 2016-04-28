package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class Menu {

	private static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	private AbstractOptionMenu[] options;
	private Scanner sc;

	public Menu(Scanner sc,IPizzaDao pizzaDao) {
		super();
		initialiserOptions(sc, pizzaDao);
		this.sc = sc;
	}

	private void initialiserOptions(Scanner scanner, IPizzaDao pizzaDao) {
		options = new AbstractOptionMenu[] { 
				new ListerPizzaOptionMenu(pizzaDao),
				new QuitterOptionMenu()
				};
	}
	
	public void afficher() {
		boolean continuer = true;
		while(continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			for (int i = 0; i < options.length; i++) {
				AbstractOptionMenu opt = options[i];
				System.out.println(i + ". " + opt.getLibelle());
			}
			int saisie = sc.nextInt();
			continuer = options[saisie].execute();
		}
	}

}
