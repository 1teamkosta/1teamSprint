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
              <h2 class="tilte">Q&A</h2>
              <button class="writeBtn">작성하기</button>
            </div>

            <table class="boardList">
              <tr class="tableTr" border="1">
              	<th>상태</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>답변수</th>
              </tr>
              <tr>
              <td>답변대기</td>
              <td class="tableTd">
              	<a href="#">외부음식 가져오는 손님?</a>
              </td>
              <td>박사장</td>
              <td>2026.09.20</td>
              <td>12</td>
              <td>8</td>
              </tr>
            </table>
          </div>
          <%@ include file="../common/pagination.jsp" %>
		</div>
	</div>

</div>