<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Q&A</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
    <link rel="stylesheet" href="../style/common.css">
    <link rel="stylesheet" href="../style/qna.css">
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
                    <h1 class="question-title">가게 처음 시작할 때 꼭 필요한 준비물이 있을까요?</h1>
                    <div class="question-info">
                        <span>임사장</span>
                        <span>2026.09.29</span>
                        <span>조회 15</span>
                    </div>
                </div>

                <div class="question-content">
                    <p>이번에 처음으로 작은 카페를 시작하게 되었습니다.</p>
                    <p>사업자등록이나 각종 준비는 하고 있는데
                        실제로 가게를 운영하기 전에 미리 준비하면
                        좋은 것들이 어떤 게 있을까요?</p>
                    <p>경험 있으신 사장님들의 조언 부탁드립니다.</p>
                </div>

                <div class="question-footer">
                    <div class="question-owner-buttons">
				        <a href="#" class="edit-btn">수정</a>
				        <a href="#" class="delete-btn">삭제</a>
    				</div>
                </div>
            </div>

            <!-- 답변 영역 -->
            <div class="answer-area">
                <div class="answer-header">
                    <strong>답변 2개</strong>
                </div>

                <!-- 답변 작성 -->
                <div class="answer-write">
                    <textarea
                        class="answer-input"
                        placeholder="질문에 대한 답변을 작성해주세요."></textarea>
                    <div class="answer-write-bottom">
                        <span>다른 사장님들에게 도움이 되는 답변을 남겨주세요.</span>
                        <button type="button" class="answer-submit">답변 등록</button>
                    </div>
                </div>

                <!-- 답변 1 -->
                <div class="answer-item">
                	<div class="selected-answer-badge">✓ 채택된 답변</div>
                
                    <div class="answer-user">
                        <strong>카페사장님</strong>
                        <span>2026.09.29</span>
                    </div>
                    <div class="answer-content">
                        <p>처음 시작하시는 거라면 메뉴 구성과 재료 관리부터
                            미리 정리해두시는 것을 추천드립니다.</p>
                        <p>특히 오픈 초반에는 생각보다 재고 관리가
                            어렵기 때문에 간단하게라도 기록해두시면 좋아요.</p>
                    </div>
                    <div class="answer-footer">
                    	<button type="button" class="answer-select-btn">채택</button>
                        
                        <div class="answer-owner-buttons">
				            <a href="#" class="edit-btn">수정</a>
				            <a href="#" class="delete-btn">삭제</a>
				        </div>
                    </div>
                </div>

                <!-- 답변 2 -->
                <div class="answer-item">
                    <div class="answer-user">
                        <strong>10년차사장</strong>
                        <span>2026.09.29</span>
                    </div>
                    <div class="answer-content">
                        <p>사업자등록이나 인허가 관련 서류도 중요하지만
                            실제 운영에 필요한 물품을 미리 체크하는 것도 중요합니다.</p>
                        <p>포스기, 카드 단말기, 포장용품 등은
                            오픈 전에 미리 준비해두시는 걸 추천합니다.</p>
                    </div>
                    <div class="answer-footer">
                        <button type="button" class="answer-select-btn">채택</button>
                        
                        <div class="answer-owner-buttons">
				            <a href="#" class="edit-btn">수정</a>
				            <a href="#" class="delete-btn">삭제</a>
				        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
