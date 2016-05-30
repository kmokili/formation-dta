package fr.pizzeria.admin.web.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RestAuthFilter implements ContainerRequestFilter {

	@Inject 
	private TokenService tokenService;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token = requestContext.getHeaderString("auth");

		if(!tokenService.isTokenValid(token)
				&& !requestContext.getUriInfo().getPath().contains("/login")) {
			// non authentifié
			requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
		}
	}
}
