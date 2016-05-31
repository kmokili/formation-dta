package fr.pizzeria.console;

public class AfficherMenu {

	private String val;
	
	public AfficherMenu(String value) {
		val = value;
	}

	
	public void afficher() {
		System.out.println("Menu " + val);
		System.out.println("Option 1");
		System.out.println("Option 2");
	}
}
