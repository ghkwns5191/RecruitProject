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
			window.alert("로그인이 필요합니다.");
		},
		error: function() {
			console.log("ajax failure")
		}
	});
} else {

}