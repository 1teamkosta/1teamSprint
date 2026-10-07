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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/qna.css">
</head>

<body>

<div class="wrap">
    <%@ include file="../common/header.jsp" %>
    <div class="content">
        <%@ include file="../common/sideNav.jsp" %>
        <div class="bodyWarp">

            <!-- 질문 영역 -->
            <div class="question-area">
                <div class="question-header">
                    <div class="question-category">Q&A</div>
                    <div class="question-info">
                    	<span>${question.questionNumber}</span>
                    </div>
                    <h1 class="question-title">${question.title}</h1>
                    <div class="question-info">
                        <span>${question.nickname}</span>
                        <span>${question.writeDate}</span>
                        <span>조회 ${question.viewCount}</span>
                    </div>
                </div>

                <div class="question-content">
                    ${question.content}
                </div>
				<c:if test="${question.memberNumber == sessionScope.memberNumber}">
	                <div class="question-footer">
	                    <div class="question-owner-buttons">
					        <a href="#" class="edit-btn">수정</a>
					        <a href="#" class="delete-btn">삭제</a>
	    				</div>
	                </div>
                </c:if>
                
            </div>

            <!-- 답변 영역 -->
            <div class="answer-area">
                <div class="answer-header">
                    <strong>답변 ${question.answerCount}개</strong>
                </div>

                <!-- 답변 작성 -->
                <form action="${pageContext.request.contextPath}/Controller?cmd=addAnswer" method="post">
	                <div class="answer-write">
	                    <input type="hidden"
				        name="questionNumber"
				        value="${question.questionNumber}">
	                    <textarea
	                        class="answer-input"
	                        name="content"
	                        placeholder="질문에 대한 답변을 작성해주세요."></textarea>
	                    <div class="answer-write-bottom">
	                        <span>다른 사장님들에게 도움이 되는 답변을 남겨주세요.</span>
	                        <button type="submit" class="answer-submit">답변 등록</button>
	                    </div>
	                </div>
                </form>

                <!-- 답변  -->
                <c:forEach var="answer" items="${answer}">
	               <div class="answer-item">
	              		<c:if test="${answer.selectState}">
	                		<div class="selected-answer-badge">✓ 채택된 답변</div>
	                	</c:if>
	                    <div class="answer-user">
	                        <strong> ${answer.nickname}</strong>
	                        <span> ${answer.writeDate}</span>
	                    </div>
	                    <div class="answer-content">
	                    	${answer.content}
	                    </div>
	                    <div class="answer-footer">
	                    	<c:if test="${question.memberNumber == sessionScope.memberNumber}">
	                    		<button type="button" class="answer-select-btn">채택</button>
	                    	</c:if>
	                        <c:if test="${answer.memberNumber == sessionScope.memberNumber}">
	                        <div class="answer-owner-buttons">
					            <a href="#" class="edit-btn">수정</a>
					            <a href="#" class="delete-btn">삭제</a>
					        </div>
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
