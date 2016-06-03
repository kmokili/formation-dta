package fr.pizzeria.dao;

import static org.junit.Assert.*;

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
import fr.pizzeria.model.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SpringJpaConfig.class, SpringAopConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PizzaPerformanceTest {

    @Autowired @Qualifier("pizzaDaoJpaData") IPizzaDao pizzaDao;
    @Autowired IPerformanceRepository performanceRepository;

    @Test
    public void testfindAllPizzas() throws DaoException {
        pizzaDao.findAllPizzas();
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(System.out::println);

        assertEquals(1, performances.size());
        assertEquals("IPizzaDao.findAllPizzas()", performances.get(0).getService());

    }
}