<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>

<head>

	<meta charset="ISO-8859-1">
	
	<title>Access Denied</title>

</head>

<body>

	<h2>Access Denied - You are not authorized to access this resource.</h2>

	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	
	<a href="${pageContext.request.contextPath}/showMyLoginPage">Back to Login Page</a>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input class="add-button" type="submit" value="Logout" />
	
	</form:form>

</body>
</html>