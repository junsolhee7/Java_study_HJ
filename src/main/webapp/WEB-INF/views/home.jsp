<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	
	<h3>ADD JSCODE</h3>


	<c:if test="${empty sessionScope.member}">
	<a href="./member/join">join</a>
	<a href="./member/login">login</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
	<h3>${sessionScope.member.name} 님 환영합니다</h3>
	<a href="./member/logout">Logout</a>
	<a href="#">MyPage</a>
	</c:if>
	
	<a href="./member/search">search</a>
	<a href="./bankbook/list.iu">상품리스트</a>
	
</body>
</html>
