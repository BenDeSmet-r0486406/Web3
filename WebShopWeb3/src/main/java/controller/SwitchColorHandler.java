package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SwitchColorHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookie;
		Object object = null;
		
		for (Cookie c : cookies){
			if (c.getName() == "kleur"){
				object = c;
			}
		}
		
		if (object == null){
			cookie = new Cookie("kleur", "yellow");
			response.addCookie(cookie);
		} else {
			cookie = (Cookie) object;
		}
		
		if (cookie.getValue()== "red" || cookie.getValue()== "yellow"){
			request.setAttribute("kleur", cookie.getValue());
		} else {
			Cookie newCookie = new Cookie("kleur", "yellow");
			response.addCookie(newCookie);
			request.setAttribute("kleur", newCookie.getValue());
		}
		String redirect = "Controller?action=" + request.getParameter("currentPage");
		response.sendRedirect(redirect);

	}

}
