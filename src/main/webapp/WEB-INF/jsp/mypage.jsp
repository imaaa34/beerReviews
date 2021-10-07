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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<title>beerReviews</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>

<h2>Mypage</h2>
<p>name：<%= loginUser.getName() %></p>
<p>reviews：</p>

<% for(Review review : reviewList) { %>
<% if(loginUser.getName() == review.getUserName()) { %>
<p><%= review.getBeerName() %></p>
<p><%= review.getArea() %></p>
<p><%= review.getText() %></p>
<% } %>
<% } %>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="js/jquery.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>