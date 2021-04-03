package com.servletsscopes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sessionservlet
 */
public class Sessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sessionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String personalData = request.getParameter("personal");
		String password = request.getParameter("password");
		request.getSession(true).setAttribute("firstname", firstname);
		getServletContext().setAttribute("lastname", lastname);
		Cookie cookies = new Cookie("personalData", personalData);
		cookies.setMaxAge(3600);
		response.addCookie(cookies);		
		
		if(firstname.equals("admin")) {
			RequestDispatcher reqestDispatcher = request.getRequestDispatcher("index.jsp");
			reqestDispatcher.forward(request, response);
		}else {
			RequestDispatcher reqestDispatcher = request.getRequestDispatcher("DifferentServlet");
			reqestDispatcher.forward(request, response);
		}
	}

}
