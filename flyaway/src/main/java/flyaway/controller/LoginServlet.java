package flyaway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flyaway.model.Role;
import flyaway.model.RoleName;
import flyaway.model.User;
import flyaway.services.UserOperations;

@WebServlet(description = "This is Login Servlet.This helps to login to Application using correct username and password.", urlPatterns = {
"/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserOperations userOperations = new UserOperations();
		List list = userOperations.searchUser(username, password);
		if(list.size()>0) {
			User user = (User) list.get(0);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);			
			
			Role role = (Role)user.getRole();
			if(role.getName().equals(RoleName.ROLE_ADMIN)) {				
				response.sendRedirect("AdminPanel.jsp");
			}else {
				response.sendRedirect("HomePage.jsp");
			}
		}else {
			response.setContentType("text/html");
			response.getWriter().print(
					"<h2 style=\"margin-left: 10px;color: red;\">Incorrect Credentials</h2>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.include(request, response);
		}
		
	}

}
