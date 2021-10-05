<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<%
//セッションスコープからユーザ情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beerReviews</title>
</head>
<body>
<% if(loginUser != null) { %>
	<p>Login successfully.</p>
	<p>Welcome, <%= loginUser.getName() %>!</p>
	<a href="/beerReviews/Logout">Logout</a>
	<a href="/beerReviews/Main">Reviews</a>
<% } else { %>
	<p>Login failed.</p>
	<a href="/beerReviews/">TOP</a>
<% } %>
</body>
</html>