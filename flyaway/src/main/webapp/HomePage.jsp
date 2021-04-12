<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	background-image: url("./images/flyaway.jpg");
  	height: 500px; 
  	background-position: center; 
  	background-repeat: no-repeat; 
  	background-size: cover; 
}
.logo {
	margin-left: 2%;
	margin-top: 3%;
	color: #dddddd;
}

.serachFlightSection {
	margin-left: 5px;
	margin-right: 5px;
}

.searchPanel {
	height: 200px;
	background-color: rgba(255,255,255,.6);
	width: 80%;
	margin-left: 8%;
	margin-top: 5%;
	padding-left: 40px;
	padding-right: 40px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.avatar {
	vertical-align: middle;
	width: 50px;
	height: 50px;
	border-radius: 50%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.searchButton {
	width: 130px;
	float: right;
	border: none;
	color: white;
	padding: 15px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	cursor: pointer;
	background-color: #3f51b5;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
}

.dropbtn {
	width: 130px;
	color: #2980B9;
	padding: 15px;
	font-size: 16px;
	border: none;
	cursor: pointer;
	background-color: white;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #efefef;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	height: 180px !important;
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {	
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}

.travelDate {
	box-shadow: 0 4px 8px 0 rgb(0 0 0/ 40%);
	border: none;
	padding: 15px 5px;
	text-decoration: none;
	color: white;
	background: #2980B9;
}
</style>
<script type="text/javascript">
	function showHide(className) {
		document.getElementById(className).classList.toggle("show");
	}

	// Close the dropdown if the user clicks outside of it
	window.onclick = function(event) {
		if (!event.target.matches('.dropbtn')) {
			var dropdowns = document.getElementsByClassName("dropdown-content");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		}
	}
</script>
</head>
<body>
	<h2 class="logo">
		<img src="./images/flightImg.png" alt="Avatar" class="avatar">
		Welcome to Flyaway
	</h2>
	<br><br><br><br><br><br>
	<div class="searchPanel">
	<br><br>
		<div class="dropdown">
			<button onclick="showHide('sourceDropdown')"
				class="serachFlightSection dropbtn">Source</button>			
			<div id="sourceDropdown" class="dropdown-content">
				<a href="#home">Home</a> 
				<a href="#about">About</a> 
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
			</div>
		</div>
		<img src="./images/arrow.png" alt="Avatar" class="avatar">
		<div class="dropdown">
			<button onclick="showHide('destDropdown')"
				class="serachFlightSection dropbtn">Destination</button>			
			<div id="destDropdown" class="dropdown-content">				
				<a href="#home">Home</a> 
				<a href="#about">About</a> 
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
				<a href="#contact">Contact</a>
			</div>
		</div>
		<span style="font-size:17px; margin-left: 40px; color: #555;">Source</span>
		<input class="serachFlightSection travelDate" type="date" name="startDate"> 
		<span style="font-size:17px; margin-left: 20px; color: #555;">Departure</span>
		<input class="serachFlightSection travelDate" type="date" name="endDate">

		<br>
		<br>
		<button class="serachFlightSection searchButton" type="button">Search</button>
	</div>

</body>
</html>