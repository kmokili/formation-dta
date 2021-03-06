package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class CreerPizzaController extends HttpServlet {
	
	private static final String URL = "/pizzas/list";
	private static final String VUE_CREER_PIZZA = "/WEB-INF/views/pizzas/creerPizza.jsp";
	private static final Logger LOG = Logger.getLogger(CreerPizzaController.class.toString());
	
	@Inject private PizzaService pizzaService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		this.getServletContext().getRequestDispatcher(VUE_CREER_PIZZA).forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String cat = req.getParameter("categorie");
		
		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(prix) || StringUtils.isBlank(cat))  {
			resp.sendError(400, "Non non non ! Donnez-moi toutes les valeurs !");
			req.setAttribute("msgErreur", "Non non non ! Donnez-moi toutes les valeurs !");
			this.getServletContext().getRequestDispatcher(VUE_CREER_PIZZA).forward(req, resp);
		} else {
			Pizza newPizza = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.valueOf(cat));
			try {
				pizzaService.savePizza(newPizza);
				
				resp.setStatus(201);
				resp.sendRedirect(req.getContextPath() + URL);
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher(VUE_CREER_PIZZA);
				dispatcher.forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendError(500, "Désolé");	
			} catch (DaoException e) {
				resp.sendError(400, "Format requête KO");
			}
			
		}
			
	}

}
