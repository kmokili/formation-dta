package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJDBC;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;

@Configuration
@ComponentScan("fr.pizzeria")
public class PizzeriaAppSpringConfig {

		
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//		 return Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");	
//	}
	
//	@Bean
//	public IPizzaDao pizzaDaoJpa(EntityManagerFactory emf) {
//		return new PizzaDaoJpa(emf);	
//	}
	
//	@Bean
//	public IPizzaDao pizzaDaoImpl() {
//		return new PizzaDaoImpl();	
//	}
	
	@Bean
	public PropertyPlaceholderConfigurer props(){
		PropertyPlaceholderConfigurer co = new PropertyPlaceholderConfigurer();
		co.setLocation(new ClassPathResource("jdbc.properties"));
		return co;
	}
	
	
	@Bean
	public IPizzaDao pizzaDaoJDBC() throws DaoException {
		return new PizzaDaoJDBC();	
	}
	
	
	
}
