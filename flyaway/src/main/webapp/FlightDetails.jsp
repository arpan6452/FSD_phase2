<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="flyaway.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#userDetails {
	float: left;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 55%;
}

#userDetails td, #userDetails th {
	border: 1px solid #ddd;
	padding: 8px;
}

#userDetails tr:nth-child(even) {
	background-color: #f2f2f2;
}

#userDetails tr:hover {
	background-color: #ddd;
}

#userDetails th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #3f51b5;
	color: white;
}

#flightDetails {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 30%;
	/* margin-left: 30%; */
	float: right;
	/* margin-top: 12%; */
}

#flightDetails td, #flightDetails th {
	border: 1px solid #ddd;
	padding: 8px;
}

#flightDetails tr:nth-child(even) {
	background-color: #f2f2f2;
}

#flightDetails tr:hover {
	background-color: #ddd;
}

#flightDetails th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #3f51b5;
	color: white;
}

.bookNowButton {
	float: right;
	border: none;
	color: white;
	/* padding: 10px 28px; */
	padding: 17px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;
}
</style>
</head>
<body>
<jsp:include page="TopNav.jsp" />
<br>
	<br>
	<br>
	<br>
	<% User user = (User)request.getSession(false).getAttribute("user");
	if(user != null) {%>
	<table id="userDetails">
		<tr>
			<th>User Details</th>
		</tr>
		<tr>
			<td><%= user.getEmail() %></td>
		</tr>
		<tr>
			<td><%= user.getFirstName() %></td>
		</tr>
		<tr>
			<td><%= user.getLastName() %></td>
		</tr>		
	</table>
	<form action=PaymentGateway.jsp method="post">
		<table id="flightDetails">
			<tr>
				<th>Flight Details</th>
			</tr>		
			<tr>
				<td><%=request.getParameter("flightName")%><b style="font-size: 10px;color: #3f51b5;"> <%=request.getParameter("flightCode")%></b></td>
			</tr>
			<tr>
				<td><span style="color: grey;">Departure</span> <%=request.getParameter("departure")%></td>
			</tr>
			<tr>
				<td><span style="color: grey;">Time </span> <%=request.getParameter("duration")%></td>
			</tr>
			<tr>
				<td><span style="color: grey;">Arrival</span> <%=request.getParameter("arrival")%></td>
			</tr>
			<tr>
				<td><span style="color: grey;">Price</span> &#8377; <%=request.getParameter("price")%></td>
				<input type="hidden" name="email" value="<%= user.getEmail()%>"/>
				<input type="hidden" name="price" value="<%= request.getParameter("price")%>"/>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<button class="bookNowButton" type="submit" name="payment">Proceed
			to Payment</button>
	</form>
	<%}else{ %>
		<!-- <span>Unauthenticated Page Error 404!</span> -->
		<jsp:include page="ErrorPage.jsp" />
	<%} %>
</body>
</html>