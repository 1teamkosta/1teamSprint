<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>중고거래</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="../style/common.css">
	<link rel="stylesheet" href="../style/bizTrading.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
		
        <div class="bodyWarp">
          <div>
            <div class="bodyWrapHader">
              <h2 class="tilte">중고 거래
              </h2>
              <button class="writeBtn">작성하기</button>
            </div>

        <div class="product-grid">

            <div class="item-card">
              <div class="image-box">
                <img src="테이블.jpg" alt="테이블">
                <div class="price-box">5만원</div>
              </div>
              <div class="info-box">
                <div class="item-title">테이블 팝니다</div>
                <div class="item-author">별사장</div>
                <div class="item-meta">2026.09.23 조회수 20</div>
              </div>
            </div>

            <div class="item-card">
              <div class="image-box">
                <img src="젓가락.jpg" alt="젓가락">
                <div class="price-box">1,000원</div>
              </div>
              <div class="info-box">
                <div class="item-title">젓가락 3세트 판매합니다</div>
                <div class="item-author">밀크티사장</div>
                <div class="item-meta">2026.09.22 조회수 35</div>
              </div>
            </div>

            <div class="item-card">
              <div class="image-box">
                <img src="숟가락.jpg" alt="숟가락">
                <div class="price-box">무료나눔</div>
              </div>
              <div class="info-box">
                <div class="item-title">숟가락 나눔해요~</div>
                <div class="item-author">밀크티사장</div>
                <div class="item-meta">2026.09.22 조회수 42</div>
              </div>
            </div>
           </div>
          </div>
          
          <%@ include file="../common/pagination.jsp" %>
        </div>
	</div>
	
</div>

</body>
</html>