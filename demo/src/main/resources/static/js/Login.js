/**
 * 
 */


if (check == "true") {
	console.log("작동확인");
	$.ajax({
		type: "get",
		url: "/mypage/error",
		success: function(done) {
			console.log("status:" + status);
			window.alert(done);
		},
		error: function() {
			console.log("ajax failure")
		}
	});
} else {

}