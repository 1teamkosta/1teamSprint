document.addEventListener("DOMContentLoaded", function(){
	const pageLink = document.querySelectorAll(".pagination .page-link")
	pageLink.forEach(link => {
		link.addEventListener("click", function() {
			
			if(typeof goPage === "function")
				goPage(this.getAttribute("data-page"));
		});
	});
});