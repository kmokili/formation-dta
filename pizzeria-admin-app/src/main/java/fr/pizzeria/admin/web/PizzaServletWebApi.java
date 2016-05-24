package fr.pizzeria.admin.web;


import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;


public class PizzaServletWebApi extends HttpServlet {

	private IPizzaDao pizzaDao = new PizzaDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			List<Pizza> listPizzas = pizzaDao.findAllPizzas();
			resp.getWriter().write(listPizzas.toString());
		} catch (DaoException e) {
			resp.sendError(500, "Désolé :(");
			e.printStackTrace();
		}
	}

}
