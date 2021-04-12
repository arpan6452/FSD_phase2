<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#admin {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
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
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<h2>Admin Panel</h2>
<p>Hi, Admin</p>
<p style="float: right;"><a href="">Change Password</a></p>
<table id="admin">
  <tr>
    <th>Flight Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Price</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
    <td>54.00</td>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
    <td>54.00</td>
  </tr>
</table>
</body>
</html>