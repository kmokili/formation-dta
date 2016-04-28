package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public class NouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String NOUVELLE_PIZZA_LIBELLE_MENU = "Ajouter une nouvelle pizza";
	
	public NouvellePizzaOptionMenu(IPizzaDao pizzaDao) {
		super(NOUVELLE_PIZZA_LIBELLE_MENU, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean execute() {
		System.out.println("Ajout d'une nouvelle pizza");
		boolean placeTrouve = false;
		int index = 0;
		return true;
	}

}
