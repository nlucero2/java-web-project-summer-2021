<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	
	<style>
		.failed { color: red; }
	</style>
	
	<title>Login Page</title>
</head>

<body>
	
	<h3>Login Page</h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" >
		
		<!-- Check for login error -->
		<c:if test="${param.error != null}">
			<i class="failed">You have entered an invalid username/password.</i>
		</c:if>
		
		<p>
			Username: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>
	
</body>
</html>
