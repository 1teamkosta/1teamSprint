let onClickPage = function(page) {
	const urlParams = new URLSearchParams(window.location.search);
	const searchSelect = urlParams.get("searchSelect") || "";
	const keyword = urlParams.get("keyword") || "";
	let url = "Controller?cmd=qnaListAction&page=" + page;
	
	if(keyword.trim() !== "") {
		url += "&searchSelect=" + searchSelect + "&keyword=" + keyword;
	}
	
	location.href = url;
}

let onClickSearchBtn = function() {
	const searchSelect = document.querySelector("#searchSelect").value;
	const keyword = document.querySelector("#searchInput").value;
	
	if(keyword.trim() === "") return;
	
	location.href="Controller?cmd=qnaListAction&page=1&searchSelect=" + searchSelect + "&keyword=" + keyword;
}

document.addEventListener("DOMContentLoaded", function() {
	document.querySelector("#searchBtn").addEventListener("click", onClickSearchBtn);
})