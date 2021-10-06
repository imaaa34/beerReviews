<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import="model.User" %>
<%
//セッションスコープからユーザ情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerReviews</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>

<c:choose>
	<c:when test="${loginUser != null}">
	<%-- <% if(loginUser != null) { %> --%>
		<p>Login successfully.</p>
		<%-- <p>Welcome, <%= loginUser.getName() %>!</p> --%>
		<p>Welcome, ${loginUser.name}!</p>
		<a href="/beerReviews/Logout">Logout</a>
		<a href="/beerReviews/Main">Reviews</a>
	</c:when>
	<%-- <% } else { %> --%>
	<c:otherwise>
		<p>Login failed.</p>
		<a href="/beerReviews/">TOP</a>
	<%-- <% } %> --%>
	</c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>