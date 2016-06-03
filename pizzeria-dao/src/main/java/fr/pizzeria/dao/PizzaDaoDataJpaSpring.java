package fr.pizzeria.dao;

import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.repository.IPizzaRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoDataJpaSpring implements IPizzaDao {
	
	@Autowired private IPizzaRepository pizzaRepository;

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		return pizzaRepository.findAll();
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		pizzaRepository.save(newPizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		Pizza p = pizzaRepository.findByCode(codePizza);
		p = updatePizza;
		pizzaRepository.save(p);
		
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		Pizza p = pizzaRepository.findByCode(codePizza);
		pizzaRepository.delete(p);
	}

	@Override
	public void saveAllPizzas(List<Pizza> listPizzas, int nb) throws DaoException {
		listPizzas.sort(Comparator.comparing(Pizza::getCode));
		ListUtils.partition(listPizzas, nb).forEach(list -> {
			list.forEach(pizzaRepository::save);			
		});
	}

	@Override
	public Pizza findOnePizza(String code) throws DaoException {
		return pizzaRepository.findByCode(code);
//		return IPizzaDao.super.findOnePizza(code);
	}

	
}
