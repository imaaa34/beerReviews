<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Review, java.util.List" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Review> reviewList = (List<Review>) application.getAttribute("reviewList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<title>beerReviews</title>
</head>
<body>
<h1 class="title">All Reviews</h1>
<p>Hello, <%= loginUser.getName() %>!</p>
<a href="/beerReviews/Logout">Logout</a><br>

<form action="/beerReviews/Main" method="post">
beer：<input type="text" name="beerName"><br>
area：<input type="text" name="area"><br>
text：<input type="text" name="text"><br>
<input type="submit" value="Submit"><br>
</form>

<% for(Review review : reviewList) { %>
<p><%= review.getUserName() %>:</p>
<p><%= review.getBeerName() %>:</p>
<p><%= review.getArea() %>:</p>
<p><%= review.getText() %></p>
<% } %>
</body>
</html>