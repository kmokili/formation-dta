package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String SUPPR_PIZZA_LIBELLE_MENU = "Supprimer une Pizza";

	public SupprimerPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(SUPPR_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}

	@Override
	public boolean execute() {

		new ListerPizzaOptionMenu(pizzaDao).execute();
		
		System.out.println("Veuillez choisir la pizza à supprimer. (99 pour abandonner)");
		String codePizza = sc.next();
		
	
	
		boolean resultat = pizzaDao.deletePizza(codePizza);

		if (resultat) {
			System.out.println("Pizza supprimée");
		} else {
			System.err.println("Echec suppression pizza");
		}

		return true;
	}

}
