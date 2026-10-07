<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>중고거래</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Icons"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/common.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/bizTradingDetails.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
		
        <div class="bodyWarp">
        
            <div class="bodyWrapHader">
              <h3 class="tilte">중고거래</h3>
                <span>${trade.tradeNumber}</span>
                <c:if test="${trade.memberNumber == sessionScope.memberNumber}">
              <div class="btnright">
              <a href="#" class="writeBtn">수정</a>
              <a href="#" class="writeBtn">삭제</a>
              </div>
              </c:if>
            </div>

            <div class="th">
            	<div class="subColor">${trade.tradeNumber}</div>
                <h1>${trade.title}</h1>
                <div class="subColor">${trade.writeDate} ${trade.nickname} <br> 조회 ${trade.viewCount}</div>
                <h1 class="bordergap">${trade.price}</h1> 
             </div>
              
              <div class="imageBox">
              <img src="테이블.jpg" alt="테이블">
              </div>
              <div class="content">${trade.content}</div>

            <div class="commentHeader">
              <h4>댓글 ${trade.replyCount}</h4>
            </div>

		<form action="${pageContext.request.contextPath}/controller?cmd=addTradeReplyAction" method="post">
          <div class="commentWrite">
            <input type="hidden" name="tradeNumber" value="${trade.tradeNumber}">
            <textarea name="content" placeholder="댓글을 입력해 주세요."></textarea>
            <div class="btnGroup">
              <button type="button" class="submitBtn">등록</button>
            </div>
          </div>
        </form>
        
          <div class="commentList">
			<c:forEach items="${trade.reply}" var="reply">
              <div class="commentItem">
                <div class="commentUser">
                ${reply.nickname}
                </div>
                <div class="commentbox">
                <c:out value="${reply.content}" />
                </div>
                <div class="subColor">
                ${reply.writeDate}
                <c:if test="${reply.memberNumber == sessionScope.memberNumber}">
                <a href="#" type="button" class="commentBtn">수정</a>
                <form action="controller?cmd=DeleteTradeReplyAction" method="post">
                <a href="#" type="button" class="commentBtn">삭제</a>
                </form>
                </c:if>
                </div>
              </div>
              
              </c:forEach>
           </div>
        </div>
	</div>
</div>
</body>
</html>