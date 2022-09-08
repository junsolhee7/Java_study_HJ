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
<section class="container-fluid col-lg-6">

	
	<h1>${board} List Page</h1>
	<div class="row mb-3">
		<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
		
			<div class="col-12">
				<label class="visually-hidden" for="kind">Preference</label>
		    <select name = "kind" class="form-select" id="kind">
				<option class = "kinds" id="contents" value="contents">Contents</option>
				<option class = "kinds" id="title" value="title">Title</option>
				<option class = "kinds" id="writer" value="writer">Writer</option>
		    </select>
		</div>
		
		
		  <div class="col-12">
		    <label class="visually-hidden" for="search">검색어</label>
		    <div class="input-group">
		      <input type="text" name = "search" value="${param.search}" class="form-control" id="search" >
		    </div>
		</div>
		
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
		</form>
	</div>
	
	
	
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
					
					<td class="table-success">
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}">&emsp;</c:forEach>
						</c:catch>
					<a href="./detail?num=${dto.num}">${pageScope.dto.title}</a>
				</td>
					
				<td class="table-warning">${pageScope.dto.writer}</td>
				<td class="table-primary">${pageScope.dto.regDate}</td>
					<td class="table-secondary">${pageScope.dto.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="./add">게시글 작성</a>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${pager.pre}">
				<li class="page-item">
	      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			  <span aria-hidden="true">&laquo;</span>
			</a>
	    </li>
    	</c:if>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
	    </c:forEach>
	    
	    <%-- <c:choose>
	    	<c:when test="${pager.next }">
	    			<li class="page-item">
					</c:when>
	    	<c:otherwise>
				<li class="page-item disabled">
				</c:otherwise>
			</c:choose> --%>
			
			<li class="page-item ${pager.next?'':'disabled'}">
	      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			  <span aria-hidden="true">&raquo;</span>
			</a>
	    </li>
	</ul>
</nav>

</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
<script>
	let k ='${param.kind}'; //contents,title,writer
	const kinds = document.getElementsByClassName("kinds");
	for(let i=0; i<kinds.length;i++){
		if(k==kinds[i].value){
		kinds[i].selected=true;
		break;
		}
	}
</script>


</body>
</html>