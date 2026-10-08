document.addEventListener("DOMContentLoaded", function(){
	const pageLink = document.querySelectorAll(".pagination .pagelink");
	pageLink.forEach(link => {
		link.addEventListener("click", function() {
			if(typeof onClickPage === "function")
				onClickPage(link.dataset.page);
		});
	});
});