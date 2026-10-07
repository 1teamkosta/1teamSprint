<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="paginationSearchWrap">
	<div class="pagination">
		<c:forEach var="i" begin="1" end="${totalPage}">
			<c:choose>
            	<c:when test="${i == curPage}">
                	<strong>${i}</strong>
            	</c:when>
            	<c:otherwise>
	                <a href="#" class="page-link" data-page="${i}">${i}</a>
    	        </c:otherwise>
        	</c:choose>
		</c:forEach>
	
		<!--
		<button class="paginationPrev">&lt;</button>
		<a href="#">1</a> 
		<a href="#">2</a> 
		<a href="#">3</a> 
		<a href="#">4</a>
		<a href="#">5</a>
		<button class="paginationPrev">&gt;</button>
		-->
	</div>

	<search> <select class="searchSelect">
		<option value="title">제목</option>
		<option value="author">작성자</option>
		<option value="content">내용</option>
		<option value="titleContent">제목+내용</option>
	</select>

	<div class="searchBar">
		<input type="text" class="searchInput" />
		<button class="searchBtn">검색</button>
	</div>
	</search>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/pagination.js"></script>