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
                <c:if test="${trade.memberNumber == sessionScope.memberNumber}">
              <div class="btnright">
    			<a href="Controller?cmd=setTradeAction&tradeNumber=${trade.tradeNumber}" class="writeBtn">수정</a>
    			<a href="Controller?cmd=deleteTradeAction&tradeNumber=${trade.tradeNumber}"
       			   class="writeBtn deleteBtn"
       			   data-confirm="정말 삭제하시겠습니까?'">삭제</a>
			  </div>
              </c:if>
            </div>

            <div class="th">
            	<div class="subColor">${trade.tradeNumber}</div>
                <h1>${trade.title}</h1>
                <div class="subColor">${trade.writeDate} 신중동불주먹<br> 조회 ${trade.viewCount}</div>
                <h1 class="bordergap">${trade.price}원</h1> 
             </div>
              
              <div class="imageBox">
              <img src="테이블.jpg" alt="테이블">
              </div>
              <div class="content">${trade.content}</div>

            <div class="commentHeader">
              <h4>댓글 ${trade.replyCount}</h4>
            </div>

		<form action="${pageContext.request.contextPath}/Controller?cmd=addReplyAction" method="post" class="commentWrite">
            <input type="hidden" name="tradeNumber" value="${trade.tradeNumber}">
            <textarea name="content" placeholder="댓글을 입력해 주세요." required></textarea>
            <div class="btnGroup">
              <button type="submit" class="submitBtn">등록</button>
            </div>
        </form>
        
          <div class="commentList">
			<c:forEach var="reply" items="${trade.reply}">
              <div class="commentItem" id="commentItem${reply.replyNumber}">
                <div class="commentUser">
                ${reply.nickname}
                </div>
                <div class="commentbox" id="commentbox${reply.replyNumber}">
                <c:out value="${reply.content}" />
                </div>
  				<form action="Controller?cmd=setReplyAction" method="post"
        		id="edit${reply.replyNumber}" style="display:none;">
        		<input type="hidden" name="tradeNumber" value="${trade.tradeNumber}">
			    <input type="hidden" name="replyNumber" value="${reply.replyNumber}">
			    <textarea name="content" required>${reply.content}</textarea>
			    <button type="submit" class="commentBtn">저장</button>
			    <button type="button" class="commentBtn" data-action="cancelEdit" data-reply="${reply.replyNumber}">취소</button>
                </form>
                <div class="subColor">
                ${reply.writeDate}
                <%-- 댓글 작성자만 보이는 수정/삭제 버튼 --%>
                <c:if test="${reply.memberNumber == sessionScope.memberNumber}">
                <button type="button" class="commentBtn" data-action="toggleEdit" data-reply="${reply.replyNumber}">수정</button>
                <a href="${pageContext.request.contextPath}/Controller?cmd=deleteReplyAction&tradeNumber=${trade.tradeNumber}&replyNumber=${reply.replyNumber}" 
				class="commentBtn" data-confirm="댓글을 삭제하시겠습니까?">삭제</a>
                </c:if>
                </div>
              </div>
              
              </c:forEach>
           </div>
        </div>
	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Trade.js"></script>
</html>