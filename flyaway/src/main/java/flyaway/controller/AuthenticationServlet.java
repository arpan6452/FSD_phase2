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

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet(description = "This is the Authentication Servlet. Used to check whether the user is logged in or out a valid user or need to register or an admin.", urlPatterns = {
"/AuthenticationServlet" })
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		User user = (User)request.getSession(false).getAttribute("user");
		if(user == null) {
			System.out.println(request.getSession(false));
			response.sendRedirect("index.jsp");
		}else  {
			if(user.getRole().getName().equals(RoleName.ROLE_ADMIN)) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminPanel.jsp");
				requestDispatcher.forward(request, response);
			}else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/FlightDetails.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
