
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! GregorianCalendar ca = new GregorianCalendar();  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 작성</h3>
	<form action="add" method="POST">
		글제목 <input type="text" name="title" ><br>
		글내용 <input type="text" name="contents"><br>
		
		<input type="submit" value="입력">
		<button type="submit">Add</button>
		<input type="reset" value="초기화">	
	</form>
	

</body>
</html>