package controller.personHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Role;
import domain.service.ShopService;

public class DeletePersonHandler extends RequestHandler {

	public DeletePersonHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public DeletePersonHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service.deletePerson(request.getParameter("id"));
		response.sendRedirect("Controller?action=overview");

	}

}
