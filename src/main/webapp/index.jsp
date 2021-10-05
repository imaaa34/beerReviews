<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<title>beerReviews</title>
</head>
<body>
<h1>Welcome to beerReviews!</h1>
<div class="login-form">
<form action="/beerReviews/Login" method="post">
name：<input type="text" name="name"><br>
password：<input type="password" name="pass"><br>
<input type="submit" value="Login">
</form>
</div>
</body>
</html>