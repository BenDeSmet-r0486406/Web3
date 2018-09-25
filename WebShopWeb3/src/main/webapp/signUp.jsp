<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Sign Up" />
</jsp:include>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="signup" value="actual"/>
		<jsp:param name="Hallo" value="Sign up"/>
	</jsp:include>
<main>
	
	 <form method="post" action="Controller?action=ADD">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="userid">User id</label><input type="text" id="userid" name="userid"> </p>
        <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"> </p>
        <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"> </p>
        <p><label for="email">Email</label><input type="email" id="email" name="email"></p>
        <p><label for="password">Password</label><input type="password" id="password"  name="password"> </p>
        <p><input type="submit" id="signUp" value="Sign Up"></p>
        
	</form>
    
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="signUp.jsp"/>
</jsp:include>
</div>
</body>
</html>


