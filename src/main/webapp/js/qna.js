// 수정 모드로 전환
function toggleEdit(answerNumber) {
    document.getElementById('answer-content-' + answerNumber).style.display = 'none'; //기존 답변 읽기 전용으로 숨기기
    document.getElementById('edit-form-' + answerNumber).style.display = 'block'; //수정 폼 화면 표시
    document.getElementById('owner-btns-' + answerNumber).style.display = 'none'; //수정 삭제 버튼 숨기기
}

// 수정 취소 (기존 내용으로 복구)
function cancelEdit(answerNumber) {
    document.getElementById('answer-content-' + answerNumber).style.display = 'block'; //답변 읽기 전용 표시
    document.getElementById('edit-form-' + answerNumber).style.display = 'none'; //수정 폼 화면 숨기기
    document.getElementById('owner-btns-' + answerNumber).style.display = 'block'; //수정 삭제 버튼 표시
}



// [질문 수정/삭제 관련 기능]
const setBtn = document.getElementById('set-qna-btn');
const questionNumber = setBtn.dataset.questionNumber; // JSP의 값을 읽어옴

// 1. 질문 수정 버튼 이벤트
setBtn.addEventListener("click", function(e) {
    e.preventDefault(); // # 링크 기본 동작 막기
    location.href = "Controller?cmd=setQnaUI&questionNumber=" + questionNumber;
});

// 2. 질문 삭제 버튼 이벤트
document.getElementById('del-qna-btn').addEventListener("click", function(e) {
    e.preventDefault(); // # 링크 기본 동작 막기
    if (confirm("정말 이 질문을 삭제하시겠습니까?")) {
        location.href = "Controller?cmd=deleteQnaAction&questionNumber=" + questionNumber;
    }
});

//답글 수정 취소
const cencelBtn = document.getElementById('cencel-btn')
const answerNumber = cencelBtn.dataset.answerNumber;

cencelBtn.addEventListener("click", function() {
	cancelEdit(answerNumber)
});

document.querySelectorAll(".edit-btn").forEach(function(button) {
    button.addEventListener("click", function() {
        toggleEdit(answerNumber);
    });
});


document.querySelectorAll(".delete-btn").forEach(function(button) {
    button.addEventListener("click", function(e) {
        e.preventDefault();

        if (confirm("답변을 삭제하시겠습니까?")) {

            location.href ="Controller?cmd=deleteAnswerAction&questionNumber=" + questionNumber + "&answerNumber=" + answerNumber;
        }
    });
});
