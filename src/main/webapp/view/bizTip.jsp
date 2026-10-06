<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장사 TIP</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="../style/common.css">
	<link rel="stylesheet" href="../style/bizTip.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
		
		<div class="bodyWrap">
          <div>
            <div class="bodyWrapHader">
              <h2 class="tilte">장사 TIP</h2>
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
              <td>
                <span>오픈초기 마케팅 비용 아끼지마세요</span>
                <span class="commentCount">[212]</span>
              </td>
              <td>신중동 불주먹</td>
              <td>2026.09.23</td>
              <td>1615</td>
              <td>111</td>
            </table>
          </div>
          
          <%@ include file="../common/pagination.jsp" %>
        </div>
	</div>
	
</div>

</body>
</html>