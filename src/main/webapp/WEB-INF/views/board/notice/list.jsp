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

	<table class="table table-sm">
		<thead>
			<tr class="table-info">
				<th>글번호</th>
				<th>글제목</th>
				<th>글작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="10" end="0" var="i" step="1">
			<%-- for(int i=0;i<=10;i=i+2) --%>
				<h3>${pageScope.i}</h3>
			</c:forEach>
			
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td class="table-secondary">${pageScope.dto.num}</td>
					<td class="table-success"><a href="./detail?num=${dto.num}">${pageScope.dto.title}</a></td>
					<td class="table-warning">${pageScope.dto.writer}</td>
					<td class="table-primary">${pageScope.dto.regDate}</td>
					<td class="table-secondary">${pageScope.dto.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add">게시글 작성</a>
<c:import url="../../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>