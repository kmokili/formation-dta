package fr.pizzeria.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private IPizzaDao pizzaDao;

//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseBody
//	public String bonjour() {
//		return "vuebonjour";
//	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> findAllPizza() throws DaoException {
//		List<Pizza> pizze = pizzaDao.findAllPizzas();
//		return pizze; 
		return pizzaDao.findAllPizzas();
	}
}
