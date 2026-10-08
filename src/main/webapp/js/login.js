/**
 * 
 */
/*
document.querySelector("#loginForm")
    .addEventListener("submit", login);

function login(e) {
    e.preventDefault(); // 기본 form 제출 막기

    const form = document.querySelector("#loginForm");
    const userId = document.querySelector("#userId").value;
    const password = document.querySelector("#password").value;
    const result = document.querySelector("#loginResult");

    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            const loginSuccess = xhr.responseText.trim();
            
             console.log("로그인 결과:", loginSuccess);

            if (loginSuccess === "true") {
                // 로그인 성공 시에만 페이지 이동
                location.href = contextPath + "/Controller?cmd=bizMainUIAction";

            } else if (loginSuccess === "false") {
				 alert("아이디 또는 비밀번호가 일치하지 않습니다.");
                // 로그인 실패 시 현재 페이지 유지
                result.style.display = "inline";
                result.textContent =
                    "아이디 또는 비밀번호가 일치하지 않습니다.";
                result.style.color = "red";
            }
        }
    };

    // form의 action과 method 사용
    xhr.open(form.method, form.action, true);

    xhr.setRequestHeader(
        "Content-Type",
        "application/x-www-form-urlencoded; charset=UTF-8"
    );

    xhr.send(
        "userId=" + encodeURIComponent(userId)
        + "&password=" + encodeURIComponent(password)
    );
}*/


 document.querySelector(".login-btn").addEventListener("click", login);
function login() {
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;

    const xhr = new XMLHttpRequest();
    
    console.log(userId,password);

    xhr.open("POST", "${pageContext.request.contextPath}/loginAction", true);

    xhr.setRequestHeader(
        "Content-Type",
        "application/x-www-form-urlencoded"
    );

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
            }else {
                console.log("오류:", xhr.status);
            }
        }
    };

    xhr.send(
        "userId=" + encodeURIComponent(userId)
        + "&password=" + encodeURIComponent(password)
    );
}



/*
function checkid() {
    const userid = document.querySelector("#userId").value;
    const xhr = new XMLHttpRequest();
    const result = document.querySelector("#idResult");
    

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const idCheck = xhr.responseText.trim();
            console.log("XHR 응답:", JSON.stringify(idCheck));
			console.log("result 요소:", result);
            

            if (idCheck === "true") {
				result.style.display = "inline";
                result.innerHTML =
                    "<span style='color:red'>중복된 아이디입니다.</span>";
                    
            } else if (idCheck === "false") {
				result.style.display = "inline";
                result.innerHTML =
                    "<span style='color:green'>사용 가능한 아이디입니다.</span>";
            }
        }
    };

    xhr.open(
        "GET",
        contextPath+"/Controller?cmd=idCheck&userId="
        + encodeURIComponent(userid),
        true
    );

    xhr.send();
    
document.querySelector(".login-btn")
    .addEventListener("click", function(e) {
        e.preventDefault();
        login();
    });
    
function login() {
    const userId = document.querySelector("#userId").value;
    const password = document.querySelector("#password").value;
    const result = document.querySelector("#idResult");

    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            const loginSuccess  = xhr.responseText.trim();

            if (loginSuccess === "false") {
                result.style.display = "inline";
                result.textContent = "아이디 또는 비밀번호가 일치 하지 않습니다";
                result.style.color = "red";

            } else if (loginSuccess === "true") {
                location.href = contextPath + "/Controller?cmd=bizMain"

                // 아이디가 존재하면 로그인 요청
                loginRequest(userId, password);
            }
        }
    };

    xhr.open(
        "POST",
        contextPath + "/Controller?cmd=login",
        true
    );
    
        xhr.setRequestHeader(
        "Content-Type",
        "application/x-www-form-urlencoded"
    );


        xhr.send(
        "userId=" + encodeURIComponent(userId)
        + "&password=" + encodeURIComponent(password)
    );
}

*/

