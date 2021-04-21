<%@page import="flyaway.model.FlightTravelDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="flyaway.services.FlightOperations,flyaway.model.Flight, java.util.List, java.util.Iterator, flyaway.utils.Util" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 100%;
	background: #efefef;
	border-radius: 3px;
	overflow: auto;
	margin-bottom: 10px;
}
	
.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
	
.container {
	padding: 10px 16px;
}
	
.nav {
	margin: 0;
	padding: 0;
}
	
.nav li {
	color: #555;
	font-family: Arial, Helvetica, sans-serif;
	padding: 18px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	border: none;
}
	
.avatar {
  vertical-align: middle;
  width: 50px;
  height: 50px;
  border-radius: 50%;
}
	
.bookNowButton {
	float: right;
	border: none;
	color: white;
		/* padding: 10px 28px; */
	padding: 17px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 18px 2px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;
}

</style>
</head>
	<body>
	<jsp:include page="TopNav.jsp" />
<br>
		<% 
		Util util = new Util();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String departureDate = request.getParameter("departureDate");
		System.out.print(source + " and " + destination + " and " + departureDate); 
		FlightOperations flightOperations = new FlightOperations();
		List flights = flightOperations.searchFlights(source, destination, departureDate);
		if(flights.size()>0){
		for (Iterator iterator = flights.iterator(); iterator.hasNext();){ 
			FlightTravelDetails flightTravelDetails = (FlightTravelDetails) iterator.next(); 	
			String timeDiff = util.dateTimeDifference(flightTravelDetails.getArrivalTime(), flightTravelDetails.getDepartureTime());
		%>
		<div class="card">
			<div class="container">
				<ul class="nav">
				<form action="AuthenticationServlet" method="post">
					<img src="./images/flightImg.png" alt="Avatar" class="avatar">
					<li>
						<input type="hidden" name="flightName" value="<%= flightTravelDetails.getFlight().getFlightName() %>"><%= flightTravelDetails.getFlight().getFlightName() %>
						<br>
						<input type="hidden" name="flightCode" value="<%= flightTravelDetails.getFlight().getFlightCode() %>"><span style="font-size: 10px;color: #3f51b5;"><%= flightTravelDetails.getFlight().getFlightCode()  %></span>
					</li>
					<li style="color: #878787;"><input type="hidden" name="departure" value="<%= flightTravelDetails.getSource() %>"><%= flightTravelDetails.getSource() %></li>
					<li><input type="hidden" name="duration" value="<%= timeDiff%>"><%=timeDiff %></li>
					<li style="color: #878787;"><input type="hidden"name="arrival" value="<%= flightTravelDetails.getDestinaion() %>"><%= flightTravelDetails.getDestinaion() %></li>
					<li><input type="hidden" name="price" value="<%= flightTravelDetails.getFlight().getPrice() %>"><b> &#8377;<%= flightTravelDetails.getFlight().getPrice()  %></b></li>
					<button class="bookNowButton" type="submit">Book Now</button>
				</form>
					
				</ul>
			</div>
		</div>
		<%}
		} else{%>
		<p>No result found!!</p>
		<%} %>
	</body>
</html>