package controller.productHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Role;
import domain.service.ShopService;

public class ProductOverviewHandler extends RequestHandler {
	
	public ProductOverviewHandler(ShopService service, List<Role> authorized){
		super(service, authorized);
	}
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("service", service.getProducts() );
		request.getRequestDispatcher("productoverview.jsp").forward(request, response);
	}

}
