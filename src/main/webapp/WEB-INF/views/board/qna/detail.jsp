<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../../template/header.jsp"></c:import>
	<h1>Detail Page</h1>
	
	<table class="table table-sm">
	
	<thead>
		<tr class="table-info">
				<th>글번호</th>
				<th>글제목</th>
				<th>글내용</th>
				<th>글작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>그룹</th>
				<th>순서</th>
				<th>답글깊이</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.detail.num}</td>
			<td>${requestScope.detail.title}</td>
			<td>${requestScope.detail.contents}</td>
			<td>${requestScope.detail.writer}</td>
			<td>${requestScope.detail.regDate}</td>
			<td>${requestScope.detail.hit}</td>
			<td>${requestScope.detail.ref}</td>
			<td>${requestScope.detail.step}</td>
			<td>${requestScope.detail.depth}</td>
		</tr>
	</tbody>
	
	</table>
	
	
	<!-- 상대경로 -->
	<a href="./list">뒤로가기</a>
	<a href="./update.iu?num=${requestScope.detail.num}">수정</a>
	<a href="./delete.iu?num=${requestScope.detail.num}">삭제</a>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?num=${requestScope.detail.num}">상품 가입하기</a>
	</c:if>
	<c:import url="../../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>