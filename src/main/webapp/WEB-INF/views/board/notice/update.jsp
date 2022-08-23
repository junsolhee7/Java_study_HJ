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
<form action="update.iu" method = "POST">
		<div>
			<input type="text" name = "num" readonly value="${requestScope.update.num}">
		</div>
		<div>
			Title : <input type="text" name="title" value="${requestScope.update.title}" >
		</div>
		<div>
			Contents : <input type="text" name="contents" value="${requestScope.update.contents}">
		</div>
		<div>
			Writer :<input type="text" name="writer" readonly value="${requestScope.update.writer}" >
		</div>
		<div>
			RegDate :<input type="text" name="regDate" value="${requestScope.update.regDate}" >
		</div>
			<button type="submit">수정</button>
			<input type="submit" value="수정">
		</form>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>