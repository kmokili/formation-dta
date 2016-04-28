package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	private static class ResultatRecherche {
		boolean pizzaTrouve;
		int indexPizzaTrouve;
	}

	private static Pizza[] getTableauPizzas() {
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = creerObjetPizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = creerObjetPizza( "MAR", "Margherita", 14.00);
		pizzas[2] = creerObjetPizza("REI", "La Reine", 11.50);
		pizzas[3] = creerObjetPizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = creerObjetPizza("CAN", "La cannibale", 12.50);
		pizzas[5] = creerObjetPizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = creerObjetPizza("ORI", "L'orientale", 13.50);
		pizzas[7] = creerObjetPizza("IND", "L'indienne", 14.00);
		return pizzas;
	}
	
	private static Pizza creerObjetPizza(String code, String nom, double prix) {
		Pizza p = new Pizza();
		p.setCode(code);
		p.setNom(nom);
		p.setPrix(prix);
		Pizza.nbPizzas++;
		return p;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Pizza[] pizzas = getTableauPizzas();

		int saisie = 0;
		do {
			afficherMenuPrincipal();

			saisie = sc.nextInt();

			switch (saisie) {
			case 1:
				listerPizzas(pizzas);
				break;
			case 2:
				ajouterNouvellePizza(sc, pizzas);
				break;
			case 3:
				MettreAJourUnePizza(sc, pizzas);
				break;
			case 4:
				supprimerPizza(sc, pizzas);
				break;
			case 99:
				System.out.println("Aurevoir :-(");
				break;
			}
		} while (saisie != 99);

		sc.close();
	}

	private static void afficherMenuPrincipal() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas ");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

	private static void listerPizzas(Pizza[]pizzas) {
		System.out.println("Liste des pizzas");
		afficherListePizzas(pizzas);
	}

	private static void ajouterNouvellePizza(Scanner sc, Pizza[]pizzas) {
		System.out.println("Ajout d’une nouvelle pizza");
		boolean placeTrouve = false;
		int index = 0;
		while (!placeTrouve && index < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			index++;
		}

		if (placeTrouve) {
			pizzas[index] = saisirDonneesPizza(sc);
			Pizza.nbPizzas++;
		} else {
			System.err.println("Plus de place pour une nouvelle pizza");
		}
	}

	private static void MettreAJourUnePizza(Scanner sc, Pizza[]pizzas) {
		System.out.println("Mise à jour d’une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza à modifier. (99 pour abandonner)");
		String codePizza = sc.next();
		ResultatRecherche resultatRecherche = rechercherPizza(pizzas, codePizza);
		if (resultatRecherche.pizzaTrouve) {
			pizzas[resultatRecherche.indexPizzaTrouve] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Code pizza non trouvé");
		}
	}

	private static void supprimerPizza(Scanner sc, Pizza[]pizzas) {
		System.out.println("Suppression d’une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza à supprimer. (99 pour abandonner)");
		String codePizzaSuppr = sc.next();
		ResultatRecherche resultatRecherche = rechercherPizza(pizzas, codePizzaSuppr);
		if (resultatRecherche.pizzaTrouve) {
			pizzas[resultatRecherche.indexPizzaTrouve] = null;
			Pizza.nbPizzas--;
		} else {
			System.err.println("Code pizza non trouvé");
		}
	}

	private static void afficherListePizzas(Pizza[]pizzas) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
		System.out.println("------ " + Pizza.nbPizzas + " pizzas trouvés");
	}
	

	private static ResultatRecherche rechercherPizza(Pizza[]pizzas, String codePizza) {
		boolean pizzaTrouve = false;
		int indexPizzaTrouve = 0;
		while (!pizzaTrouve && indexPizzaTrouve < pizzas.length) {
			if(pizzas[indexPizzaTrouve] != null) {
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

	private static Pizza saisirDonneesPizza(Scanner sc) {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(sc.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		newPizza.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");
		newPizza.setPrix(sc.nextDouble());
		return newPizza;
	}

}
