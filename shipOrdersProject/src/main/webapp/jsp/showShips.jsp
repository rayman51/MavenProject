<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="/css/style.css" rel="stylesheet" type="text/css">
		<title>Show Ships</title>
	</head>
	<body>
	
	<h1>List of Ships</h1>
		<table>
		  <tr>
		   <th>Name</th>
		   <th>Passengers</th>
		   <th>Cost of Ship</th>
		   <th>Length(Meters)</th>
		   <th>Shipping Company</th>
		  </tr>
		  <tr>
		    <c:forEach items="${ships}" var="ships">
		      <tr> 
		        <td>${ships.name}</td>
		        <td>${ships.passengers}</td>
		        <td>${ships.cost}</td>
		        <td>${ships.metres}</td>
		        <td>${ships.shippingCompany.name}</td>
		      </tr>
		    </c:forEach>
		</table>
		<br>
		<a href="/index.html"> <button>Home</button></a>
	
	</body>
</html>