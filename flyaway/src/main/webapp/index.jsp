<html>
<head>
<title>Flyaway</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12.5px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

button {
	background-color: #3f51b5;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}
.signin {
  
  text-align: center;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form action="LoginServlet" method="post" >
		<div class="container">
			<h2>Login Form</h2>
			<p>Please enter your details.</p>
			<hr>   
				<label for="uname"><b>Username</b></label> 
				<input type="text" placeholder="Enter Username" name="username" required> 
				<label for="psw"><b>Password</b></label> 
				<input type="password" placeholder="Enter Password" name="password" required>
			<hr>   
			<button type="submit">Login</button>
		</div>
	</form>
	<div class="container signin">
		<p>
			Create account? <a href="Registration.jsp">Register here</a>.
		</p>
	</div>
</body>
</html>