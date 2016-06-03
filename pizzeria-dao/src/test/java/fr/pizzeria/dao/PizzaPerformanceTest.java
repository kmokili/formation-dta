package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.SpringAopConfig;
import fr.pizzeria.config.SpringConfig;
import fr.pizzeria.config.SpringJpaConfig;
import fr.pizzeria.dao.repository.IPerformanceRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SpringJpaConfig.class, SpringAopConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PizzaPerformanceTest {

    @Autowired @Qualifier("pizzaDaoJpaSpring") IPizzaDao pizzaDao;
    @Autowired IPerformanceRepository performanceRepository;

    @Test
    public void testfindAllPizzas() throws DaoException {
        pizzaDao.findAllPizzas();
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(System.out::println);

        assertEquals(1, performances.size());
        assertEquals("IPizzaDao.findAllPizzas()", performances.get(0).getService());

    }
    
    @Test
    public void testSavePizza() throws DaoException {
        Pizza pizza = new Pizza(null, "PEP X", "Pépéroni X", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE, "http://placehold.it/150x150");
        pizzaDao.savePizza(pizza);
        
        pizzaDao.findAllPizzas();
        Pizza pizzaResult = pizzaDao.findOnePizza("PEP X");
        
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(System.out::println);

        assertEquals(3, performances.size());
        assertEquals("IPizzaDao.savePizza(..)", performances.get(0).getService());
        assertEquals("IPizzaDao.findAllPizzas()", performances.get(1).getService());
        assertEquals("IPizzaDao.findOnePizza(..)", performances.get(2).getService());
    }
    
    @Test
    public void testUpdatePizza() throws DaoException {
        Pizza onePizza = pizzaDao.findOnePizza("PEP");
        onePizza.setNom("Pépéroni 2");
        pizzaDao.updatePizza("PEP", onePizza);

        Pizza pizzaResult = pizzaDao.findOnePizza("PEP");
        assertEquals("Pépéroni 2", pizzaResult.getNom());
        
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(System.out::println);

        assertEquals(3, performances.size());
        assertEquals("IPizzaDao.findOnePizza(..)", performances.get(0).getService());
        assertEquals("IPizzaDao.updatePizza(..)", performances.get(1).getService());
        assertEquals("IPizzaDao.findOnePizza(..)", performances.get(2).getService());
    }
    
    
}