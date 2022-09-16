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
<h1>${board} Update Page</h1>
<c:import url="../template/header.jsp"></c:import>
<form action="update.iu" method = "POST" enctype="multipart/form-data">

		<div>
			글번호<input type="text" name = "num" readonly value="${requestScope.update.num}">
		</div>
		<div>
			글제목 : <input type="text" name="title" value="${requestScope.update.title}" >
		</div>
		<div>
			<%-- 글내용 : <input type="text" name="contents" value="${requestScope.update.contents}"> --%>
					
			글내용 : <textarea class="form-control" name="contents" rows="3"> ${update.contents} </textarea><br>
		</div>
		<div>
			작성자 :<input type="text" name="writer" readonly value="${requestScope.update.writer}" >
		</div>
		<div>
			작성일 :<input type="text" name="regDate" readonly value="${requestScope.update.regDate}" >
		</div>
		<div>
			조회수 :<input type="text" name="regDate" readonly value="${requestScope.update.hit}" >
		</div>
		
		<c:forEach items="${boardDTO.boardFileDTOs}" var=fileDTO>
			<div class="mb-3">
				<label for="files" class="form-label">File</label>
				<input type="file" vlaue="${fileDTO.oriName}" name="files" class="form-control" id="">
				<span>${fileDTO.oriName}</span>
				<button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
			</div>
		</c:forEach>
		boardFileDTOs
		
			<button type="submit">수정</button>
			<input type="submit" value="수정">
		</form>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/src/main/webapp/resources/js/add.js"></script>
<!-- <script>
	setCount(${boardDTO.boardFileDTOs.size()});
</script> -->
</body>
</html>