<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="product" value="actual"/>
		<jsp:param name="Hallo" value="Products"/>
	</jsp:include>
<main>


<table>

<tr>
	<th>Product id</th>
	<th>Description</th>
	<th>Price</th>
	<th>Waardering</th>
</tr>

<c:forEach var="product" items="${service}">
<tr>
	<td>${product.id}</td>
	<td>${product.description}</td>
	<td>${product.price}</td>
	<td>${product.waardering}</td>
	<td><a href="Controller?action=deleteproduct&id=<c:out value='${product.id}' />">Delete</a></td>
	<td><a href="Controller?action=updateProduct&id=${product.id}">update</a></td>
</tr>
</c:forEach>

<caption>Products Overview</caption>
</table>
</main>
</div>
</body>
</html>