package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
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

public class EditerPizzaController extends HttpServlet {

	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	private static final Logger LOG = Logger.getLogger(EditerPizzaController.class.toString());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String code = req.getParameter("code");
		
		if (StringUtils.isBlank(code)) {
			resp.sendRedirect("/pizzas/list?msgErrreur=Pizza non trouvée");
		} else {
			try {
				
				Optional<Pizza> pizzaOpt = pizzaDao.findAllPizzas()
						.stream()
						.filter(p->code.equals(p.getCode()))
						.findFirst();
				
				if (pizzaOpt.isPresent()) {
					req.setAttribute("pizza", pizzaOpt);
					Pizza p = pizzaOpt.get();
					req.setAttribute("pizza", p);
					resp.setStatus(200);
					
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
					dispatcher.forward(req, resp);
				}
			
			} catch (DaoException e) {
				resp.sendError(500, "Désolé :(");
				e.printStackTrace();
			} // try
		} // if code vide
		
		
		
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
					resp.setStatus(201);
					resp.sendRedirect(req.getContextPath() + "/pizzas/list");
				} catch (NumberFormatException e) {
					resp.sendError(500, "Désolé");	
				} catch (DaoException e) {
					resp.sendError(400, "Format requête KO");
				}
				
			}
			
		}

}
