
let idChecked = false;
let nicknameChecked = false;

document.querySelector(".signup-page")
    .addEventListener("submit", function(e) {

        console.log("submit 실행됨");
        console.log("아이디 검사:", idChecked);
        console.log("닉네임 검사:", nicknameChecked);

        if (!idChecked || !nicknameChecked) {
            e.preventDefault();
            alert("아이디와 닉네임 중복확인을 완료해주세요.");
        }
        
           if (!checkPassword()) {
            e.preventDefault();
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

    });

function checkNickname() {
    const nickname = document.querySelector("#nickname").value;
    const xhr = new XMLHttpRequest();
    const result = document.querySelector("#nicknameResult");
    

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const nicknameCheck = xhr.responseText.trim();

            if (nicknameCheck === "true") {
				 nicknameChecked = false;
				result.style.display = "inline";
                result.innerHTML =
                    "<span style='color:red'>중복된 닉네임입니다.</span>";
                    
            } else if (nicknameCheck === "false") {
				 nicknameChecked = true;
				result.style.display = "inline";
                result.innerHTML =
                    "<span style='color:green'>사용 가능한 닉네임입니다.</span>";
            }
        }
    };

    xhr.open(
        "GET",
        contextPath+"/Controller?cmd=nicknameCheck&nickname="
        + encodeURIComponent(nickname),
        true
    );

    xhr.send();
}

 function checkid() {
    const userid = document.querySelector("#userId").value;
    const xhr = new XMLHttpRequest();
    const result = document.querySelector("#idResult");
    

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
			
        if (document.querySelector("#userId").value !== userid) {
            return;
        }
            const idCheck = xhr.responseText.trim();
            console.log("XHR 응답:", JSON.stringify(idCheck));
			console.log("result 요소:", result);
            

            if (idCheck === "true") {
				idChecked = false;
				result.style.display = "inline";
                result.innerHTML =
                    "<span style='color:red'>중복된 아이디입니다.</span>";
                    
            } else if (idCheck === "false") {
				idChecked = true;
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
}

document.querySelector("#userId")
    .addEventListener("input", function() {
        idChecked = false;
        document.querySelector("#idResult").style.display = "none";
    });

document.querySelector("#nickname")
    .addEventListener("input", function() {
        nicknameChecked = false;
        document.querySelector("#nicknameResult").style.display = "none";
    });
    
    function checkPassword() {
    const password = document.querySelector("#password").value;
    const passwordCheck = document.querySelector("#passwordCheck").value;
    const result = document.querySelector("#passwordResult");

    if (passwordCheck === "") {
        result.textContent = "";
        return false;
    }

    if (password === passwordCheck) {
        result.textContent = "비밀번호가 일치합니다.";
        result.style.color = "green";
        return true;
    } else {
        result.textContent = "비밀번호가 일치하지 않습니다.";
        result.style.color = "red";
        return false;
    }
}

document.querySelector("#password")
    .addEventListener("input", checkPassword);

document.querySelector("#passwordCheck")
    .addEventListener("input", checkPassword);

