let onClickPage = function(page) {
	const urlParams = new URLSearchParams(window.location.search);
	const searchSelect = urlParams.get("searchSelect") ?? "";
	const keyword = urlParams.get("keyword") ?? "";
	let url = "controller?cmd=qnaListSelectPageAction&page=" + page;
	
	if(keyword.trim() !== "") {
		url += "&searchSelect=" + searchSelect + "&keyword=" + keyword;
	}
	
	location.href = url;
}

let onClickSearchBtn = function() {
	const searchSelect = document.querySelector("#searchSelect").value;
	const keyword = document.querySelector("#searchInput").value;
	
	location.href="controller?cmd=qnaListSelectPageAction&page=1&searchSelect=" + searchSelect + "&keyword=" + keyword;
}

document.querySelector("#searchBtn").addEventListener("click", onClickSearchBtn);