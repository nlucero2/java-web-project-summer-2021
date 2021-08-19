<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<style>
	ul { list-style-type: circle; }
	ul ul { list-style-type: "-"; }
	
	.buttons {
	width: 100px;
	height: 25px;
	margin: 0 auto;
	display: inline;
	}
	
	.input-button {
	width: 100px;
	margin: 0 auto;
	display: inline;
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

			<li>Service number 6</li>

				<ul>
					<li>Here is a description of the service number 6</li>
				</ul>
			<br>

			<li>Service number 7</li>

				<ul>
					<li>Here is a description of the service number 7</li>
				</ul>

		</ul>
	</div>

	<br>
	<hr>
	<br>


	<!-- Add a login button -->
	<a href="${pageContext.request.contextPath}/list-of-contact-info"><button class="buttons">Login</button></a>
	
		
</body>
</html>