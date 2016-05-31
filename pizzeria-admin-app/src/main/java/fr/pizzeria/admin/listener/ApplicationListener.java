package fr.pizzeria.admin.listener;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger(ApplicationListener.class.getName());
	@Inject private PizzaService pizzaService;
   


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		init();
		
	}
	
//	@PostConstruct
	private void init() {
		Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE, null));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", BigDecimal.valueOf(14.00),  CategoriePizza.SANS_VIANDE, null));
		pizzas.put("REI", new Pizza("REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.VIANDE, null));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", BigDecimal.valueOf(12.00),  CategoriePizza.SANS_VIANDE, null));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE, null));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE, null));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE, null));
		pizzas.put("IND", new Pizza("IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE, null));
		pizzas.put("SAU", new Pizza("SAU", "La Saumonéta", BigDecimal.valueOf(14.00), CategoriePizza.POISSON, null));
		
		pizzas.values().forEach(p-> {
			try {
				pizzaService.savePizza(p);
			} catch (DaoException e) {
				LOG.log(Level.SEVERE, "Impossible d'insérer une pizza", e);
			}
		});
		
	}
	
}
