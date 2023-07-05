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
<title>Add TODO</title>
</head>
<body>


	<h1>Welcome ${name}</h1>
	<hr>
	<div class="container">
		<h2>Enter details of new todo</h2>


		<form  method="post">
			<tr>
				<input type="text" name="id" placeholder="Enter ID">
			</tr>
			<br>
			<tr>
				<input type="text" name="description"
					placeholder="Enter Description">
			</tr>
			<br>
			<tr>
				<input type="text" name="targetDate" placeholder="Enter Target-date">
			</tr>
			<br>
			<tr>
				<input type="text" name="done" placeholder="status">
			</tr>
			<br> <input type="submit" class="btn btn-success">
		</form>
	</div>
</body>
</html>