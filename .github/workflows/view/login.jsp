<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="../style/login.css">
</head>

<body>

    <div class="login-page">
        <div class="login-box">
            <h1 class="login-title">로그인</h1>

            <!-- ID -->
            <div class="login-row">
                <label for="userId" class="login-label">ID</label>
                <input type="text" id="userId" class="login-input">
            </div>

            <!-- 비밀번호 -->
            <div class="login-row">
                <label for="password" class="login-label">비밀번호</label>
                <input type="password" id="password" class="login-input">
            </div>

            <!-- 버튼 -->
            <div class="login-buttons">
                <button type="button" class="login-btn">로그인</button>
                <button type="button" class="signup-btn" onclick="location.href='signUp.jsp'">회원가입</button>
            </div>
        </div>
    </div>

</body>
</html>