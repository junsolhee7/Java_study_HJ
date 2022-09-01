
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! GregorianCalendar ca = new GregorianCalendar();  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- JQuert -->
 <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
 <!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    <!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>${board} Add Page</h1>
	<h3>게시글 작성</h3>
	<form action="add" method="POST" enctype="multipart/form-data">
		글제목 <input type="text" name="title" ><br>
		<!-- 글내용 <input type="text" name="contents"><br> -->
		글내용 <textarea class="form-control" name="contents" id="contents" rows="3"></textarea><br>

		<div id="addFiles">
			<button type="button" class="btn-danger" id="fileAdd">파일추가</button>
			<!-- <input type="file" name="files" class="form-control" id="addFiles">
			<input type="file" name="files" class="form-control" id="addFiles">
			<input type="file" name="files" class="form-control" id="addFiles"> -->
		</div>
		
		<input type="submit" value="입력">
		<button type="submit">Add</button>
		<input type="reset" value="초기화">	
	</form>
<c:import url="../template/footer.jsp"></c:import>
<!-- BootStrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
	$("contents").summernote();
</script>
<script src="/resources/js/add.js"></script>
</body>
</html>
