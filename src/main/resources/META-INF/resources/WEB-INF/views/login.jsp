<%@page isELIgnored="false"%>

<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h1>${err}</h1>
		<form action="loggedValues" method="post">
			Name: <input type="text" name="name" /> <br> Password:<input
				type="password" name="password" /> <br> <input type="submit" />
		</form>
	</div>
</body>


</html>