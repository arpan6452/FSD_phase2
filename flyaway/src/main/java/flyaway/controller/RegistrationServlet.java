package flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flyaway.model.RoleName;
import flyaway.model.User;
import flyaway.services.UserOperations;

@WebServlet(description = "This is Registration Servlet.This helps to register an user to the Application using correct user details.", urlPatterns = {
		"/RegistrationServlet" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("password").equals(request.getParameter("psw-repeat"))) {
			String role = "NA";
			try {
				String username = request.getParameter("email");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				role = request.getParameter("role");
				String password = request.getParameter("password");
				UserOperations userOperations = new UserOperations();
				User user = userOperations.createUser(username, firstName, lastName, password, role);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);				
			} catch (Exception e) {
				response.setContentType("text/html");
				response.getWriter().print("<h2 style=\"margin-left: 10px;color: red;\">Incorrect field details.</h2>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Registration.jsp");
				requestDispatcher.include(request, response);
			}
			if (role.equals("Admin")) {				
				response.sendRedirect("AdminPanel.jsp");
			} else {				
				response.sendRedirect("FlightConfirmation.jsp");
			} 
		} else {
			response.setContentType("text/html");
			response.getWriter().print(
					"<h2 style=\"margin-left: 10px;color: red;\">Password and Re entered password didn't match.Please fill out the form again.</h2>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Registration.jsp");
			requestDispatcher.include(request, response);

		}
	}

}
