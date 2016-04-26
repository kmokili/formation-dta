package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***** Application Opérateurs *****"); 
		
		System.out.println("Veuillez saisir le premier nombre…");
		double nombre1 = sc.nextDouble();
		System.out.println("Veuillez saisir le second nombre…");
		double nombre2 = sc.nextDouble();
		
		System.out.println(nombre1 + " + " + nombre2 + " = " + (nombre1 + nombre2));
		System.out.println(nombre1 + " - " + nombre2 + " = " + (nombre1 - nombre2));
		System.out.println(nombre1 + " * " + nombre2 + " = " + (nombre1 * nombre2));
		System.out.println(nombre1 + " / " + nombre2 + " = " + (nombre1 / nombre2));
		System.out.println(nombre1 + " % " + nombre2 + " = " + (nombre1 % nombre2));
		
		
		sc.close();
	}

}
