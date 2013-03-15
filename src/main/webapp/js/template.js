
$(document).ready(function(){
	$(".breadcrumbLink").click(function(){
		var href = "/struts/"+$(".breadcrumbLink").text().toLowerCase()+".action";
		document.redirect(href);
	})
});