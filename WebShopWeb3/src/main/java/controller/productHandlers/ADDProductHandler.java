package controller.productHandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Product;
import domain.model.Role;
import domain.service.ShopService;

public class ADDProductHandler extends RequestHandler {

	public ADDProductHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
	}

	public ADDProductHandler() {
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		ArrayList<String> result = new ArrayList<>();

		
		String id = request.getParameter("productid");
		try {
			product.setId(id);
			request.setAttribute("vorigeID", id);
		} catch (Exception e) {
			result.add(e.getMessage());
		}
		
		String discription = request.getParameter("description");
		try {
			product.setDescription(discription);
			request.setAttribute("vorigeDiscription", discription);
		} catch (Exception e) {
			result.add(e.getMessage());
		}
		
		try {
			double price = Double.parseDouble(request.getParameter("price"));
			product.setPrice(price);
			request.setAttribute("vorigePrice", price);

		} catch (NumberFormatException e) {
			result.add("price");

		} catch (Exception e) {
			result.add(e.getMessage());
		}
		
		try {
			int waardering = Integer.parseInt(request.getParameter("waardering"));
			product.setWaardering(waardering);
			request.setAttribute("vorigeWaardering", waardering);

		} catch (NumberFormatException e) {
			result.add("waardering");

		} catch (Exception e) {
			result.add(e.getMessage());
		}
		
		if (result.size() > 0) {
			request.setAttribute("error", result);
			response.sendRedirect("Controller?action=addProduct");
		} else {
			service.addProduct(product);
			response.sendRedirect("Controller?action=ProductOverview");
		}
	}

}
