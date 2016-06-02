package fr.pizzeria.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

//@Configuration
//@ComponentScan("fr.pizzeria")
public class PizzaDaoSpringTest {
	
	@Bean
	public DataSource dadaSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql").build();
	}
}
