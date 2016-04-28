package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public abstract class AbstractOptionMenu {
	private String libelle;
	protected IPizzaDao pizzaDao;
	
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		this(libelle);
		this.pizzaDao = pizzaDao;
	}

	public abstract boolean execute();

	public String getLibelle() {
		return libelle;
	}
	
}
