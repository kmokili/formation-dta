package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJDBC;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;

@Configuration
@ComponentScan("fr.pizzeria")
public class PizzeriaAppSpringConfig {

	private IPizzaDao pizzaDao;
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		 return Persistence.createEntityManagerFactory("pizzeria-dao");	
	}
	
	@Bean
	public PizzaDaoJpa pizzaDaoJpa(EntityManagerFactory emf) {
		return new PizzaDaoJpa(emf);	
	}
	
	@Bean
	public PizzaDaoImpl pizzaDaoImpl() {
		return new PizzaDaoImpl();	
	}
	
	@Bean
	public PizzaDaoJDBC pizzaDaoJDBC() throws DaoException {
		return new PizzaDaoJDBC(null, null, null, null);	
	}
	
	
	
}
