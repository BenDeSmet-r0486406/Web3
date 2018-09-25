<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="add" value="actual"/>
		<jsp:param name="Hallo" value="Add product"/>
	</jsp:include>
<main>
	
	 <form method="post" action="Controller?action=ADDProduct" novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="productid">Product id</label><input type="text" id="productid" name="productid"
         required > </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description"
         required > </p>
        <p><label for="price">Price</label><input type="text" id="price" name="price"
         required > </p>
         <p><label for="waardering">Waardering</label><input type="text" id="waardering" name="waardering"
         required > </p>
        <p><input type="submit" id="AddProduct" value="Add Product"></p>
  
    
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="AddProduct.jsp"/>
</jsp:include>
</div>
</body>
</html>