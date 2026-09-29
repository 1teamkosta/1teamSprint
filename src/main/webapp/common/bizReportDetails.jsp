<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장사 TIP</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Icons" />
	<link rel="stylesheet" href="../style/common.css">
	<link rel="stylesheet" href="../style/bizQuestionReportDetails.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
		
		<div class="bodyWarp">
          <div>
            <div class="bodyWrapHader">
              <h3 class="tilte">신고</h3>
              <div class="btnright">
              <button class="writeBtn">수정</button>
              <button class="writeBtn">삭제</button>
              </div>
            </div>

            <div class="th">
                <h1>회원 신고합니다</h1>
                <h4 class="subTitle">2026.09.20 신중동 불주먹 <br> 조회 23 추천 5</h4>

            </div>
              
              <span class="content">임사장님이 다른분 글에 여러번 댓글을 다시면서 불편하게 합니다... <br> 이 분 정지시킬 수 업나요...?</span>

            <div class="commentHeader">
              <button type="button" class="likeBtn">
              <span class="material-symbols-outlined">thumb_up</span> 추천 5</button>
              <h4>답변 1</h4>
            </div>

          <div class="commentWrite">
            <textarea placeholder="답변을 입력해 주세요." id="commentInput"></textarea>
            <div class="btnGroup">
              <button type="button" class="submitBtn" id="submitComment">등록</button>
            </div>
          </div>
          
          <div class="commentList">
             <div class="commentItem">
                <div class="commentUser">
                관리자
                </div>
                <div class="commentbox">
                신고하신 내용을 바탕으로 해당 회원 재재가 완료되었습니다.
                감사합니다.
                </div>
                <div class="subColor">
                2026.09.21
                </div>
              </div>
          </div>

          </div>
          
        </div>
	</div>
	
</div>

</body>
</html>