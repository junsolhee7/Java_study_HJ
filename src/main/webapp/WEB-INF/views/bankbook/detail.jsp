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
	<c:import url="../template/header.jsp"></c:import>
	<h1>Detail Page</h1>
	<table class="table table-sm">
	
	<thead>
		<tr class="table-info">
			<th>Number</th><th>Name</th><th>Rate</th><th>Sale</th><th>Contents</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.detail.bookNum}</td>
			<td>${requestScope.detail.bookName}</td>
			<td>${requestScope.detail.bookRate}</td>
			<td>${requestScope.detail.bookSale}</td>
			<td>${requestScope.detail.bookContents}</td>
		</tr>
	</tbody>
	
	</table>
	
	
	<!-- 상대경로 -->
	<a href="../member/login.iu">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>
	<a href="./list.iu">리스트보기</a>
	<a href="./update.iu?bookNum=${requestScope.detail.bookNum}">수정</a>
	<a href="./delete.iu?bookNum=${requestScope.detail.bookNum}">삭제</a>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?bookNum=${requestScope.detail.bookNum}">상품 가입하기</a>
	</c:if>

	
	<!---------Comment------------>
	<div class="row">
		<div class="mb-3">
  			<label for="writer" class="form-label">USERNAME</label>
  			<input type="text" class="form-control" id="writer" placeholder="Enter your USERNAME">
		</div>
		<div class="mb-3">
  			<label for="contents" class="form-label">CONTENTS</label>
  			<textarea class="form-control" id="contents" rows="3"></textarea>
		</div>
		<div class="mb-3">
			<button type="button" id="commentAdd" data-book-num="${detail.bookNum}">댓글작성</button>
	  </div>
		
	</div>
	<!---------Comment List 출력-->

	<div id="commentList" class="table table-hover">
		<table>

		</table>
	</div>
	<button id="more" class="btn btn-danger diabled">더보기</button>
	<!---------Comment------------>

	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/bankBookComment.js"></script>
</body>
</html>