package controller.personHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Role;
import domain.service.ShopService;

public class PersonOverviewHandler extends RequestHandler {
	
	public PersonOverviewHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
	}
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("service", service.getPersons() );
		request.getRequestDispatcher("personoverview.jsp").forward(request, response);
	}

}
