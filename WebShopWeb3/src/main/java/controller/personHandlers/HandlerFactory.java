package controller.personHandlers;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.HomeHandler;
import controller.RequestHandler;
import controller.SwitchColorHandler;
import controller.productHandlers.ADDProductHandler;
import controller.productHandlers.AddProductPageHandler;
import controller.productHandlers.AddToCartHandler;
import controller.productHandlers.DeleteProductHandler;
import controller.productHandlers.OrderHandler;
import controller.productHandlers.ProductOverviewHandler;
import controller.productHandlers.ShowCartHandler;
import controller.productHandlers.UpdateProductHandler;
import controller.productHandlers.UpdateProductPageHandler;
import controller.productHandlers.confirmCartHandler;
import domain.model.Role;
import domain.service.ShopService;

public class HandlerFactory {
	private Map<String, RequestHandler> handlers = new HashMap<>();
	
	
	public HandlerFactory(ShopService service){
		List<Role> administrators =  new ArrayList<Role>();
		administrators.add(Role.valueOf("ADMINISTRATOR"));
		List<Role> all =  new ArrayList<Role>();
		all.add(Role.valueOf("ADMINISTRATOR"));
		all.add(Role.valueOf("CUSTOMER"));
		
		handlers.put("home", new HomeHandler());
		handlers.put("signUp", new SignUpHandler());
		handlers.put("ProductOverview", new ProductOverviewHandler(service, all));
		handlers.put("overview", new PersonOverviewHandler(service, administrators));
		handlers.put("ADD", new ADDPersonHandler(service));
		handlers.put("addProduct", new AddProductPageHandler(administrators));
		handlers.put("ADDProduct", new ADDProductHandler(service, administrators));
		handlers.put("updateProduct", new UpdateProductPageHandler(administrators));
		handlers.put("UPDATEproduct", new UpdateProductHandler(service, administrators));
		handlers.put("deleteperson", new DeletePersonHandler(service, administrators));
		handlers.put("deleteproduct", new DeleteProductHandler(service, administrators));
		handlers.put("orderBy", new OrderHandler(service, administrators));
		handlers.put("switchColor", new SwitchColorHandler());
		handlers.put("login", new LoginHandler(service));
		handlers.put("logout", new LogoutHandler(service, all));
		handlers.put("addToCart", new AddToCartHandler(service, all));
		handlers.put("showCart", new ShowCartHandler(service, all));
		handlers.put("confirmCart", new confirmCartHandler(service, all));
		handlers.put("confirmPayment", new confirmPayementHandler(service, all));
	}
	
	
	
	public RequestHandler getHandler(String key) {
		 return handlers.get(key);
	}

}
