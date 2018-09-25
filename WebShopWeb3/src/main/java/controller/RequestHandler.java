package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Person;
import domain.model.Role;
import domain.service.ShopService;

public abstract class RequestHandler {

	protected ShopService service;
	private List<Role> authorized = null;
	
	public RequestHandler(ShopService service)
	{
		this.service = service;
	}
	
	public RequestHandler()
	{
		
	}
	
	public RequestHandler(ShopService service, List<Role> authorized)
	{
		this.service = service;
		this.authorized = authorized;
	}
	
	public RequestHandler( List<Role> authorized)
	{
		this.authorized = authorized;
	}
	
	private void checkRole(HttpServletRequest request, List<Role> roles){
		HttpSession session = request.getSession(false);
		Person user = (Person) session.getAttribute("user");
		if (user == null ){
			throw new NotAuthorizedException("there is no user");
		} else if (roles.contains(user.getRole())){
			session.setAttribute("role", user.getRole());
		} else {
			throw new NotAuthorizedException("user is not authorized");
		}
		
	}
	
	public final void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(authorized != null){
			checkRole(request, authorized);
		}
		handleRequest(request, response);
	}

	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
