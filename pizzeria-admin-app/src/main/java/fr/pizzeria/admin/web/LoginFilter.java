package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

	private FilterConfig config = null;
	
	public LoginFilter() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = config;
		config.getServletContext().log("LoginFilter initialized");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String emailAuthentifie = (String) httpRequest.getSession(true).getAttribute("email");
		
		if (!httpRequest.getRequestURI().contains("/pizzeria") && !httpRequest.getRequestURI().contains("login") 
				&& emailAuthentifie.equals(null)) 
		{
			httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
