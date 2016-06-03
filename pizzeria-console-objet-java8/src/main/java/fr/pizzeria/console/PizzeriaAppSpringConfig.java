package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repository")
public class PizzeriaAppSpringConfig {

		
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		 return Persistence.createEntityManagerFactory("pizzeria-console-objet-java8");	
	}
	
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
	
	
//	@Bean
//	public IPizzaDao pizzaDaoJDBC() throws DaoException {
//		return new PizzaDaoJDBC();	
//	}
	
	@Bean
	public DataSource dataSource(@Value("${jdbc.url}") String url, @Value("${jdbc.user}") String user, @Value("${jdbc.pass}") String motDePasse){
		return new DriverManagerDataSource(url, user, motDePasse);
	}
	/*
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	*/
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	/*
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("fr.pizzeria");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	*/
}
