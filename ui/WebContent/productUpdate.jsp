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
		<jsp:param name="person" value="actual"/>
		<jsp:param name="Hallo" value="Persons"/>
	</jsp:include>
<main>
	<h2>${id}</h2>

    <form method="post" action="Controller?action=UPDATEproduct&id=${id}" novalidate="novalidate">
        
        <p><label for="description">Description</label><input type="text" id="description" name="description"
         required > </p>
        <p><label for="price">Price</label><input type="text" id="price" name="price"
         required > </p>
        <p><input type="submit"  value="Update Product"></p>
        
    </form>
</main>
</div>
</body>
</html>