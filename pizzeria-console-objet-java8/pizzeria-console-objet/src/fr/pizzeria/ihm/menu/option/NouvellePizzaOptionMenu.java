package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String NOUVELLE_PIZZA_LIBELLE_MENU = "Ajouter une nouvelle pizza";
	
	public NouvellePizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(NOUVELLE_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean execute() {
		
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(sc.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		newPizza.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(sc.nextDouble());
//		
//		boolean resultat = pizzaDao.savePizza(newPizza);
//		
//		if (resultat) {
//			System.out.println("Nouvelle pizza créée");
//		} else {
//			System.err.println("Echec création de pizza");
//		}
		
		return true;
	}

}
