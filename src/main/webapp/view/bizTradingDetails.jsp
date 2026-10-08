<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

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
          <div>
            <div class="bodyWrapHader">
              <h3 class="tilte">중고거래</h3>
              <div class="btnright">
			<a href="Controller?cmd=setTrade" class="writeBtn">수정</a>
			<a href="Controller?cmd=deleteTrade" class="writeBtn">삭제</a>
              </div>
            </div>

            <div class="th">
            	<div class="subColor"></div>
                <h1>${trade.title}</h1>
                <div class="subColor">2026.09.27 ${trade.nickname} <br> 조회 ${trade.viewCount}</div>
                <h1 class="bordergap">${trade.price}</h1>  
             </div>
              
              <div class="imageBox">
              <img src="테이블.jpg" alt="테이블">
              </div>
              <span class="content">${trade.content}</span>

            <div class="commentHeader">
              <h4>댓글 7</h4>
            </div>

          <div class="commentWrite">
            <textarea placeholder="댓글을 입력해 주세요." id="commentInput"></textarea>
            <div class="btnGroup">
              <button type="button" class="submitBtn" id="submitComment">등록</button>
            </div>
          </div>
          
          <div class="commentList">

              <div class="commentItem">
                <div class="commentUser">
                임사장
                </div>
                <div class="commentbox">
                안 팔렸습니다~
                </div>
                <div class="subColor">
                2026.09.28
                <button type="button" class="commentBtn" id= "submitComment">수정</button> |
                <button type="button" class="commentBtn" id= "submitComment">삭제</button>
                </div>
              </div>
              
              <div class="commentItem">
                <div class="commentUser">
                밀크티사장
                </div>
                <div class="commentbox">
                혹시 팔렷슬까요
                </div>
                <div class="subColor">
                2026.09.28
                </div>
              </div>

              <div class="commentItem">
                <div class="commentUser">
                골목사장
                </div>
                <div class="commentbox">
                테이블 상세사진 볼 수 있을까요
                </div>
                <div class="subColor">
                2026.09.28
                </div>
              </div>

              <div class="commentItem">
                <div class="commentUser">
                임사장
                </div>
                <div class="commentbox">
                테이블 예쁘네요
                </div>
                <div class="subColor">
                2026.09.27
                </div>
              </div>

              <div class="commentItem">
                <div class="commentUser">
                호올스
                </div>
                <div class="commentbox">
                가격 깎아주세요~
                </div>
                <div class="subColor">
                2026.09.27
                </div>
              </div>

              <div class="commentItem">
                <div class="commentUser">
                치자피즈
                </div>
                <div class="commentbox">
                사고싶습니당
                </div>
                <div class="subColor">
                2026.09.27
                </div>
              </div>
              

              <div class="commentItem">
                <div class="commentUser">
                박사장
                </div>
                <div class="commentbox">
                구매 원합니다~!
                </div>
                <div class="subColor">
                2026.09.27
                </div>
              </div>

          </div>
          </div>
        </div>
	</div>
	
</div>

</body>
</html>