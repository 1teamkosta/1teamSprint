<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css">
    

</head>

<body>

    <form class="login-page" action="${pageContext.request.contextPath}/Controller?cmd=loginAction" method="post">
        <div class="login-box">
            <h1 class="login-title">로그인</h1>

            <!-- ID -->
            <span id="idResult" style="display:none;">  ${loginError}</span>
            <div class="login-row">
                <label for="userId" class="login-label">ID</label>
                <input name="userId"type="text" id="userId" class="login-input">
            </div>

            <!-- 비밀번호 -->
            <div class="login-row">
                <label for="password" class="login-label">비밀번호</label>
                <input name="password" type="password" id="password" class="login-input">
            </div>

            <!-- 버튼 -->
            <div class="login-buttons">
                <button type="submit" class="login-btn">로그인</button>
                <button type="button" class="signup-btn" onclick="location.href='${pageContext.request.contextPath}/Controller?cmd=signUpAction'">회원가입</button>
            </div>
        </div>
    </form>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>