package controller.productHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Cart;
import domain.model.ProductOrder;
import domain.model.Role;
import domain.service.ShopService;

public class ShowCartHandler extends RequestHandler {

	public ShowCartHandler(ShopService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	public ShowCartHandler() {
		// TODO Auto-generated constructor stub
	}

	public ShowCartHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public ShowCartHandler(List<Role> authorized) {
		super(authorized);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		List<ProductOrder> products= cart.getProductsOrdered();
		double totalPrice = cart.getTotalPrice();
		
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("products", products);

		request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
	}

}
