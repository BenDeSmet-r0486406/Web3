package controller.productHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestHandler;
import domain.model.Cart;
import domain.model.Product;
import domain.model.Role;
import domain.service.ShopService;

public class AddToCartHandler extends RequestHandler {

	public AddToCartHandler(ShopService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	public AddToCartHandler() {
		// TODO Auto-generated constructor stub
	}

	public AddToCartHandler(ShopService service, List<Role> authorized) {
		super(service, authorized);
		// TODO Auto-generated constructor stub
	}

	public AddToCartHandler(List<Role> authorized) {
		super(authorized);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Product product = null;
		List<Product> products = service.getProducts();
		String quantityString= request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityString);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		for(Product p : products){
			if(p.getId().equals(id)){
				product = p;
			}
		}
		if (cart==null){
			cart = new Cart();
			cart.addProduct(product, quantity);
		} else {
			cart.addProduct(product, quantity);
		}
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("Controller?action=ProductOverview");
	}

}
