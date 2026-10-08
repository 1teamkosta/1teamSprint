<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자유수다</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>

		
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/common.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/bizTip.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/freeBoard.css">
	

</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
        <div class="bodyWarp">
        
          <div>
            <div class="bodyWrapHader">
              <h2 class="tilte">거래 글쓰기</h2>
            </div>
            <div class="inputTitle titleprice">
            	<input class="priceTitle" placeholder="  제목을 입력해 주세요.">
            	<input class="priceInput" placeholder="  가격">
			</div>
					<%@ include file="../common/write.jsp" %>
							<!-- 등록 -->
				<c:if test="${empty fix.tradeNumber}">
				<a href="#" class="tradeSubmitBtn" onclick="addTrade(); return false;">등록</a>
				</c:if>
				<!-- 수정 -->
				<c:if test="${not empty fix.tradeNumber}">
				<a href="#" class="tradeSubmitBtn" onclick="setTrade(); return false;">수정</a>
				</c:if>
        	</div>
      </div>
	</div>
</div>


<script>
function getTitleContentData() {

    const title = document.querySelector('[name="title"]').value;
    const price = document.querySelector('[name="price"]').value;
    const content = quill.root.innerHTML;

    return {
        title: title,	
        price: price,
        content: content
    };
}
function addTrade() {
	const data = getTitleContentData();
	
	location.href = "${pageContext.request.contextPath}/Controller?cmd=addTrade" 
        + "&title=" + encodeURIComponent(data.title) 
        + "&price=" + encodeURIComponent(data.price) 
        + "&content=" + encodeURIComponent(data.content);
}}
function setTrade() {
	const data = getTitleContentData();
	
	location.href = "${pageContext.request.contextPath}/Controller?cmd=setTradeAction" 
        + "&tradeNumber=${fix.tradeNumber}" 
        + "&title=" + encodeURIComponent(data.title) 
        + "&price=" + encodeURIComponent(data.price) 
        + "&content=" + encodeURIComponent(data.content);}
</script>