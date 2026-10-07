document.addEventListener("DOMContentLoaded", function(){
	const pageLink = document.querySelectorAll(".pagination .page-link")
	pageLink.forEach(link => {
		link.addEventListener("click", function() {
			if(typeof onClickPage === "function")
				onClickPage(this.getAttribute("data-page"));
		});
	});
});