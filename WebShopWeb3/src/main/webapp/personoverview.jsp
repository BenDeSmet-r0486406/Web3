<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Users" />
</jsp:include>
<body>
<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="person" value="actual"/>
		<jsp:param name="Hallo" value="Persons"/>
	</jsp:include>
<main>
<a href="Controller?action=orderBy">Sorteer</a>
<table>

<tr>
<th>E-mail</th>
<th>First Name</th>
<th>Last Name</th>
<th>Role</th>
</tr>

<c:forEach var="person" items="${service}">
	<tr>
		<td>${person.email}</td>
		<td>${person.firstName}</td>
		<td>${person.lastName}</td>
		<td>${person.role}</td>
		<td><a href="Controller?action=deleteperson&id=<c:out value='${person.userid}' />">Delete</a></td>
	</tr>
</c:forEach>

<caption>Users Overview</caption>
</table>


</main>
<jsp:include page="footer.jsp">
	<jsp:param name="currentPage" value="personoverview.jsp"/>
</jsp:include>
</div>
</body>
</html>