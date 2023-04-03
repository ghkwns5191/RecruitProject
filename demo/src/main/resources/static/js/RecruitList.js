/**
 * 
 */

// 요청받은 id 의 recruit 가 없을 경우 호출되는 함수
if (check == "true") {
	console.log("작동확인");
	$.ajax({
		type: "get",
		url: "/mypage/error",
		success: function(data) {
			console.log("status:" + data);
			window.alert("해당 url 은 유효하지 않습니다.");
		},
		error: function() {
			console.log("ajax failure")
		}
	});
} else {

}

//공고 작성하기 클릭 시 작동하는 함수
function newRecruit() {
	location.href = "/recruitpage/new";
}