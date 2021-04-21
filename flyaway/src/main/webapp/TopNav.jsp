<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway</title>
<%@ page import="flyaway.model.User"%>
<style type="text/css">
.topNavSecton {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 100%;
	background: #efefef;
	border-radius: 3px;
	overflow: auto;
	margin-bottom: 10px;
}
	
.topNavSecton:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
	
.topnav {
	margin: 0;
	padding: 0;
}
	
.topnav li {
	color: #555;
	font-family: Arial, Helvetica, sans-serif;
	/* padding: 18px 34px; */
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	/* margin: 4px 2px; */
	border: none;
}
	
.Logo {
  vertical-align: middle;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-left: 20px;
}
	
.LoginLogOutButton {
	float: right;
	border: none;
	color: white;
	padding: 17px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
	border: none;
	border: none;

}

.infoButton {
	float: right;
	border: none;
	color: black;
	padding: 17px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	background-color:#efefef;;

}
</style>
</head>
<body style="margin: 0px;">
<div class="topNavSecton">
			<div>
				<ul class="topnav">				
				<% User user = (User)request.getSession(false).getAttribute("user");
				if(user == null) {%>		
				<form action="index.jsp" method="post">		
					<li style="float: left;"><img src="./images/flightImg.png" alt="Avatar" class="Logo"></li>																									
					<button class="LoginLogOutButton" type="submit">SignIn</button>
					<button class="LoginLogOutButton" style="float: left;" type="button" onclick="location.href='HomePage.jsp'">Home</button>	
				</form>	
				<%} else{ %>	
				<form action="Logout" method="post">	
						<li style="float: left;"><img src="./images/flightImg.png" alt="Avatar" class="Logo"></li>																
						<button class="LoginLogOutButton" type="submit">Logout</button>
						<button class="infoButton" type="button">Hi <%= user.getFirstName() %>,</button>
						<button class="LoginLogOutButton" style="float: left;" type="button" onclick="location.href='HomePage.jsp'">Home</button>								
					<%} %>
				</form>			
				</ul>
			</div>
		</div>
</body>
</html>