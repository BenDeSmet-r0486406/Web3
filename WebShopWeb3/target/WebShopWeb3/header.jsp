<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<h1><span>Web shop</span></h1>
<nav>
<c:choose>
<c:when test="${user.role.ordinal() == 1}">
<ul>
	<li id="${param.home }"><a href="index.jsp">Home</a></li>
	<li id="${param.person }"><a href="Controller?action=overview">PersonOverview</a></li>
	<li id="${param.product }"><a href="Controller?action=ProductOverview">Products</a></li>
	<li id="${param.add}"><a href="Controller?action=addProduct">addProduct</a></li>
	<li id="${param.signup }"><a href="Controller?action=signUp">Sign up</a></li>
</ul>
</c:when>
<c:when test="${user.role.ordinal() == 0}">
<ul>
	<li id="${param.home }"><a href="index.jsp">Home</a></li>
	<li id="${param.product }"><a href="Controller?action=ProductOverview">Products</a></li>
	<li id="${param.signup }"><a href="Controller?action=signUp">Sign up</a></li>
</ul>
</c:when>
<c:when test="${user == null}">
<ul>
	<li id="${param.home }"><a href="index.jsp">Home</a></li>
	<li id="${param.signup }"><a href="Controller?action=signUp">Sign up</a></li>
</ul>
</c:when>
</c:choose>
</nav>
<h2>
<h2>${param.Hallo}</h2>
</h2>

</header>