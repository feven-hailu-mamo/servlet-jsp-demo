package com.servlet.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.demo.dto.User;
import com.servlet.demo.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userId, password;
      userId = request.getParameter("userId");
    		  password = request.getParameter("password");
     LoginService loginService = new LoginService();
    boolean result = loginService.authenticate(userId, password);
//one way is to redirect
//In this case the browser makes another request to the success.jsp page, that is why we use the session object to pass the user
//    if(result) {
//		User user = loginService.getUserDetails(userId);
//		request.getSession().setAttribute("user", user);
//		response.sendRedirect("success.jsp");
//		return;
//	}
    
//another way is to use RequestDispatcher
//instead of the client or the browser redirect and make a new request to success.jsp page 
//the server make the request internally using the dispatcher directly
	 if(result) {
		User user = loginService.getUserDetails(userId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
		return;
	}
   else {
		response.sendRedirect("Login.jsp");
		return;
	}
		
	}

}
