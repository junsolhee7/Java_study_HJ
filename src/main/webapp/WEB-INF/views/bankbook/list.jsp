<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
			 <tr>
			 	<td><a href="./detail.iu?bookNum=${pageScope.dto.bookNum}">${pageScope.dto.bookName}</a></td>
			 	<td>${pageScope.dto.bookRate}</td>
			 </tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	
	<a href="./add.iu">상품등록</a>
	
</body>
</html>