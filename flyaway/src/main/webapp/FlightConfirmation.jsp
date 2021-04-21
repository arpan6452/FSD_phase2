<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="flyaway.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="TopNav.jsp" />
<br>
	<% User user = (User)request.getSession(false).getAttribute("user");
	if(user != null) {%>
		<p>Congratulations <b><%= user.getFirstName() %></b>!! Your flight has been <b>confirmed!!</b></p>
		<p>Thanks you for choosing flyaway as a service partner!!</p>
		<p>An confirmation <b>email</b> and <b>ticket</b> has been sent to your registered email id <b><%= user.getEmail() %>.</b></p>
	<%}else{ %>
		<jsp:include page="ErrorPage.jsp" />
	<%} %>
</body>
</html>