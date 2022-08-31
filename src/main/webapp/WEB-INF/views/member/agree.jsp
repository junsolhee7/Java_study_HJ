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

	<section class="container-fluid col-lg-2 mt-5">
		<h3>Agree Page</h3>
		<form action="agree" id="frm" method="post">
			<div class="row">
		        <div> 전체동의 <input type="checkbox" name="box" id="all"></div>
		        <div> 약관1(필수) <input type="checkbox" name="box" id="" class="cb req"></div>
		        <div> 약관2(필수) <input type="checkbox" name="box" id="" class="cb req"></div>
		        <div> 약관3(필수) <input type="checkbox" name="box" id="" class="cb req"></div>
		        <div> 약관4(선택) <input type="checkbox" name="box" id="" class="cb"></div>
		        <div> 확인<button type="button" id="join" value="확인"></div>
			</div>
		</form>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/member.js"></script>
</body>
</html>