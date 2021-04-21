package flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flyaway.model.User;
import flyaway.services.UserOperations;

@WebServlet(description = "This is the ChangePassword Servlet. Used to change password for admin.", urlPatterns = {
		"/ChangePassword" })
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPass");
		String newPassword = request.getParameter("newPass");
		String re_newPassword = request.getParameter("renewPass");
		User user = (User)request.getSession(false).getAttribute("user");
		if (oldPassword.equals(user.getPassword())) {
			if (newPassword.equals(re_newPassword)) {
				UserOperations userOperations = new UserOperations();
				int hasUpdated = userOperations.updatePassword(user.getEmail(),
						newPassword);
				if (hasUpdated > 0) {
					user.setPassword(newPassword);
					request.getSession(false).setAttribute("user", user);
					response.setContentType("text/html");
					response.getWriter().print(
							"<h2 style=\"margin-left: 10px;color: red;\">Password successfully updated.</h2>");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminPanel.jsp");
					requestDispatcher.include(request, response);
				} else {
					response.setContentType("text/html");
					response.getWriter().print(
							"<h2 style=\"margin-left: 10px;color: red;\">Password didn't updated successfully</h2>");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ChangePassword.jsp");
					requestDispatcher.include(request, response);
				}
			} else {
				response.setContentType("text/html");
				response.getWriter().print(
						"<h2 style=\"margin-left: 10px;color: red;\">Password and Re entered password didn't match.</h2>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ChangePassword.jsp");
				requestDispatcher.include(request, response);
			}
		} else {
			response.setContentType("text/html");
			response.getWriter()
					.print("<h2 style=\"margin-left: 10px;color: red;\">The current password is mis-matching.</h2>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ChangePassword.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
