<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin: 4px 2px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;
}
	
.backButton {
	float: right;
	border: none;
	color: white;
	padding: 17px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	/* margin: 4px 2px; */
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;
	margin: 20px;
}
</style>
</head>
	<body>
		<button class="backButton" type="button" onclick="location.href='HomePage.jsp'">Back</button>
		<% for(int flightLoop =0;flightLoop<20;flightLoop++){ %>
		<div class="card">
			<div class="container">
				<ul class="nav">
				<form method="post" action="FlightDetails">
					<img src="./images/flightImg.png" alt="Avatar" class="avatar">
					<li><input type="hidden" name="flightName" value="Airasia">FlightName</li>
					<li style="color: #878787;"><input type="hidden" name="start" value="Kolkata">Start</li>
					<li><input type="hidden" name="duration" value="2hrs">time Duration</li>
					<li style="color: #878787;"><input type="hidden"name="destination" value="Bangalore">Stop</li>
					<li><input type="hidden" name="price" value="12.00"><b> &#8377;20.00</b></li>
					<button class="bookNowButton" type="submit">Book Now</button>
				</form>
					
				</ul>
			</div>
		</div>
		<%} %>
	</body>
</html>