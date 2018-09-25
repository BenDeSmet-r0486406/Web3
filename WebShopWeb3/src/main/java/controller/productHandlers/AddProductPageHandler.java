package controller.productHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Role;

public class AddProductPageHandler extends RequestHandler {

	public AddProductPageHandler(List<Role> authorized) {
		super(authorized);
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("AddProduct.jsp").forward(request, response);

	}

}
