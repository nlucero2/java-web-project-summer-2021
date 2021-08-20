<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="ISO-8859-1">

<style type="text/css">

form { margin-top: 10px; }

label { font-size: 16px; width: 100px; display: block; text-align: right;
		margin-right: 10px; margin-top: 8px; margin-bottom: 8px; }

input { width: 250px; border: 1px solid #666; border-radius: 5px;
		padding: 4px; font-size: 16px; }

.theButton { font-weight: bold; width: 130px; padding: 5px 10px;
		margin-top: 30px; background: #cccccc; }



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
		
		<input class="theButton" type="submit" value="Login" />
		
	</form:form>
	
	<br><br>
	<hr>
	<br>
	
	<!-- add a Back to Home Page link -->
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	
	
	
</body>
</html>
