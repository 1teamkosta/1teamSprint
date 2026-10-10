function getTitleContentData() {

    const title = document.querySelector('[name="title"]').value;
    const content = quill.root.innerHTML;

    return {
        title: title,	
        content: content
    };
}

const questionNumber = document.querySelector("#qnaForm").dataset.questionNumber;

function addQna() {
	const data = getTitleContentData();
    location.href = "Controller?cmd=addQnaAction&title=" + encodeURIComponent(data.title) + "&content=" + encodeURIComponent(data.content);
}
function setQna() {
	const data = getTitleContentData();
	location.href = "Controller?cmd=setQnaAction&questionNumber="+encodeURIComponent(questionNumber)+ "&title=" + encodeURIComponent(data.title) + "&content=" + encodeURIComponent(data.content);
}

// 등록 버튼 이벤트

document.addEventListener("DOMContentLoaded", function() {
	
	const addQnaBtn = document.querySelector("#addQnaBtn");
    if (addQnaBtn) {
        addQnaBtn.addEventListener("click", function(event) {
            event.preventDefault(); // a 태그의 기본 이동(#) 방지
            addQna();
        });
    }

    const setQnaBtn = document.querySelector("#setQnaBtn");
    if (setQnaBtn) {
        setQnaBtn.addEventListener("click", function(event) {
            event.preventDefault(); // a 태그의 기본 이동(#) 방지
            setQna();
        });
    }
});