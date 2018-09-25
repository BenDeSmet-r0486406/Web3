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
		<jsp:param name="add" value="actual"/>
		<jsp:param name="Hallo" value="Add product"/>
	</jsp:include>
<main>
	 <c:choose>
			<c:when test="${error !=null}">
				<div >
					<c:forEach var="error" items="${error}">
						<ul>
							<li class="alert-danger">${errors}</li>
						</ul>
					</c:forEach>
				</div>
			</c:when>
		</c:choose>

    <form method="post" action="Controller?action=ADDProduct" novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="productid">Product id</label><input type="text" id="productid" name="productid"
         required > </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description"
         required > </p>
        <p><label for="price">Price</label><input type="text" id="price" name="price"
         required > </p>
        <p><input type="submit" id="AddProduct" value="Add Product"></p>
        
    </form>
</main>
</div>
</body>
</html>