package fr.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzera.dao")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repository")
public class SpringJpaConfig {

	
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().
	            setType(EmbeddedDatabaseType.H2).
	            addScript("db-schema.sql").
	            addScript("db-data.sql").
	            build();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean v = new LocalEntityManagerFactoryBean();
		v.setPersistenceUnitName("pizza-db");
		return v;
	}
}
