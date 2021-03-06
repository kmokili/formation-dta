package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	
	private static final String VUE_LISTER_PIZZA = "/WEB-INF/views/pizzas/listerPizzas.jsp";
	@Inject private PizzaService pizzaService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			List<Pizza> listPizzas = this.pizzaService.findAllPizzas();
			req.setAttribute("listePizzas", listPizzas);
			
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher(VUE_LISTER_PIZZA);
			dispatcher.forward(req, resp);
		
		} catch (DaoException e) {
			resp.sendError(500, "Désolé :(");
			e.printStackTrace();
		}
	}

}
