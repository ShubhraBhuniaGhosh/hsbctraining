<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.hsbc.employeepayroll.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Records</title>
</head>

<!-- JSP Java Server Pages
	 Responsibility is to act as presentation logic for web app
	 Can contain HTML + JAVA code 	
 -->
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th colspan="2">Action</th>
		</tr>
		
<!-- 			JSTL - Jsp Standard Tag library -->
<!-- 			This gives you commonly needed Java Code as tags -->
<!-- 			To use this library we need following jars -->
<!-- 			jstl.jar  -->
<!-- 			standard.jar -->
		
		
		<c:forEach items="${ employees }" var="employee">
			<tr>
				<td>${ employee.id }</td>
				<td>${ employee.name }</td>
				<td>${ employee.salary}</td>
				<td><a href="deleteemployee?id=${ employee.id }" > Delete </a> </td>
				<td><a href="updateemployee?id=${ employee.id }"> Update </a> </td>		
			</tr>		
		</c:forEach>
	</table>
</body>
</html>









