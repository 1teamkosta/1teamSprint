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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/qnaWrite.css">
	<script src="${pageContext.request.contextPath}/js/qnaWrite.js" defer></script>
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
        <div class="bodyWarp">
        
        	<div id="qnaForm" data-question-number="${fix.questionNumber}">
	            <div class="bodyWrapHader">
	              <h2 class="tilte">Q&A</h2>
	            </div>
	            <input class="inputTitle" name="title" value="${fix.title}" placeholder="  제목을 입력해 주세요."> <br>
	            
				<%@ include file="../common/write.jsp" %>
				
				<!-- 등록 -->
				<c:if test="${empty fix.questionNumber}">
				<a href="#" id="addQnaBtn" class="qnaSubmitBtn">등록</a>
				</c:if>
				<!-- 수정 -->
				<c:if test="${not empty fix.questionNumber}">
				<a href="#" id="setQnaBtn" class="qnaSubmitBtn">수정</a>
				</c:if>
        	</div>
      </div>
	</div>
</div>




