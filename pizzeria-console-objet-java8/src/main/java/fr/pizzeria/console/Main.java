package fr.pizzeria.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context 
				= new ClassPathXmlApplicationContext("config.xml")) {
			AfficherMenu menu = context.getBean(AfficherMenu.class);
			menu.afficher();
		}

	}

}
