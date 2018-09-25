<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="signup" value="actual"/>
		<jsp:param name="Hallo" value="Sign up"/>
	</jsp:include>
<main>
	<div class="alert-danger">
		<ul>
			<li>Some error</li>
		</ul>
	</div>

    <form method="post" action="Controller?action=ADDProduct" novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
         required > </p>
        <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
         required > </p>
        <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
         required > </p>
        <p><label for="email">Email</label><input type="email" id="email" name="email" required></p>
        <p><label for="password">Password</label><input type="password" id="password"  name="password"
         required> </p>
        <p><input type="submit" id="signUp" value="Sign Up"></p>
        
    </form>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>


