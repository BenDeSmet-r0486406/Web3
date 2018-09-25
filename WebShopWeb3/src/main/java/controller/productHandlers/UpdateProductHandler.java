package controller.productHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Product;
import domain.model.Role;
import domain.service.ShopService;

public class UpdateProductHandler extends RequestHandler {

	public UpdateProductHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public UpdateProductHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String waardering = request.getParameter("waardering");
		double priceD = Double.parseDouble(price);
		int Waardering = Integer.parseInt(waardering);
		Product product = new Product(id,description, priceD, Waardering);
		service.updateProducts(product);
		response.sendRedirect("Controller?action=ProductOverview");
	}

}
