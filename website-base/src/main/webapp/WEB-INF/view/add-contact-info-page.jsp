<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<style type="text/css">

form { margin-top: 10px; }

label { font-size: 16px; width: 100px; display: block; text-align: right;
		margin-right: 10px; margin-top: 8px; margin-bottom: 8px; }

input { width: 250px; border: 1px solid #666; border-radius: 5px;
		padding: 4px; font-size: 16px; }

.buttons { font-weight: bold; width: 130px; padding: 5px 10px;
		margin-top: 30px; background: #cccccc; }

table { border-style:none; width:50%; }

tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #FFFFFF}

tr { border-style:none; text-align:left; }

.successful { color: purple; }

</style>
	
	<title>Accurate Accounting - Request For Info</title>
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Accurate Accounting List of Contact Info Page</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveContactInfo" modelAttribute="contactInfo" method="POST" >
			
			<!-- *ADDITION FOR UPDATE* need to associate this data with customer *ADDITION FOR UPDATE* -->
			<form:hidden path="id"/>
			<!-- *END ADDITION FOR UPDATE* -->
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					
					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email"/></td>
					</tr>
					
					
					<tr>
						<td><label>Phone</label></td>
						<td><form:input path="phone"/></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="buttons" /></td>
					</tr>
					
				</tbody>
			</table>
			
			
		</form:form>
		
		
		<!-- Check for successful submission -->
		<c:if test="${param.success != null}">
			<i class="successful"><h3>You have successfully submitted a request for information.</h3></i>
		</c:if>
		
		
		<div style="clear; both;"></div>
		
		
		<br><br>
		<hr>
		<br>
		
		<!-- add a Back to Home Page link -->
		<p>
			<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
		</p>		
		
		
	</div>
	
</body>
</html>