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
<title>Add TODO</title>
</head>
<body>


	<h1>Welcome ${name}</h1>
	<hr>
	<div class="container">
		<h2>Add the details of the new todo</h2>


		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-1">
				<form:label path="description">Description : </form:label>
				<form:input type="text" name="des" required="required"
					path="description" cssClass="test-warning"/>
				<form:errors path="description"></form:errors>
			</fieldset>

			<fieldset class="mb-1">
				<form:label path="targetDate">Target-Date : </form:label>
				<form:input type="text" name="targetDate" placeholder="YYYY-MM-DD" required="required"
					path="targetDate" cssClass="test-warning"/>
				<form:errors path="targetDate"></form:errors>
			</fieldset>
			
			
			
			
			<form:input type="hidden" name="id" path="id" />
			<br>
			<form:input type="hidden" name="done" path="done" />

			<br>
			<form:input type="hidden" name="targetDate" path="targetDate" />

			<br>
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
</body>
</html>