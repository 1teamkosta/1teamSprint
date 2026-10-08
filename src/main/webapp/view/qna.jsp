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
				
	                <div class="question-footer">
	                    <div class="question-owner-buttons">
					        <a href="${pageContext.request.contextPath}/Controller?cmd=setQnaUI&questionNumber=${question.questionNumber}" class="edit-btn">수정</a>
					        <a href="${pageContext.request.contextPath}/Controller?cmd=deleteQnaAction&questionNumber=${question.questionNumber}" class="delete-btn" onclick="return confirm('정말 이 질문을 삭제하시겠습니까?');">삭제</a>
	    				</div>
	                </div>
                
                
            </div>

            <!-- 답변 영역 -->
            <div class="answer-area">
                <div class="answer-header">
                    <strong>답변 ${question.answerCount}개</strong>
                </div>

                <!-- 답변 작성 -->
                <form action="${pageContext.request.contextPath}/Controller?cmd=addAnswerAction" method="post">
	                <div class="answer-write">
	                    <input type="hidden" name="questionNumber" value="${question.questionNumber}">
	                    <textarea
	                        class="answer-input" name="content" placeholder="질문에 대한 답변을 작성해주세요.">
	                    </textarea>
	                    <div class="answer-write-bottom">
	                        <span>다른 사장님들에게 도움이 되는 답변을 남겨주세요.</span>
	                        
	                        <button type="submit" class="answer-submit">답변 등록</button>
	                       
	                    </div>
	                </div>
                </form>

				<!-- 답변 목록 반복문 -->
				<c:forEach var="answer" items="${answer}">
				    <div class="answer-item" id="answer-item-${answer.answerNumber}">
				        <c:if test="${answer.selectState}">
				            <div class="selected-answer-badge">✓ 채택된 답변</div>
				        </c:if>
				        
				        <div class="answer-user">
				            <strong>${answer.nickname}</strong>
				            <span>${answer.writeDate}</span>
				        </div>
				
				        <!-- 1. 기본 답변 내용 화면 -->
				        <div class="answer-content" id="answer-content-${answer.answerNumber}">
				            ${answer.content}
				        </div>
				
				        <!-- 2. [숨김 상태] 수정용 textarea 폼 -->
				        <form action="${pageContext.request.contextPath}/Controller?cmd=setAnswerAction" method="post" 
				              class="answer-edit-form" id="edit-form-${answer.answerNumber}" style="display: none;">
				            <input type="hidden" name="questionNumber" value="${question.questionNumber}">
				            <input type="hidden" name="answerNumber" value="${answer.answerNumber}">
				            
				            <textarea name="content" class="answer-input-edit">${answer.content}</textarea>
				            
				            <div class="edit-form-buttons">
				                <button type="submit" class="edit-submit-btn">수정완료</button>
				                <button type="button" class="edit-cancel-btn" onclick="cancelEdit('${answer.answerNumber}')">취소</button>
				            </div>
				        </form>
				
				        <div class="answer-footer">
				            <!-- 질문 작성자만 보이는 채택 버튼 -->
				            
				                <form action="${pageContext.request.contextPath}/Controller?cmd=adoptAnswerAction" method="post">
				                    <input type="hidden" name="answerNumber" value="${answer.answerNumber}">
				                    <input type="hidden" name="questionNumber" value="${question.questionNumber}">
				                    <button type="submit" class="answer-select-btn">채택</button>
				                </form>
				            <c:if test="${question.memberNumber == sessionScope.memberNumber}"></c:if>
				
				            <!-- 답변 작성자만 보이는 수정/삭제 버튼 -->
				            
				                <div class="answer-owner-buttons" id="owner-btns-${answer.answerNumber}">
				                    <!-- 수정 버튼 클릭 시 JS 함수 호출 -->
				                    <button type="button" class="edit-btn" onclick="toggleEdit('${answer.answerNumber}')">수정</button>
				                    <a href="${pageContext.request.contextPath}/Controller?cmd=deleteAnswerAction&questionNumber=${question.questionNumber}&answerNumber=${answer.answerNumber}" 
				                       class="delete-btn" onclick="return confirm('답변을 삭제하시겠습니까?');">삭제</a>
				                </div>
				            <c:if test="${answer.memberNumber == sessionScope.memberNumber}"></c:if>
				        </div>
				    </div>
				</c:forEach>
				
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script>
    // 수정 모드로 전환
    function toggleEdit(answerNumber) {
        document.getElementById('answer-content-' + answerNumber).style.display = 'none'; //기존 답변 읽기 전용으로 숨기기
        document.getElementById('edit-form-' + answerNumber).style.display = 'block'; //수정 폼 화면 표시
        document.getElementById('owner-btns-' + answerNumber).style.display = 'none'; //수정 삭제 버튼 숨기기
    }

    // 수정 취소 (기존 내용으로 복구)
    function cancelEdit(answerNumber) {
        document.getElementById('answer-content-' + answerNumber).style.display = 'block'; //답변 읽기 전용 표시
        document.getElementById('edit-form-' + answerNumber).style.display = 'none'; //수정 폼 화면 숨기기
        document.getElementById('owner-btns-' + answerNumber).style.display = 'block'; //수정 삭제 버튼 표시
    }
</script>
