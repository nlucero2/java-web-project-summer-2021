<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.websitebase.utility.SortingUtility" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<style type="text/css">

html, body{ margin-left:15px; margin-right:15px; padding:0px;
		font-family:Verdana, Arial, Helvetica, sans-serif; }

table { border-collapse:collapse; border-bottom:1px solid gray;
		font-family: Tahoma,Verdana,Segoe,sans-serif; width:72%; }

th { border-top:2px solid gray; border-bottom:2px solid gray; background:none repeat scroll 0 0 Fuchsia;
		padding:10px; color: #FFFFFF; }

tr { border-top:2px solid gray; border-bottom:2px solid gray; text-align:center; }

tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #BBBBBB}	

#wrapper {width: 100%; margin-top: 0px; }
#header {width: 70%; background: Fuchsia; margin-top: 0px; padding:15px 0px 15px 15px;}	/*#09c332*/
#header h2 {width: 100%; margin:auto; color: #FFFFFF;}
#container {width: 100%; margin:auto}
#container h3 {color: #000;}
#container #content {margin-top: 20px;}

.buttons { font-weight: bold; width: 225px; padding: 4px;font-size: 16px;
		margin: 30px auto; background: #cccccc; 
		border: 1px solid #666; border-radius: 5px }

ul { list-style-type: circle; }
ul ul { list-style-type: "-"; }

</style>
	
	<title>Accurate Accounting - List of Contact Info</title>
	
</head>

<body>
	<div id="wrapper">
		<h1>Accurate Accounting List of Contact Info Page</h1>
	</div>
	
	<br>
	<hr>
	<br>
	
<%-- 	<h3>Hello ${pageContext.request.userPrincipal.name},</h3> --%>
	<h3>Welcome to the Accurate Accounting list of contact info page!!!</h3>
	
	<br>
	
	
	<div id="container">
		<div id="content">
			
			
			<!-- PUT SEARCH BUTTON HERE -->
			<form:form action="search" method="GET" >
				Search by name: <input name="theSearchName" type="text" />
				
				<input class="buttons" value="Search" type="submit" />
				
				<i>*To reset the list, click the Search button while text box is empty</i>
			</form:form>
			
			<!-- *sorting links* -->
			<!-- construct a sort link for first name and pass the value used to sort -->
			<c:url var="sortLinkFirstName" value="/list-of-contact-info">
				<c:param name="sortingString" value="<%=Integer.toString(SortingUtility.FIRST_NAME)%>" />
			</c:url>
			
			<!-- construct a sort link for last name and pass the value used to sort -->
			<c:url var="sortLinkLastName" value="/list-of-contact-info">
				<c:param name="sortingString" value="<%=Integer.toString(SortingUtility.LAST_NAME)%>" />
			</c:url>
			
			<!-- construct a sort link for phone and pass the value used to sort -->
			<c:url var="sortLinkPhone" value="/list-of-contact-info">
				<c:param name="sortingString" value="<%=Integer.toString(SortingUtility.PHONE)%>" />
			</c:url>
			
			<!-- construct a sort link for email and pass the value used to sort -->
			<c:url var="sortLinkEmail" value="/list-of-contact-info">
				<c:param name="sortingString" value="<%=Integer.toString(SortingUtility.EMAIL)%>" />
			</c:url>
			<!-- *sorting links* -->

<!-- 			<!-- *sorting links* -->
<!-- 			<!-- construct a sort link for first name and pass the value used to sort -->
<%-- 			<c:url var="sortLinkFirstName" value="/list-of-contact-info"> --%>
<%-- 				<c:param name="sortingString" value="SortingUtility.FIRST_NAME" /> --%>
<%-- 			</c:url> --%>
			
<!-- 			<!-- construct a sort link for last name and pass the value used to sort -->
<%-- 			<c:url var="sortLinkLastName" value="/list-of-contact-info"> --%>
<%-- 				<c:param name="sortingString" value="SortingUtility.LAST_NAME" /> --%>
<%-- 			</c:url> --%>
			
<!-- 			<!-- construct a sort link for phone and pass the value used to sort -->
<%-- 			<c:url var="sortLinkPhone" value="/list-of-contact-info"> --%>
<%-- 				<c:param name="sortingString" value="SortingUtility.PHONE" /> --%>
<%-- 			</c:url> --%>
			
<!-- 			<!-- construct a sort link for email and pass the value used to sort -->
<%-- 			<c:url var="sortLinkEmail" value="/list-of-contact-info"> --%>
<%-- 				<c:param name="sortingString" value="SortingUtility.EMAIL" /> --%>
<%-- 			</c:url> --%>
<!-- 			<!-- *sorting links* -->
			
			
			
			<!-- the html table here -->
			
			<table>
			
				<tr>
					<th><a href="${sortLinkFirstName}">First Name</a></th>			<!-- *CHANGED TO LINKS FOR SORT* -->
					<th><a href="${sortLinkLastName}">Last Name</a></th>			<!-- *CHANGED TO LINKS FOR SORT* -->
					<th><a href="${sortLinkPhone}">Phone</a></th>					<!-- *CHANGED TO LINKS FOR SORT* -->
					<th><a href="${sortLinkEmail}">Email</a></th>					<!-- *CHANGED TO LINKS FOR SORT* -->
					<th>Action</th>													<!-- *header for delete link* -->
				</tr>

<!-- 				<tr> -->
<!-- 					<th>First Name</th> -->
<!-- 					<th>Last Name</th> -->
<!-- 					<th>Phone</th> -->
<!-- 					<th>Email</th> -->
<!-- 					<th>Action</th> -->
<!-- 				</tr> -->
				
				<!-- Loop over and print our customers -->
				<c:forEach var="tempContactInfo" items="${contactInfos}">
					
					<!-- *ADDITION FOR UPDATE* construct an "Update" link with customer id *ADDITION FOR UPDATE* -->
<%-- 					<c:url var="updateLink" value="/showUpdatePage"> --%>
<%-- 						<c:param name="contactInfoId" value="${tempContactInfo.id}"></c:param> --%>
<%-- 					</c:url> --%>
					<!-- *END ADDITION FOR UPDATE* -->
					
					<!-- *ADDITION FOR DELETE* construct a "Delete" link with customer id *ADDITION FOR DELETE* -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="contactInfoId" value="${tempContactInfo.id}"></c:param>
					</c:url>
					<!-- *END ADDITION FOR DELETE* -->
					
					
					<tr>
						<td> ${tempContactInfo.firstName} </td>
						<td> ${tempContactInfo.lastName} </td>
						<td> ${tempContactInfo.phone} </td>
						<td> ${tempContactInfo.email} </td>
						
						<td>
							<!-- *ADDITION FOR UPDATE* display the update link at the end of each row *ADDITION FOR UPDATE* -->
<%-- 							<a href="${updateLink}">Update</a> --%>
							<!-- *END ADDITION FOR UPDATE* -->

							
							<!-- *ADDITION FOR DELETE* - *ADDITION FOR DELETE* -->
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure that you want to delete this contact info entry?'))) return false">Delete</a>
							<!-- *END ADDITION FOR DELETE* -->
							
						</td>
						
					</tr>
				
				</c:forEach>
			
			</table>
				
				<br><br><br>
				<hr>
				<br>
				
				<!-- Add a logout button -->
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
					
					<input class="buttons" type="submit" value="Logout" />
					
				</form:form>
			
		</div>
		
	</div>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	
<!-- 	<p><h5>Here is a list of contact info:</h5></p> -->
<!-- 	<div> -->
<!-- 		<ul> -->
		
<!-- 			<li> Service number 1 </li> -->
<!-- 				<ul> -->
<!-- 					<li>Here is a description of the service number 1</li> -->
<!-- 				</ul> -->
<!-- 				<br> -->
				
<!-- 			<li> Service number 2 </li> -->
			
<!-- 				<ul> -->
<!-- 					<li>Here is a description of the service number 2</li> -->
<!-- 				</ul> -->
<!-- 				<br> -->
				
<!-- 			<li> Service number 3 </li> -->
			
<!-- 				<ul> -->
<!-- 					<li>Here is a description of the service number 3</li> -->
<!-- 				</ul> -->
<!-- 				<br> -->
				
<!-- 			<li> Service number 4 </li> -->
			
<!-- 				<ul> -->
<!-- 					<li>Here is a description of the service number 4</li> -->
<!-- 				</ul> -->
<!-- 				<br> -->
				
<!-- 			<li> Service number 5 </li> -->
			
<!-- 				<ul> -->
<!-- 					<li>Here is a description of the service number 5</li> -->
<!-- 				</ul> -->
				
<!-- 		</ul> -->
<!-- 	</div> -->
	
<!-- 	<br> -->
<!-- 	<hr> -->
<!-- 	<br> -->
	
	<!-- Add a logout button -->
<%-- 	<form:form class="buttons" action="${pageContext.request.contextPath}/logout" method="POST"> --%>
	
<!-- 		<input class="input-button" type="submit" value="Logout" /> -->
	
<%-- 	</form:form> --%>
	
	
	
	
	
</body>
</html>