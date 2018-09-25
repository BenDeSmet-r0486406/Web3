package controller.personHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Person;
import domain.service.ShopService;

public class ADDPersonHandler extends RequestHandler {

	public ADDPersonHandler(ShopService service) {
		super(service);
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Person person = new Person (userId,email,password,firstName,lastName);
		service.addPerson(person);
		response.sendRedirect("Controller?action=overview");
	}

}
