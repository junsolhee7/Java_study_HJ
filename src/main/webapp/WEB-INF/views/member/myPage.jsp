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

<table class="table table-sm">
	<thead>
		<tr class="table-info">
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
		</tr>
	</thead>
	<tbody>
		<tr>
<%-- 		<td>${map.dto.userName}</td>
			<td>${map.dto.name}</td>
			<td>${map.dto.email}</td>
			<td>${map.dto.phone}</td> --%>
			
			<td>${dto.userName}</td>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
		</tr>
	</tbody>
</table>

<table class="table table-sm">
	<thead>
		<tr class="table-info">
				<th>계좌번호</th>
				<th>통장이름</th>
				<th>통장개설일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${dto.bankAccountDTO}" var="dta">
			<tr>
<%-- 			<td>${dto.accountNum}</td>
				<td>${dto.bankBookDTO.bookName}</td>
				<td>${dto.accountDate}</td> --%>
				
				<td>${dta.accountNum}</td>
				<td>${dta.bankBookDTO.bookName}</td>
				<td>${dta.accountDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

		<div class="row">
			<img alt="" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
		</div>

	


<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>