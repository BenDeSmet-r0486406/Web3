package controller.personHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Role;
import domain.service.ShopService;

public class confirmPayementHandler extends RequestHandler {

	public confirmPayementHandler(ShopService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	public confirmPayementHandler() {
		// TODO Auto-generated constructor stub
	}

	public confirmPayementHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public confirmPayementHandler(List<Role> authorized) {
		super(authorized);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("cart", null);
		request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
	}

}
