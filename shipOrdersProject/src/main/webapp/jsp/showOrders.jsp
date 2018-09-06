<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="/css/style.css" rel="stylesheet" type="text/css">
		<title>Show Orders</title>
	</head>
	<body>
	
		<h1>List of Orders</h1>
			<table>
			  <tr>
			   <th>Order Number</th>
			   <th>Company Name</th>
			  	<th>Ship Name</th>
			  	<th>Date</th>
			  </tr>
			  <tr>
			    <c:forEach items="${orders}" var="orders">
			      <tr> 
			      <td>${orders.oid}</td>
			       <td>${orders.shippingCompany.name}</td>
			        <td>${orders.ship.name}</td>
			         <td>${orders.date}</td>
			      </tr>
			    </c:forEach>
			</table>
			<br>
		<a href="/index.html"><button>Home</button></a>
	
	</body>
</html>