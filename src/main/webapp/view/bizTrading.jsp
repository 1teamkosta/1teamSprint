<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=explore_nearby" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/bizTrading.css">
</head>
<body>
	<div class="wrap">
		<%@ include file="../common/header.jsp"%>

		<div class="content">
			<%@ include file="../common/sideNav.jsp"%>

			<div class="bodyWarp">
				<div>
					<div class="bodyWrapHader">
						<h2 cslass="tilte">중고 거래</h2>
						<a href="Controller?cmd=tradeWriteUIAction" class="writeBtn"><button>작성하기</button></a>
					</div>

					<div class="product-grid">
						<c:forEach items="${tradingList}" var="trade">
							<div class="item-card">
								<div class="image-box">
								<a href="Controller?cmd=viewTrade&tradeNumber=${trade.tradeNumber}">
									<img src="테이블.jpg" alt="테이블">
									<div class="price-box">${trade.price}원</div>
								</div>
								<div class="info-box">
									<div class="item-title">${trade.title}</div>
									</a>
									<div class="item-author">${trade.nickname}</div>
									<div class="item-meta">${trade.writeDate}조회수
										${trade.viewCount}</div>
								</div>
							</div>
						</c:forEach>




					</div>
				</div>

				<%@ include file="../common/pagination.jsp"%>
			</div>
		</div>

	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tradeList.js"></script>
	
</body>
</html>