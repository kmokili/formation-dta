package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private Pizza[] pizzas = new Pizza[100];

	public PizzaDaoImpl() {
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REI", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	}
	

	@Override
	public Pizza[] findAllPizzas() {
		Pizza[] resultat = new Pizza[100];
		System.arraycopy(pizzas, 0, resultat, 0, resultat.length);
		return resultat;
	}

	@Override
	public boolean savePizza(Pizza newPizza) {
		System.out.println("Ajout d'une nouvelle pizza");
		boolean placeTrouve = false;
		int index = 0;
		while (!placeTrouve && index < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			index++;
		}

		if (placeTrouve) {
			pizzas[index] = newPizza;
			Pizza.nbPizzas++;
		} else {
			System.err.println("Plus de place pour une nouvelle pizza");
		}
		return placeTrouve;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza updatePizza) {
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
