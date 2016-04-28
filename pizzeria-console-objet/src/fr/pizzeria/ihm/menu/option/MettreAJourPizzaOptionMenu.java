package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends AbstractOptionMenu {

	private static final String METTRE_A_JOUR_PIZZA_LIBELLE_MENU = "Mettre à jour une pizza";
	
	public MettreAJourPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(METTRE_A_JOUR_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean execute() {
		
		
		
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		newPizza.setCode(sc.next());
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		newPizza.setNom(sc.next());
		System.out.println("Veuillez saisir le nouveau prix");
		newPizza.setPrix(sc.nextDouble());
		
		boolean resultat = pizzaDao.savePizza(newPizza);
		
		if (resultat) {
			System.out.println("Nouvelle pizza créée");
		} else {
			System.err.println("Echec création de pizza");
		}
		
		return true;
	}

}
