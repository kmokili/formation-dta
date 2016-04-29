package fr.pizzeria.model;

public class Pizza {

	private int id;
	@ToString
	private String code;
	@ToString
	private String nom;
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
		return this.getCode() + " -> " + this.getNom() + " (" + this.getPrix() + ") " + this.getCategorie().getLibelle();

	}

}