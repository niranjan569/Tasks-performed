<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form:form modelAttribute="employee" method="post" action="/Spring_MVC_login_app/update">
		<form:label path="">
			<h3>${msg}</h3>
		</form:label>
		<form:hidden path="id" />
		<form:label path="">Name</form:label>
		<form:input path="pEmployeeName"/>
		<br>
		<br>
		<form:label path="">Project</form:label>
		<form:input path="pProject" />
		<br>
		<br>
		<form:label path="">Salary</form:label>
		<form:input path="pSalary" />
		<br>
		<br>
		<input type="submit" value="Update">
	</form:form>
	<br>
	<a href="/Spring_MVC_login_app/view">
		<button>View all employees</button>
	</a>
</body>
</html>