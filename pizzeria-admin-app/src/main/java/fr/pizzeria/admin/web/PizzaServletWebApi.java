package fr.pizzeria.admin.web;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaServletWebApi extends HttpServlet {
	
	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String cat = req.getParameter("categorie");
		
		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(prix) || StringUtils.isBlank(cat))  {
			resp.sendError(400, "Non non non ! Donnez-moi toutes les valeurs !");
		} else {
			Pizza newPizza = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.valueOf(cat));
			try {
				pizzaDao.savePizza(newPizza);
				LOG.info("Nouvelle pizza créée");
			} catch (NumberFormatException e) {
				resp.sendError(500, "Désolé");	
			} catch (DaoException e) {
				resp.sendError(400, "Format requête KO");
			}
			
		}
		
		
	}
	
	
}
