<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>자유수다</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="../style/common.css">
	<link rel="stylesheet" href="../style/bizTip.css">
	<link rel="stylesheet" href="../style/freeBoard.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
        <div class="bodyWarp">
        
          <div>
            <div class="bodyWrapHader">
              <h2 class="tilte">거래 글쓰기</h2>
            </div>
            <div class="inputTitle titleprice">
            	<input class="priceTitle" placeholder="  제목을 입력해 주세요.">
            	<input class="priceInput" placeholder="  가격">
			</div>
			<%@ include file="../common/write.jsp" %>

        </div>
      </div>
	</div>
</div>