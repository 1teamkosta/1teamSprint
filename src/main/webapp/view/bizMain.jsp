<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/common.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/bizMain.css">
</head>
<body>
<div class="wrap">
	<%@ include file="../common/header.jsp" %>
	
	<div class="content">
		<%@ include file="../common/sideNav.jsp" %>
		
        <div class="product-gridmain">

            <table class="boardListmain">
              <tr class="tableTr">
                <th><a href="#">공지사항</a></th>
              </tr>
              <td>
                <span class="boardTitle-textlimit">아프리카 사장이다 이용수칙</span>
              </td>
              <td>3094</td>
            </table>

            <table class="boardListmain">
              <tr class="tableTr">
                <th colspan="2"><a href="#">장사Tip</a></th>
              </tr>
              <tr>
              <td class="titleBox">
                <span class="boardTitle-textlimit">오픈 초기 마케팅 비용아끼지 마세요</span>
                <span class="commentCount">[21]</span>
              </td>
              <td class="viewsBox">1615</td>
              </tr>
              <tr>
              <td class="titleBox">
                <span class="boardTitle-textlimit">메뉴를 줄이고나서 오히려 매출이 올랐어요</span>
                <span class="commentCount">[13]</span>
              </td>
              <td class="viewsBox">867</td>
              </tr>
            </table>

            <table class="boardListmain">
              <tr class="tableTr">
                <th><a href="#">Q&A</a></th>
              </tr>
              <td>
                <span class="boardTitle-textlimit">소상공인 대출 질문있습니다</span>
              </td>
              <td class="viewBox">123</td>
            </table>

            <table class="boardListmain">
              <tr class="tableTr">
                <th><a href="#">동네소식</a></th>
              </tr>
              <td class="titleBox">
                <span class="boardTitle-textlimit">금천구 소상고인 경영안전 지원 사업 정보</span>
                <span class="commentCount">[7]</span>
              </td>
              <td class="viewBox">452</td>
            </table>

        </div>
          
        </div>
	</div>
	
</div>

</body>
</html>