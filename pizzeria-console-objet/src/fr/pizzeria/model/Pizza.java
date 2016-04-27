package fr.pizzeria.model;

public class Pizza {

	int id;
	String code;
	String nom;
	double prix;
	static int nbPizzas;
	
	
	public static Pizza creerObjetPizza(String code, String nom, double prix)
	{
		Pizza p = new Pizza();
		p.code = code;
		p.nom = nom;
		p.prix = prix;
		Pizza.nbPizzas++;
		return p;
		
	}
	
}
