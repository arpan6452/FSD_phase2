package com.multiservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(description = "This is the Hello World Servlet. Used to test the application.", urlPatterns = {
"/servlet1" })
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		
		if(username.equals("")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Servlet2");			
			requestDispatcher.forward(request, response);
		}else if(username.equalsIgnoreCase("admin")) {
			//redirected to another servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Servlet2");
			PrintWriter writer = response.getWriter();
			writer.println("Welcome : " + username);
			requestDispatcher.include(request, response);
		}else {
			//redirected to other jsp page
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			response.getWriter().println("Welcome : " + username +"<br>");
			requestDispatcher.include(request, response);
		}
	}

}
