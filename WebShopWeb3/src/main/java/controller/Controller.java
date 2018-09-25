package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.personHandlers.HandlerFactory;
import domain.service.ShopService;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopService service;
	private HandlerFactory handlerFactory;
	
	@Override
	public void init() throws ServletException{
		super.init();
		
		ServletContext context = getServletContext();
		
		Properties properties = new Properties();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while (parameterNames.hasMoreElements()){
			String propertyName = parameterNames.nextElement();
			properties.setProperty(propertyName, context.getInitParameter(propertyName));
		}
		
		service = new ShopService(properties);
		handlerFactory = new HandlerFactory(service);
	}
	
	
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setColour(request, response);
		String action = request.getParameter("action");
		if(action.equals("changeColour")) {
			action = changeColour(request, response);
		}else{
			RequestHandler handler = handlerFactory.getHandler(action);
			handler.handle(request, response);
		}
		
	}
	
	private Cookie getColourCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			 return createCookie("colourCookie", "red.css", response);
		} else {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("colourCookie")) {
					return cookies[i];
				}
			}
			
			return createCookie("colourCookie", "red.css", response);
		}		
	}	
	
	private Cookie createCookie(String name, String value, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
		return cookie;
	}

	private void setColour(HttpServletRequest request, HttpServletResponse response) {
		Cookie colourCookie = getColourCookie(request, response);
		request.setAttribute("cssFile", colourCookie.getValue());
	}

	private String changeColour(HttpServletRequest request, HttpServletResponse response) {
		Cookie colourCookie = getColourCookie(request, response);
		
		String newValue;
		
		if(colourCookie.getValue().equals("red.css")) {
			newValue = "yellow.css";
		} else {
			newValue = "red.css";
		}
		
		createCookie("colourCookie", newValue, response);
		request.setAttribute("cssFile", newValue);

		return request.getParameter("currentPage");
	}
}
