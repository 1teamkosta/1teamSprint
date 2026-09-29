<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장사tip,공지사항,동네소식 글쓰기</title>
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
              <h2 class="tilte">장사tip,공지사항,동네소식 글쓰기</h2>
            </div>
				<input class="inputTitle" placeholder="  제목을 입력해 주세요.">
				<%@ include file="../common/write.jsp" %>
        </div>
      </div>
	</div>
</div>