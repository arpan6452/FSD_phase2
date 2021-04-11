package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String qry;
	private Connection mySQLConn;
	private Statement theStatement;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String productName = request.getParameter("productName");
		String productCatagory = request.getParameter("productCatagory");
		String productPrice = request.getParameter("productPrice");
		System.out.println(productName);
		System.out.println(productCatagory);
		System.out.println(productPrice);

		try {
			String mySQLDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mySQLDriver);
			String urltoConnect = "jdbc:mysql://localhost:3306/simplilearn_ecom";
			String dbUsername = "root";
			String dbPassword = "arpan@mySQL12";
			mySQLConn = DriverManager.getConnection(urltoConnect, dbUsername, dbPassword);
			//qry = "select * from products";
			qry = "INSERT INTO products ( productName, productCatagory, productPrice) VALUES (?,?,?)";
			try {
				PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
				//thePrepareStatement.setInt(1, 2);
				thePrepareStatement.setString(1, productName);
				thePrepareStatement.setString(2, productCatagory);
				thePrepareStatement.setInt(3, Integer.parseInt(productPrice));
				if (thePrepareStatement.executeUpdate() > 0)
					System.out.println("New product has been succesfully added");								 				 		
				} catch (SQLException e) {
				System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to initiate driver due to : " + e.getLocalizedMessage());
		} catch (SQLException e) {
			System.out.println("Unable to create connection due to : " + e.getLocalizedMessage());
		} 
		
		response.sendRedirect("index.jsp");
	}

}
