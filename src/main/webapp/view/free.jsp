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
              <h2 class="tilte">자유수다</h2>
              <button class="writeBtn">작성하기</button>
            </div>

            <table class="boardList">
              <tr class="tableTr" border="1">
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>추천</th>
              </tr>
              <tr>
              <td class="tableTd">
                <a href="#">&lt;유머&gt;남남수수학학원원장남남수</a>
                <span class="commentCount">[17]</span>
              </td>
              <td>카페인요정</td>
              <td>2026.09.27</td>
              <td>178</td>
              <td>66</td>
              </tr>
              
              <tr>
              <td class="tableTd">
                <a href="#">&lt;유머&gt;가장 폭력적인 동물은?</a>
                <span class="commentCount">[3]</span>
              </td>
              <td>임사장</td>
              <td>2026.09.22</td>
              <td>816</td>
              <td>36</td>
              </tr>
              
            </table>
          </div>
          <%@ include file="../common/pagination.jsp" %>
		</div>
	</div>

</div>