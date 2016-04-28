package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MAJ_PIZZA_LIBELLE_MENU = "Mettre à jour une Pizza";

	public MettreAJourPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(MAJ_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}

	@Override
	public boolean execute() {

		new ListerPizzaOptionMenu(pizzaDao).execute();
		
		System.out.println("Veuillez choisir la pizza à modifier. (99 pour abandonner)");
		String codePizza = sc.next();
		
		Pizza updatePizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		updatePizza.setCode(sc.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		updatePizza.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");
		updatePizza.setPrix(sc.nextDouble());
	
		boolean resultat = pizzaDao.updatePizza(codePizza, updatePizza);

		if (resultat) {
			System.out.println("Pizza mise à jour");
		} else {
			System.err.println("Echec mise à jour pizza");
		}

		return true;
	}

}
