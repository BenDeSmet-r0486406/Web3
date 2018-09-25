package controller.personHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.RequestHandler;
import domain.model.Person;
import domain.service.ShopService;

public class LoginHandler extends RequestHandler {

	public LoginHandler(ShopService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	public LoginHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (service.getUserIfAuthenticated(userid, password) != null){
			Person user = (Person) service.getUserIfAuthenticated(userid, password);
			session.setAttribute("user", user);
			
			response.sendRedirect("Controller?action=home");
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
