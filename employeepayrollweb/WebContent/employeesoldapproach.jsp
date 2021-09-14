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
		
		<% 
		//Writing Java Code in JSP old approach not recommended
			List<Employee> allEmployees = (List<Employee>) request.getAttribute("employees");
		
			for (Employee employee : allEmployees) 
			{	
		%>		
		<tr>
		<td><%= employee.getId() %></td>
		<td><%= employee.getName() %></td>
		<td><%= employee.getSalary() %></td>
		<td><a href="deleteemployee?id=<%= employee.getId()  %>" > Delete </a> </td>
		<td><a href=""> Update </a> </td>		
		</tr>	
		<% 
			} 
		%>
		
		
	</table>
</body>
</html>









