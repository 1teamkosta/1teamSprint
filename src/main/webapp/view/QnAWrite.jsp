<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Q&A</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/common.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/bizTip.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/freeBoard.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
        <div class="bodyWarp">
        
        	<div>
	            <div class="bodyWrapHader">
	              <h2 class="tilte">Q&A</h2>
	            </div>
	            <input class="inputTitle" name="title" value="${fix.title}" placeholder="  제목을 입력해 주세요."> <br>
	            
				<%@ include file="../common/write.jsp" %>
				
				<!-- 등록 -->
				<c:if test="${empty fix.questionNumber}">
				<a href="#" class="qnaSubmitBtn" onclick="addQna(); return false;">등록</a>
				</c:if>
				<!-- 수정 -->
				<c:if test="${not empty fix.questionNumber}">
				<a href="#" class="qnaSubmitBtn" onclick="setQna(); return false;">수정</a>
				</c:if>
        	</div>
      </div>
	</div>
</div>


<script>
function getTitleContentData() {

    const title = document.querySelector('[name="title"]').value;
    const content = quill.root.innerHTML;

    return {
        title: title,	
        content: content
    };
}
function addQna() {
	const data = getTitleContentData();
	
    location.href = "${pageContext.request.contextPath}/Controller?cmd=addQnaAction&title=" + encodeURIComponent(data.title) + "&content=" + encodeURIComponent(data.content);
}
function setQna() {
	const data = getTitleContentData();
	
	location.href = "${pageContext.request.contextPath}/Controller?cmd=setQnaAction&questionNumber=${fix.questionNumber}&title=" + encodeURIComponent(data.title) + "&content=" + encodeURIComponent(data.content);
}
</script>