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
	
	<section class="container-fluid col-lg-4 mt-5">
		<div class="row">
			<form action="./login" method="post" id="frm">
			  <div class="mb-3">
			    <label for="usr" class="form-label" >아이디</label>
			    <input type="text" class="form-control" id="usr" aria-describedby="emailHelp" name="userName">
			    <div id="emailHelp" class="form-text">We'll never share your ID with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    <label for="pwd" class="form-label">비밀번호</label>
			    <input type="password" class="form-control" id="pwd" name="passWord">
			  </div>
			  <div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  <button type="button" class="btn btn-primary" id="btn" >로그인</button>
			</form>
		</div>
	</section>

	
	
    <c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/member.js"></script>
	<script>
		loginCheck();
	</script>
</body>
</html>

<!-- <div>
        <form action="./login" method="post">
            <div class="container">
                <h2>ID 로그인</h2>
                <div>
                    <input type="text" value="id1" name="userName" placeholder="아이디">
                </div>
                <div>
                    <input type="password" value="id1" name="passWord" placeholder="비밀번호">
                </div>
               
                <div class="login">
                    <input type="submit" value="로그인">
                </div>
            </div>
        </form>
    </div> -->