<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="../style/signUp.css">
</head>
<body>
	<form class="signup-page" action="${pageContext.request.contextPath}/Controller?cmd=signUpAction">
		<div class="signup-box">
			<h1 class="signup-title">회원가입</h1>

			<!-- ID -->
			<div class="signup-row">
				<label for="userId" class="signup-label">ID</label>
				<div class="signup-input-area">
					<input name="userId" type="text" id="userId" class="signup-input">
				</div>
				<button type="button" class="signup-check-btn">중복확인</button>
			</div>

			<!-- 비밀번호 -->
			<div class="signup-row">
				<label for="password" class="signup-label">비밀번호</label>
				<div class="signup-input-area signup-full">
					<input name="password" type="password" id="password"
						class="signup-input">
				</div>
			</div>

			<!-- 비밀번호 확인 -->
			<div class="signup-row">
				<label for="passwordCheck" class="signup-label">비밀번호 확인</label>
				<div class="signup-input-area signup-full">
					<input name="passwordCheck" type="password" id="passwordCheck"
						class="signup-input">
				</div>
			</div>

			<!-- 닉네임 -->
			<div class="signup-row">
				<label for="nickname" class="signup-label">닉네임</label>
				<div class="signup-input-area">
					<input name="nickName" type="text" id="nickname"
						class="signup-input">
				</div>
				<button type="button" class="signup-check-btn">중복확인</button>
			</div>

			<!-- 휴대폰번호 -->
			<div class="signup-row">
				<label class="signup-label">휴대폰번호</label>

				<div class="phone-area">
					<input name="phone1" class="signup-input phone-input" maxlength="3">
					<span>-</span> <input name="phone2"
						class="signup-input phone-input" maxlength="4"> <span>-</span>
					<input name="phone3" class="signup-input phone-input" maxlength="4">
				</div>
			</div>

			<!-- 이메일 -->
			<div class="signup-row">
				<label class="signup-label">이메일</label>

				<div class="email-area">
					<input name="emailIid" type="text" class="signup-input"> <span>@</span>
					<input name="emailDomain" type="text" class="signup-input">
				</div>
			</div>

			<!-- 소상공인 인증 -->
			<div class="signup-row signup-file-row">
				<label for="certificate" class="signup-label">소상공인인증</label>

				<div class="signup-input-area signup-full">
					<input name="signupFile" type="file" id="certificate"
						class="signup-file" accept=".png">
				</div>
			</div>

			<!-- 버튼 -->
			<div class="signup-buttons">
				<button type="submit" class="signup-submit-btn">회원가입</button>
				<button type="button" class="signup-cancel-btn"
					onclick="location.href='login.jsp'">취소</button>
			</div>
		</div>
	</form>
</body>
</html>