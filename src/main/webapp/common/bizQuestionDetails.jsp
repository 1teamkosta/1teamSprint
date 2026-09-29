<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Icons"/>
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
              <h3 class="tilte">문의</h3>
              <div class="btnright">
              <button class="writeBtn">수정</button>
              <button class="writeBtn">삭제</button>
              </div>
            </div>

            <div class="th">
                <h1>지역변경문의</h1>
                <h4 class="subTitle">2026.09.20 신중동 불주먹 <br> 조회 14 추천 3</h4>

            </div>
              
              <span class="contentBox">가게 위치를 옮기게 되어 지역변경하고 싶습니다 <br> 구로구 구로1동으로 옮겨주세요!</span>

            <div class="commentHeader">
              <button type="button" class="likeBtn">
              <span class="material-symbols-outlined">thumb_up</span> 추천 3</button>
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
                문의하신 내용으로 신중동 불주먹님의 지역이 변경 완료되었습니다.
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