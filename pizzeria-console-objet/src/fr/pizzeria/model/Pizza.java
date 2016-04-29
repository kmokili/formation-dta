package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {

	private int id;
	@ToString private String code;
	@ToString(uppercase = true) private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;
	public static int nbPizzas;
	

	public Pizza() {
		

	}

	public Pizza(String code, String nom, double prix) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		String value = "";
		Field[] champs = Pizza.class.getDeclaredFields();
		
		for (Field f : champs)
		{
			ToString annotation = f.getAnnotation(ToString.class);
			if (annotation != null)
			{
				try 
				{
					{
						boolean uppercase = annotation.uppercase();
						Object valeurDuChamp = f.get(this);
						value += uppercase ? valeurDuChamp.toString().toUpperCase() : valeurDuChamp + " ";
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					
				}
			} // if	
		 } // for		
		return value;

	}

}