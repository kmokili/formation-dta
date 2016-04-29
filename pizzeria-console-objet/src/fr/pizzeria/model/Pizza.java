package fr.pizzeria.model;

public class Pizza implements Comparable<Pizza>{

	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int nbPizzas;

	public Pizza() {
		// this("jjj","hhhh",12.0);
		// super();

	}

	public Pizza(String code, String nom, double prix) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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


	@Override
	public int compareTo(Pizza o) {
		// TODO Auto-generated method stub
		return 0;
	}

}