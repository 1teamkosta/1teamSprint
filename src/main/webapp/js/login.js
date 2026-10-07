/**
 * 
 */

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