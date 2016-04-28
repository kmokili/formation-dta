package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister Pizzas";

	
	
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister Pizza Menu");
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		for (Pizza p : pizzas) {
			if(p != null) {
				System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + ")");
			}
		}
		
		return true;
	}

}
