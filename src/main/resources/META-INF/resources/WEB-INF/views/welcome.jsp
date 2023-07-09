<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome to MyfirstWebApp</title>
</head>
<body>
	<%@include file="common/nav/navigation.jspf"%>
	<h1>Welcome ${name}</h1>
	<h2>
		<a href="listtodo" class="btn btn-success">Manage your todos</a>
	</h2>
</body>
</html>