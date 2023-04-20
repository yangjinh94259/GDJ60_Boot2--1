<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- favicon 적용 -->
        <c:import url="../temp/style.jsp"></c:import>
        <!-- favicon 끝 -->
    </head>
</head>
 		<body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
        <!-- Navigation-->
            <c:import url="../temp/header.jsp"></c:import>
        	
        		<section class="bg-light py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">${board} List</h1>
                        <p class="lead fw-normal text-muted mb-0">With our no hassle pricing plans</p>
                    </div>
                    
                    <div>
                    	<table class="table table-hover">
                    		<thead>
                    			<tr>
									<th>Num</th>
                    				<th>Title</th>
                    				<th>Writer</th>
                    				<th>Date</th>
                    				<th>Hit</th>
                    			</tr>
                    		</thead>
                    		<tbody>
                    			<c:forEach items="${list}" var="boardVO">
                    				<tr>
                    					<td>${boardVO.num}</td>
                    					<td><a href="./detail?num=${boardVO.num}">${boardVO.title}</a></td>
                    					<td>${boardVO.name}</td>
                    					<td>${boardVO.regDate}</td>
                    					<td>${boardVO.hit}</td>
                    				</tr>
                    			</c:forEach>
                    		</tbody>
                    	</table>
                    	
                    </div>
                    
                    
      <div class="row justify-content-center">
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		 
		     <li class="page-item ${pager.before  ? 'disabled' : ''}">
		      <a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		  
		    <li class="page-item ${pager.before  ? 'disabled' : ''}">
		      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&lsaquo;</span>
		      </a>
		    </li>
		    
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		    </c:forEach>
		    
		     <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
		      <a class="page-link"  href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&rsaquo;</span>
		      </a>
		    </li>
		   
		    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
		      <a class="page-link"  href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	
		  </ul>
		</nav>
		</div>
			
			
			<!-- 검색창 -->
			<div class="row">
				<form class="row g-3" action="./list" method="get">
				  <div class="col-auto">
				    <label for="kind" class="visually-hidden">Kind</label>
				    <select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title">제목</option>
						<option value="info">내용</option>
						<option value="name">작성자</option>
					  </select>
				  </div>
				  <div class="col-auto">
				    <label for="search" class="visually-hidden">Search</label>
				    <input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요">
				  </div>
				  <div class="col-auto">
				    <button type="submit" class="btn btn-primary mb-3">검색</button>
				  </div>
				</form>
			</div>
           </div>
         </section>

		<a href="./add">WRITE</a>

        </main>
       	 <!-- Footer 적용 -->
       		<c:import url="../temp/footer.jsp"></c:import>
      	 <!-- Footer 끝 -->
</body>
</html>