<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/${kleur==null || kleur.isEmpty()? 'yellow' : kleur}.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="product" value="actual"/>
		<jsp:param name="Hallo" value="Products"/>
	</jsp:include>
<main>
<a href="Controller?action=showCart"><h3>Shopping Cart (${cart.getNumberOfProductOrdersInCart() })</h3></a>
	 <table>

<tr>
	<th>Product id</th>
	<th>Description</th>
	<th>Price</th>
	<th>Waardering</th>
	<th>Quantity</th>
</tr>

<c:forEach var="product" items="${service}">
<tr>
	<td>${product.id}</td>
	<td>${product.description}</td>
	<td>${product.price}</td>
	<td>${product.waardering}</td>
	<td>
		<form method="POST" action="Controller?action=addToCart&id=${product.id }" data-confirm="Are you sure to add this item to cart?">
			<input type="number" id="quantity" name="quantity">
			<input type="submit"  value="Add To Cart">
		</form>
	</td>
	<c:if test="${user.role.ordinal() == 1}">
		<td><a href="Controller?action=deleteproduct&id=<c:out value='${product.id}' />">Delete</a></td>
		<td><a href="Controller?action=updateProduct&id=${product.id}">update</a></td>
	</c:if>
</tr>
</c:forEach>

<caption>Products Overview</caption>
</table>


</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="productoverview.jsp"/>
</jsp:include>
</div>
</body>
</html>