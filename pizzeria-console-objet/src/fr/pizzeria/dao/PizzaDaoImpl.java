package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private static class ResultatRecherche {
		boolean pizzaTrouve;
		int indexPizzaTrouve;
	}
	
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
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		boolean placeTrouve = false;
		int index = 0;
		while (!placeTrouve && index < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			if(!placeTrouve) {
				index++;
			}
			
		}

		if (placeTrouve) {
			pizzas[index] = newPizza;
		} else {
			throw new SavePizzaException();
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException {
		ResultatRecherche resultatRecherche = rechercherPizza(codePizza);
		if (resultatRecherche.pizzaTrouve) {
			pizzas[resultatRecherche.indexPizzaTrouve] = updatePizza;
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		ResultatRecherche resultatRecherche = rechercherPizza(codePizza);
		if (resultatRecherche.pizzaTrouve) {
			pizzas[resultatRecherche.indexPizzaTrouve] = null;
		} else {
			throw new DeletePizzaException();
		}
		
	}
	
	private ResultatRecherche rechercherPizza(String codePizza) {
		boolean pizzaTrouve = false;
		int indexPizzaTrouve = 0;
		while (!pizzaTrouve && indexPizzaTrouve < pizzas.length) {
			if (pizzas[indexPizzaTrouve] != null) {
				pizzaTrouve = codePizza.equals(pizzas[indexPizzaTrouve].getCode());
			}
			if (!pizzaTrouve) {
				indexPizzaTrouve++;
			}

		}
		ResultatRecherche resultat = new ResultatRecherche();
		resultat.pizzaTrouve = pizzaTrouve;
		resultat.indexPizzaTrouve = indexPizzaTrouve;
		return resultat;
	}


}
