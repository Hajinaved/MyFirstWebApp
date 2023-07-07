<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<!-- <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet"> -->
<title>List Todos Page</title>
</head>
<body>
	<h1>Welcome ${name}</h1>
	<hr>
	<div class="container">
		<h2>Your todos are</h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="deletetodo?id=${todo.id}"
							class="btn btn-primary">DELETE</a></td>
						<td><a href="UpdateTodo?id=${todo.id}"
							class="btn btn-warning">Update</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="Add-todo" class="btn btn-success">Add Todo</a>

	</div>
	<!-- <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
 -->
</body>
</html>