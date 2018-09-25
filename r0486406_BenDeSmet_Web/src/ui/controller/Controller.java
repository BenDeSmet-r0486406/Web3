package ui.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.model.Person;
import domain.model.Product;
import domain.service.ShopService;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopService service = new ShopService();
	
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
		String destination;
		String action = request.getParameter("action");
		switch(action){
		case "overview":
			destination = overview(request,response);
			break;
		case "ProductOverview":
			destination = ProductOverview(request,response);
			break;
		case "signUp":
			destination = "signUp.jsp";
			break;
		case "ADD":
			destination = ADD(request,response);
			break;
		case "addProduct":
			destination = "AddProduct.jsp";
			break;
		case "ADDProduct":
			destination = ADDProduct(request,response);
			break;
		case "updateProduct":
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			destination = "productUpdate.jsp";
			break;
		case "UPDATEproduct":
			destination = UPDATEproduct(request,response);
			break;
		case "deleteperson":
			destination = deletePerson(request, response);
			break;
		case "deleteproduct":
			destination = deleteProduct(request, response);
			break;
		case "passwordCheck":
			destination = passwordCheck(request, response);
			break;
		case "passwordCheck2":
			try{
				destination = passwordCheck2(request, response);
			}catch(NoSuchAlgorithmException e){
				throw new IllegalArgumentException("password check2 controller");
			}
			break;
		case "orderBy":
			destination = order(request, response);
			break;
		default:
			destination = "index.jsp";
			break;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
	}
	
	private String deletePerson(HttpServletRequest request, HttpServletResponse response) {
		service.deletePerson(request.getParameter("id"));
		return overview(request, response);
	}
	
	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		service.deleteProduct(request.getParameter("id"));
		return ProductOverview(request, response);
	}
	
	private String overview(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("service", service.getPersons() );
		return "personoverview.jsp";
	}
	
	private String order(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("service", service.getPersonsOrdered() );
		return "personoverview.jsp";
	}
	
	private String ProductOverview(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("service", service.getProducts() );
		return "productoverview.jsp";
	}
	
	private String ADD(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Person person = new Person (userId,email,password,firstName,lastName);
		service.addPerson(person);
		return overview(request, response);
	}
	
	private String ADDProduct(HttpServletRequest request, HttpServletResponse response) {
		String destination;
		Product product = new Product();
		ArrayList<String> result = new ArrayList<>();

		getId(product, request, result);
		getDescription(product, request, result);
		getPrice(product, request, result);
		getWaardering(product, request, result);
		
		if (result.size() > 0) {
			request.setAttribute("error", result);
			destination = "AddProduct.jsp";
		} else {
			service.addProduct(product);
			destination = ProductOverview(request, response);
		}
		return destination;
	}

	private void getId(Product product, HttpServletRequest request, ArrayList<String> result) {
		String id = request.getParameter("productid");
		try {
			product.setId(id);
			request.setAttribute("vorigeID", id);
		} catch (Exception e) {
			result.add(e.getMessage());
		}
	}

	private void getDescription(Product product, HttpServletRequest request, ArrayList<String> result) {
		String discription = request.getParameter("description");
		try {
			product.setDescription(discription);
			request.setAttribute("vorigeDiscription", discription);
		} catch (Exception e) {
			result.add(e.getMessage());
		}

	}

	private void getPrice(Product product, HttpServletRequest request, ArrayList<String> result) {

		try {
			double price = Double.parseDouble(request.getParameter("price"));
			product.setPrice(price);
			request.setAttribute("vorigePrice", price);

		} catch (NumberFormatException e) {
			result.add("price");

		} catch (Exception e) {
			result.add(e.getMessage());
		}

	}
	
	private void getWaardering(Product product, HttpServletRequest request, ArrayList<String> result) {

		try {
			int waardering = Integer.parseInt(request.getParameter("waardering"));
			product.setWaardering(waardering);
			request.setAttribute("vorigeWaardering", waardering);

		} catch (NumberFormatException e) {
			result.add("waardering");

		} catch (Exception e) {
			result.add(e.getMessage());
		}

	}
	
	private String UPDATEproduct(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String waardering = request.getParameter("waardering");
		double priceD = Double.parseDouble(price);
		int Waardering = Integer.parseInt(waardering);
		Product product = new Product(id,description, priceD, Waardering);
		service.updateProducts(product);
		return ProductOverview(request, response) ;
	}
	
	private String passwordCheck(HttpServletRequest request, HttpServletResponse response) {
		String destination ="checkPassword.jsp";
		String password = request.getParameter("password");
		String userid = request.getParameter("id");
		request.setAttribute("password", password);
		request.setAttribute("userid", userid);
		return destination;	
	}
	
	private String passwordCheck2(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		String destination;
		String password = request.getParameter("password");
		String userid = request.getParameter("userid");
		if(password == null || password.isEmpty()){
			request.setAttribute("error", "password cannot be empty");
			destination=passwordCheck(request, response);
		} 
		else if(!service.getPerson(userid).isCorrectPassword(password)){
			destination=passwordCheck(request, response);
			request.setAttribute("error", "password is not correct");
		} 
		else{
			destination="checkPasswordConfirmation.jsp";
		}
		
		return destination;
		
	}
}
