<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/signUp.css">

</head>
<body>
	<form class="signup-page"
		action="${pageContext.request.contextPath}/Controller?cmd=signUpAction"
		method="post">
		<div class="signup-box">
			<h1 class="signup-title">회원가입</h1>

			<!-- ID -->
			<span id="idResult" style="display: none;"></span>

			<div class="signup-row">
				<label for="userId" class="signup-label">ID</label>
				<div class="signup-input-area">
					<input name="userId" type="text" id="userId" class="signup-input"
						required>
				</div>
				<button type="button" class="signup-check-btn" onclick="checkid()">중복확인</button>
			</div>

			<!-- 비밀번호 -->
			<div class="signup-row">
				<label for="password" class="signup-label">비밀번호</label>
				<div class="signup-input-area signup-full">
					<input name="password" type="password" id="password"
						class="signup-input" required>
				</div>
			</div>

			<!-- 비밀번호 확인 -->
			<p id="passwordResult"></p>
			<div class="signup-row">
				<label for="passwordCheck" class="signup-label">비밀번호 확인</label>
				<div class="signup-input-area signup-full">
					<input name="passwordCheck" type="password" id="passwordCheck"
						class="signup-input" required>
				</div>
			</div>
			

			<!-- 닉네임 -->
			<span id="nicknameResult" style="display: none;"></span>
			<div class="signup-row">

				<label for="nickname" class="signup-label">닉네임</label>
				<div class="signup-input-area">
					<input name="nickname" type="text" id="nickname"
						class="signup-input" required>
				</div>
				<button type="button" class="signup-check-btn"
					onclick="checkNickname()">중복확인</button>
			</div>

			<!-- 휴대폰번호 -->
			<div class="signup-row">
				<label class="signup-label">휴대폰번호</label>

				<div class="phone-area">
					<input name="phone1" class="signup-input phone-input" maxlength="3"
						required> <span>-</span> <input name="phone2"
						class="signup-input phone-input" maxlength="4" required> <span>-</span>
					<input name="phone3" class="signup-input phone-input" maxlength="4"
						required>
				</div>
			</div>

			<!-- 이메일 -->
			<div class="signup-row">
				<label class="signup-label">이메일</label>

				<div class="email-area">
					<input name="emailId" type="text" class="signup-input" required>
					<span>@</span> <input name="emailDomain" type="text"
						class="signup-input" required>
				</div>
			</div>

			<!-- 소상공인 인증 -->
			<div class="signup-row signup-file-row">
				<label for="certificate" class="signup-label">소상공인인증</label>

				<div class="signup-input-area signup-full">
					<input name="signupFile" type="file" id="certificate"
						class="signup-file" accept=".png" required>
				</div>
			</div>

			<!-- 버튼 -->
			<div class="signup-buttons">
				<button type="submit" class="signup-submit-btn">회원가입</button>
				<button type="button" class="signup-cancel-btn"
					onclick="location.href='${pageContext.request.contextPath}/Controller?cmd=loginUiAction'">취소</button>
			</div>
		</div>
	</form>
	<script src="${pageContext.request.contextPath}/js/signup.js"></script>
	<script>
		const contextPath = "${pageContext.request.contextPath}";
	</script>
</body>
</html>