<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form action="ProductServlet" method="post">
		Product Name:<input type="text" name="productName"
			placeholder="Product Name"><br> 
		Product Category: <select
				name="productCatagory" id="productCatagory">
				<option>Male</option>
				<option>Female</option>
				<option>Children</option>
			</select><br> 
		Product Price:<input type="number" name="productPrice"
			placeholder="Product Price"><br> <input type="submit"
			value="Create">
	</form>

	<br>
	<%
	String id = "";

	String driverName = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "simplilearn_ecom";
	String userId = "root";
	String password = "arpan@mySQL12";
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	try {
		connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
		statement = connection.createStatement();

		String qry = "SELECT * FROM products;";
		ResultSet resultSet = statement.executeQuery(qry);
	%>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Products</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Product Price</th>
			</tr>
			
			<%
			while (resultSet.next()) {
				%>
				<tr>
				<td><%= resultSet.getInt("product_id") %></td>
				<td><%= resultSet.getString("productName") %></td>
				<td><%= resultSet.getString("productCatagory") %></td>
				<td><%= resultSet.getInt("productPrice") %></td>
				</tr>
				<%
			}
			%>
			
		</table>
	</div>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	<%-- <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/simplilearn_ecom" user="root" password="arpan@mySQL12" />
	<sql:query var="listProducts" dataSource="${myDS}">
    SELECT * FROM products;
	</sql:query>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of users</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Product Price</th>
			</tr>
			<c:forEach var="product" items="${listProducts.rows}">
				<tr>
					<td><c:out value="${product.product_id}" /></td>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value="${product.productCatagory}" /></td>
					<td><c:out value="${product.productPrice}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div> --%>

</body>
</html>
