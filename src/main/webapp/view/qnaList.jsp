<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Q&A</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/common.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/qnaList.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/freeBoard.css">
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
              	<th class="stateTh">답변</th>
                <th class="titleTh">제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>답변수</th>
              </tr>
             
			<c:forEach items="${listQnA}" var="qna">
				<tr>
					<td>${qna.statement}</td>
					<td><a href="controller?cmd=qnaUIAction&questionNum=${qna.questionNumber}">${qna.title}</a></td>
					<td>${qna.nickname}</td>
					<td>${qna.writeDate.substring(0, 10)}</td>
					<td>${qna.viewCount}</td>
					<td>${qna.answerCount}</td>
				</tr>
			</c:forEach>
             
            </table>
          </div>
          <%@ include file="../common/pagination.jsp" %>
		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/qnaList.js"></script>

</body>