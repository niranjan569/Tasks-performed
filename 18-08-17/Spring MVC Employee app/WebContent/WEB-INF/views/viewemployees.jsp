<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<h1>All employees</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Project</th>
			<th>Salary</th>
		</tr>
		<c:forEach var="emp" items="${emplist}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.pEmployeeName}</td>
				<td>${emp.pProject}</td>
				<td>${emp.pSalary}</td>
				<td><a href="/Spring_MVC_login_app/edit?id=${emp.id}">edit</a></td>
				<td><a href="/Spring_MVC_login_app/delete?id=${emp.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/Spring_MVC_login_app/add"><button>Add employees</button></a>
</body>
</html>