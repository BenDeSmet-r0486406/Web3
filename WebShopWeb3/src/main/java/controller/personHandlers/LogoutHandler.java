package controller.personHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.RequestHandler;
import domain.model.Role;
import domain.service.ShopService;

public class LogoutHandler extends RequestHandler {

	public LogoutHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public LogoutHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		response.sendRedirect("Controller?action=home");

	}

}
