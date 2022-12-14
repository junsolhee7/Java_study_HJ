<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-2 mt-5">
	    <div class="row">
	    	<h1>회원가입</h1>
	        <form action="join.iu" method="post" enctype="multipart/form-data">

	            <h4>아이디</h4>
	            <input type="text" name="userName" class="form-control" id="id">
				<div></div>

	            <h4>비밀번호</h4>
	            <input type="password" name="passWord" class="form-control" id="pwd">

				<h4>비밀번호 확인</h4>
	            <input type="password" name="passWord" class="form-control" id="pwd2">
				<div id="pwc">ㅇㅅㅇㅂㅇ</div>

	            <h4>이름</h4>
	            <input type="text" name="name" class="form-control" id="nam">
				<div></div>

	            <h4>본인 확인 이메일 <span>(선택)</span></h4>
	            <input type="email" name="email" class="form-control" id="email">
				<div></div>

	            <h4>휴대전화</h4>
	            <div>
	                <input type="number" name="phone" placeholder="전화번호 입력" class="form-control" id="phone">
	            </div>

	            <div>
	                <input type = "button" value="가입하기" id="frm">
	            </div>
	            
	            <h4>사진</h4>
	            <input type="file" name="photo" class="form-control" id="photo">

				<h4>테스트</h4>
	            <input type="text" name="test" class="form-control" id="test">
	        </form>
	    </div>
    </section>
    
    <c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/memberLogin.js"></script>
</body>
</html>
