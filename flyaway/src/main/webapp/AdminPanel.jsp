<%@page import="flyaway.model.FlightTravelDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="flyaway.services.FlightOperations,flyaway.model.Flight, java.util.List, java.util.Iterator, flyaway.model.User, flyaway.utils.Util" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway</title>
<style>
#admin {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top: 40px;
}

#admin td, #admin th {
  border: 1px solid #ddd;
  padding: 8px;
}

#admin tr:nth-child(even){background-color: #f2f2f2;}

#admin tr:hover {background-color: #ddd;}

#admin th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #3f51b5;/* #4CAF50; */
  color: white;
}

.backButton{
	float: right;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;
	
}
</style>
</head>
<body>
<jsp:include page="TopNav.jsp" />
<br>
<h2>Admin Panel</h2>
<p>Hi, 
	<% User user = (User)request.getSession(false).getAttribute("user");%><%= user.getFirstName() %>
	</p>
<button class="backButton" type="button" onclick="location.href='ChangePassword.jsp'">Change Password</button>
<br><br>
<table id="admin">
  <tr>
    <th>Flight Name</th>
    <th>Flight Code</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Time Of Travel</th>
    <th>Price</th>
  </tr>
  
  <% 	
  		Util util = new Util();
  		FlightOperations flightOperations = new FlightOperations();
  		FlightTravelDetails flight = null;
		List flightTravelDetailsList = flightOperations.getAllFlightsDetails();
		for (Iterator iterator = flightTravelDetailsList.iterator(); iterator.hasNext();) {
			flight = (FlightTravelDetails) iterator.next();
			String timeDiff = util.dateTimeDifference(flight.getArrivalTime(), flight.getDepartureTime());
  %>
	  <tr>
	    <td><%= flight.getFlight().getFlightName() %></td>
	    <td><%= flight.getFlight().getFlightCode() %></td>
	    <td><%= flight.getSource() %></td>
	    <td><%= flight.getDestinaion() %></td>
	    <td><%= timeDiff %></td>
	    <td><%= flight.getFlight().getPrice() %></td>
	  </tr>
  <%} %>
</table>
</body>
</html>