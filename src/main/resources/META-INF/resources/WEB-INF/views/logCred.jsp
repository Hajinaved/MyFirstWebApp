<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div
			style="text-align: center; border: 1px dashed blue; margin-left: 100; margin-right: 100px;">
			THIS IS JSP TO SHOW THAT IT IS RUNNING<br> ${name}<br>
			${pass}<br> <a href="listtodo">these are your todoos</a>
		</div>
	</div>
</body>
</html>