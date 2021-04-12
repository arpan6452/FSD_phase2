<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#flightDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 30%;
  margin-left: 30%;
  margin-top: 12%;
}

#flightDetails td, #flightDetails th {
  border: 1px solid #ddd;
  padding: 8px;
}

#flightDetails tr:nth-child(even){
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

</style>
</head>
<body>
<table id="flightDetails">
  <tr>
    <th>Flight Details</th>
  </tr>
  <tr>
    <td>UserName</td>
  </tr>
  <tr>
    <td>Flight Name</td>
  </tr>
  <tr>
    <td>Source</td>
  </tr>
  <tr>
    <td>Destination</td>
  </tr>
  <tr>
    <td>Time</td>
  </tr>
  <tr>
    <td>Price</td>
  </tr>
</table>
</body>
</html>