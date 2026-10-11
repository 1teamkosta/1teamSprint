// 수정 모드로 전환
function toggleEdit(replyNumber) {
    document.getElementById('commentbox' + replyNumber).style.display = 'none';
    document.getElementById('edit' + replyNumber).style.display = 'block';
}

// 수정 취소 (기존 내용으로 복구)
function cancelEdit(replyNumber) {
    document.getElementById('commentbox' + replyNumber).style.display = 'block';
    document.getElementById('edit' + replyNumber).style.display = 'none';
}

// 클릭 이벤트 한 곳에서 처리 (이벤트 위임)
document.addEventListener('click', function (e) {

    // 1) 삭제 확인
    const confirmEl = e.target.closest('[data-confirm]');
    if (confirmEl && !confirm(confirmEl.dataset.confirm)) {
        e.preventDefault();   // 취소 누르면 링크 이동 막기
        return;
    }

    // 2) 댓글 수정/취소
    const actionEl = e.target.closest('[data-action]');
    if (actionEl) {
        const replyNumber = actionEl.dataset.reply;
        if (actionEl.dataset.action === 'toggleEdit') toggleEdit(replyNumber);
        if (actionEl.dataset.action === 'cancelEdit') cancelEdit(replyNumber);
    }
});