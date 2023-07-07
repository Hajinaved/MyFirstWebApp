<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Update TODO</title>
</head>
<body>


	<h1>Welcome ${name}</h1>
	<hr>
	<div class="container">
		<h2>Update the details of the existing todo</h2>


		<form:form method="post" modelAttribute="t">
			<form:input type="text" name="des" required="required"
				path="description" />
			<br>
			<form:errors path="description"></form:errors>
			<form:input type="hidden" name="id" path="id" />
			<br>
			<form:input type="text" name="done" path="done">
				
			</form:input>
			<br>
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
</body>
</html>