<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateemployee" method="POST">
		<input type="text" name="id" value="${ employee.id }" readonly="readonly"><br/>
		<input type="text" name="name" value="${ employee.name }" readonly="readonly"><br/>
		<input type="text" name="salary" value="${ employee.salary }"><br/>
		<input type="submit" value="Update">
	</form>
</body>
</html>