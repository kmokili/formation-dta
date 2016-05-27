package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
