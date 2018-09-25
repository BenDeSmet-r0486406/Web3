<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"
	href="css/${kleur==null || kleur.isEmpty()? 'yellow' : kleur}.css">
</head>
<body>
	<div id="container">


	<jsp:include page= "header.jsp">
		
			
		<jsp:param name= "person" value="actual"/> 
		
		
		<jsp:param name= "Hallo" value="Password check"/> 
		
		
		</jsp:include>
		
		

		<main>  
		<c:choose>
			<c:when test="${error !=null}">
				<div class="alert-danger">
						<ul>
							<li>${error}</li>
						</ul>
				</div>
			</c:when>
		</c:choose>
		
		
		<form method="post" action="Controller?action=passwordCheck2">
			<p>
				<label for="password">Password</label><input type="password" id="password"
					name="password" >
			</p>
			
			<p>
				<input type="hidden" name="userid" value="${userid}" >
				<input type="submit" id="check" value="check" >
			</p>
			
			</form>

		 </main>
		<c:choose>
			<c:when test="${kleur==null || kleur.isEmpty() || kleur eq 'yellow' }">

				<jsp:include page="footer.jsp">


					<jsp:param name="kleur" value="red" />
				 	<jsp:param name= "Hallo" value="Password check"/> 

				</jsp:include>
			</c:when>
			<c:otherwise>

				<jsp:include page="footer.jsp">
						<jsp:param name= "currentPage" value="checkPassword.jsp"/> 

				</jsp:include>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>