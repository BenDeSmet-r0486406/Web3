<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp">
 <jsp:param value="Order Confirmation" name="title"/>
</jsp:include>
<body>
<div id="container">
<jsp:include page="header.jsp">
	<jsp:param value="actual" name="product"/>
	<jsp:param value="Order Confirmation" name="Hallo"/>
</jsp:include>

<h2>Payment Recieved.</h2>
<h2>Thank you for your order! Recieved.</h2>

<form method="post" action="Controller?action=ProductOverview">
	<input type="submit" value="Back to productList" class="inline-form" />
</form>
<a><h3>Shopping Cart</h3></a>
</div>
</body>
</html>