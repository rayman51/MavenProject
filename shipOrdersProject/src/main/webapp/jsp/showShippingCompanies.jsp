<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="/css/style.css" rel="stylesheet" type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Show Shipping Companies</title>
		
	</head>
	<body>
		<h1>List of Shipping Companies</h1>
			<table>
			  <tr>
			   <th>Name</th>
			   <th>Home Port</th>
			   <th>Balance</th>
			   <th>Ships</th>
			  </tr>
			  <tr>
			    <c:forEach items="${companies}" var="company">
			      <tr> 
			        <td>${company.name}</td>
			        <td>${company.homePort}</td>
			        <td>${company.balance}</td>
			        <td><c:forEach items="${company.ships}" var = "ships">
			        <li>${ships.name}, ${ships.metres} Mtrs, ${ships.cost} </li>
			        </c:forEach>
			        </td>
			      </tr>
			    </c:forEach>
			  </tr>
			</table>
			<br>
		<a href="/index.html"><button>Home</button></a>
	
	</body>
</html>