<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Update" />
</jsp:include>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="product" value="actual"/>
		<jsp:param name="Hallo" value="Update"/>
	</jsp:include>
<main>
	<h2>${id}</h2>

    <form method="post" action="Controller?action=UPDATEproduct&id=${id}" novalidate="novalidate">
        
        <p><label for="description">Description</label><input type="text" id="description" name="description"
         required > </p>
        <p><label for="price">Price</label><input type="text" id="price" name="price"
         required > </p>
        <p><label for="waardering">Waardering</label><input type="text" id="waardering" name="waardering"
         required > </p>
        <p><input type="submit"  value="Update Product"></p>
        
    </form>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="productUpdate.jsp"/>
</jsp:include>
</div>
</body>
</html>