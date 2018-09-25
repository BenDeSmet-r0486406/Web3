<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page  isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AI CARAMBA!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/${kleur==null || kleur.isEmpty()? 'yellow' : kleur}.css">
</head>
<body>
<main>
<div id="container">
<h1>Damn son!</h1>
<p>You caused a ${pageContext.exception} on the server!</p>
<p>
<a href="Controller?action=home">Home</a>
</p>
</div>
</main>
</body>
</html>