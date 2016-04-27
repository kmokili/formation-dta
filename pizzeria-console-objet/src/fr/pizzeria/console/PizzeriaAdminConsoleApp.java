package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

//	private static Object[][] getTableauPizzas() {
//		Object[][] pizzas = new Object[100][3];
//		pizzas[0] = new Object[] { "PEP", "P�p�roni", 12.50 };
//		pizzas[1] = new Object[] { "MAR", "Margherita", 14.00 };
//		pizzas[2] = new Object[] { "REI", "La Reine", 11.50 };
//		pizzas[3] = new Object[] { "FRO", "La 4 fromages", 12.00 };
//		pizzas[4] = new Object[] { "CAN", "La cannibale", 12.50 };
//		pizzas[5] = new Object[] { "SAV", "La savoyarde", 13.00 };
//		pizzas[6] = new Object[] { "ORI", "L'orientale", 13.50 };
//		pizzas[7] = new Object[] { "IND", "L'indienne", 14.00 };
//		return pizzas;
//	}
//	
	
	public static Pizza creerObjetPizza(String code, String nom, double prix)
	{
		Pizza p = new Pizza();
		p.code = code;
		p.nom = nom;
		p.prix = prix;
		Pizza.nbPizzas++;
		return p;
		
	}
	
	private static Pizza[] getTableauPizzas() {
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = creerObjetPizza("PEP", "P�p�roni", 12.50);
		pizzas[1] = creerObjetPizza("MAR", "Margherita", 14.00);
		pizzas[2] = creerObjetPizza("REI", "La Reine", 11.50);
		pizzas[3] = creerObjetPizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = creerObjetPizza("CAN", "La cannibale", 12.50);
		pizzas[5] = creerObjetPizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = creerObjetPizza("ORI", "L'orientale", 13.50);
		pizzas[7] = creerObjetPizza("IND", "L'indienne", 14.00);
		return pizzas;
		
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
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

	private static void listerPizzas(Pizza[] pizzas) {
		System.out.println("Liste des pizzas");
		afficherListePizzas(pizzas);
	}

	private static void ajouterNouvellePizza(Scanner sc, Pizza[] pizzas) {
		System.out.println("Ajout d�une nouvelle pizza");
		boolean placeTrouve = false;
		int index = 0;
		while (!placeTrouve && index < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			index++;
		}

		if (placeTrouve) {
			pizzas[index] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Plus de place pour une nouvelle pizza");
		}
	}

	private static void MettreAJourUnePizza(Scanner sc, Pizza[] pizzas) {
		System.out.println("Mise � jour d�une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza a modifier. (99 pour abandonner)");
		String codePizza = sc.next();
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizza);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];

		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = saisirDonneesPizza(sc);
		} else {
			System.err.println("Code pizza non trouv�");
		}
	}

	private static void supprimerPizza(Scanner sc, Pizza[] pizzas) {
		System.out.println("Suppression d�une pizza");
		afficherListePizzas(pizzas);
		System.out.println("Veuillez choisir la pizza � supprimer. (99 pour abandonner)");
		String codePizzaSuppr = sc.next();
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizzaSuppr);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];
		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = creerObjetPizza(null, null, 0);
		} else {
			System.err.println("Code pizza non trouv�");
		}
	}

	private static void afficherListePizzas(Pizza[] pizzas) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + "�)");
			}
		}
	}

	private static Object[] rechercherPizza(Pizza[] pizzas, String codePizza) {
		boolean pizzaTrouve = false;
		int indexPizzaTrouve = 0;
		while (!pizzaTrouve && indexPizzaTrouve < pizzas.length) {
			pizzaTrouve = codePizza.equals(pizzas[indexPizzaTrouve]);
			if (!pizzaTrouve) {
				indexPizzaTrouve++;
			}
		}
		return new Object[] { pizzaTrouve, indexPizzaTrouve };
	}

	private static Pizza saisirDonneesPizza(Scanner sc) {
		System.out.println("Veuillez saisir le code");
		String newCode = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String newNom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double newPrix = sc.nextDouble();
		return creerObjetPizza(newCode, newNom, newPrix);
	}
}