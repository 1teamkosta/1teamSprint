<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자유수다</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
	<link rel="stylesheet" href="../style/common.css">
	<link rel="stylesheet" href="../style/bizTip.css">
	<link rel="stylesheet" href="../style/freeBoard.css">
	<link rel="stylesheet" href="../style/bizTradingDetails.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
<div class="bodyWarp">
          <div>
            <div class="bodyWrapHader">
              <h3 class="tilte">자유수다</h3>
              <div class="btnright">
              <button class="writeBtn">수정</button>
              <button class="writeBtn">삭제</button>
              </div>
            </div>

            <div class="th">
                <h1>&lt;유머&gt;가장 폭력적인 동물은?</h1>
                <h4 class="subcolor">2026.09.22 임사장 <br> 조회 816 추천 36</h4>
              

              </div>
              <div class="imageBox">
              <img src="팬더.jpg" alt="팬더">
              </div>
              <span class="content">팬더</span>

            <div class="commentHeader">
              <button type="button" class="likeBtn">
              <span class="material-symbols-outlined">thumb_up</span> 추천 36</button>
              <h4>댓글 3</h4>
            </div>

          <div class="commentWrite">
            <textarea placeholder="댓글을 입력해 주세요." id="commentInput"></textarea>
            <div class="btnGroup">
              <button type="button" class="submitBtn" id="submitComment">등록</button>
            </div>
          </div>
          
          <div class="commentList">
              <div >
                <span class="commentItem">이사장</span>
                <div class="commentbox">
                ?
                </div>
                <div class="subcolor">
                2026.09.28
                </div>
              </div>

              <div >
                <span class="commentItem">말사장</span>
                <div class="commentbox">
                ㅋㅋㅋㅋㅋ @))))))))))))) 김밥 한줄 놓고 갑니다~
                </div>
                <div class="subcolor">
                2026.09.28
                </div>
              </div>

              <div >
                <span class="commentItem">골목대장</span>
                <div class="commentbox">
                재밌네요
                </div>
                <div class="subcolor">
                2026.09.28
                </div>
              </div>

          </div>
          </div>
        </div>
	</div>

</div>