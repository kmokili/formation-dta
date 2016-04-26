package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	private static Object[][] getTablaeauPizzas() {
		Object[][] pizzas = new Object[100][3];
		pizzas[0] = new Object[] { "PEP", "Pépéroni" , 12.50 };
		pizzas[1] = new Object[] { "MAR", "Margherita" , 14.00 };
		pizzas[2] = new Object[] { "REI", "La Reine" , 11.50 };
		pizzas[3] = new Object[] { "FRO", "La 4 fromages" , 12.00 };
		pizzas[4] = new Object[] { "CAN", "La cannibale" , 12.50 };
		pizzas[5] = new Object[] { "SAV", "La savoyarde" , 13.00 };
		pizzas[6] = new Object[] { "ORI", "L’orientale" , 13.50 };
		pizzas[7] = new Object[] { "IND", "L’indienne" , 14.00 };
		return pizzas;
	}
	
	
	
	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		Object[][] pizzasTab = getTablaeauPizzas();
		int taille = pizzasTab.length;
		
		for (int i = 0; i < taille; i++) {
			Object codePizza = pizzasTab[i][0];
			if (codePizza != null) {
				System.out.println(codePizza);
			}
		}
		
	}
	
	
	public static void afficherPizza(Object[][] tab)
	{
		int taille = tab.length;
		for (int i = 0; i < taille; i++) {
			Object codePizza = tab[i][0];
			if (codePizza != null) {
				System.out.println(codePizza + " -> " + tab[i][1] + "(" + tab[i][2] + ")");
			}
		}
		
	}
	
	
	public static void ajouterPizza(String code, String nom, double prix)
	{
		Object[][] pizzasTab = getTablaeauPizzas();
		int taille = pizzasTab.length;
		
//		if (pizzasTab.) 
//		{
//			
//		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int selection = 0;
			
		Object[][] pizzas = getTablaeauPizzas();
		
		do 
		{
			
			System.out.println("***** Pizzeria Administration *****"); 
			
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			selection =  sc.nextInt();
			
			
			switch (selection) {
			case 1:
				{
					System.out.println("\nListe des pizzas\n");
					System.out.println("******************");
					afficherPizza(pizzas);
					System.out.println("******************\n");
				}
				break;

			case 2:
				{
					System.out.println("\nAjout d’une nouvelle pizza\n");
				}
			break;
			
			case 3:
				{
					System.out.println("\nMise à jour d’une pizza\n");
				}
			break;
			
			case 4:
				{
					System.out.println("\nSuppression d’une pizza\n");
				}
			break;
			
			case 99:
				{
					System.out.println("\nAu revoir :(\n");
				}
			break;
			
			default:
				{
					System.out.println("Veillez entrer un numéro de la liste fournie.\n");
				}
				break;
			} // switch
			
			
			
		} while (selection != 99);
		
		sc.close();
		
	}

	

}
