<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/${kleur==null || kleur.isEmpty()? 'yellow' : kleur}.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="product" value="actual"/>
		<jsp:param name="Hallo" value="Shopping Cart"/>
	</jsp:include>
<main>

	 <table>

<tr>
	<th>Name</th>
	<th>Description</th>
	<th>Price</th>
	<th>Quantity</th>
</tr>

<c:forEach var="productOrder" items="${cart.productsOrdered}">
<tr>
	<td>${productOrder.product.id}</td>
	<td>${productOrder.product.description}</td>
	<td>${productOrder.product.price}</td>
	<td>${productOrder.quantity}</td>
</tr>
</c:forEach>

<caption>Products Overview</caption>
</table>

<h3>Total Amount: ${totalPrice}</h3>
<button>Pay</button>

<h3>Shopping Cart (${cart.getNumberOfProductOrdersInCart() })</h3>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="productoverview.jsp"/>
</jsp:include>
</div>
</body>
</html>