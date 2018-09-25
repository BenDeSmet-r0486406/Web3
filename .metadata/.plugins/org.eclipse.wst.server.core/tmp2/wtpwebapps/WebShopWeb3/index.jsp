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
		<jsp:param name="home" value="actual"/>
		<jsp:param name="Hallo" value="Home"/>
	</jsp:include>
	<main>
Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. 

<c:choose>
	<c:when test="${user == null}">
	<form method="post" action="Controller?action=login" >
    	
        <p><label for="userid">User id</label><input type="text" id="userid" name="userid"></p>
        
        <p><label for="password">Password</label><input type="password" id="password"  name="password"></p>
        <p><input type="submit" id="login" value="log in"></p>
        
    </form>
	</c:when>
	<c:otherwise>
	 <h2>Welcome ${user.firstName}</h2>
	<c:choose>
<c:when test="${error != null }">
		<h3>${error }</h3>
	
</c:when>
</c:choose>
	 <form method="post" action="Controller?action=logout" >
        <p><input type="submit" id="logout" value="log out"></p>
    </form>
	</c:otherwise>
</c:choose>
	</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="index.jsp"/>
</jsp:include>
</div>
</body>
</html>