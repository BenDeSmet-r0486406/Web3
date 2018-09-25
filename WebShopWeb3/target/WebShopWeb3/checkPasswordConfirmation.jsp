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
<link rel="stylesheet" type="text/css" href="css/${kleur==null || kleur.isEmpty()? 'yellow' : kleur}.css">
</head>
<body>
	<div id="container">


		<jsp:include page="header.jsp">

			<jsp:param name="person" value="actual"/>
			


			<jsp:param name="Hallo" value="Password check confirm"/>
			

		</jsp:include>


		<main>


		<p>Great job mate, Password is correcrt!!!!!!!....</p>


		</main>
		<jsp:include page="footer.jsp">
						<jsp:param name= "currentPage" value="checkPasswordConfirmation.jsp"/> 

		</jsp:include>

	</div>
</body>
</html>