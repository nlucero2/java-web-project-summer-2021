<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<style>
ul {
	list-style-type: circle;
}

ul ul {
	list-style-type: "-";
}
</style>

<title>Accurate Accounting</title>

</head>

<body>

	<h1>Accurate Accounting Home Page</h1>

	<br>
	<hr>
	<br>

	<h3>Welcome to the Accurate Accounting home page!!!</h3>

	<br>

	<p>
	<h5>Here is a list of the services that we offer:</h5>
	</p>
	<div>
		<ul>

			<li>Service number 1</li>
			<ul>
				<li>Here is a description of the service number 1</li>
			</ul>
			<br>

			<li>Service number 2</li>

			<ul>
				<li>Here is a description of the service number 2</li>
			</ul>
			<br>

			<li>Service number 3</li>

			<ul>
				<li>Here is a description of the service number 3</li>
			</ul>
			<br>

			<li>Service number 4</li>

			<ul>
				<li>Here is a description of the service number 4</li>
			</ul>
			<br>

			<li>Service number 5</li>

			<ul>
				<li>Here is a description of the service number 5</li>
			</ul>
			<br>

		</ul>
	</div>

	<br>


	<!-- Add a login button -->
	<a href="${pageContext.request.contextPath}/login-page"><button>Login</button></a>




</body>
</html>