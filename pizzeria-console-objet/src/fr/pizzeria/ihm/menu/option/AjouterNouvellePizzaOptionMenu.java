package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterNouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Ajouter Nouvelle Pizza";

	public AjouterNouvellePizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
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

		try {
			
			System.out.println("Veuillez saisir la cat�gorie");
			
			CategoriePizza[] categoriesPizzas = CategoriePizza.values();
			for(CategoriePizza cat : categoriesPizzas)
			{
				 System.out.println(cat.ordinal() + "->" + cat.getLibelle());
			}
			 
			int saisieCategorie = sc.nextInt();
			newPizza.setCategorie(categoriesPizzas[saisieCategorie]);
			 
			pizzaDao.savePizza(newPizza);
			System.out.println("Nouvelle pizza cr��e");
		} catch (SavePizzaException spe) {
			System.err.println("Echec cr�ation de pizza");
		}

		return true;
	}

}
