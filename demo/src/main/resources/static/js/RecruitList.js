/**
 * 
 */

// 요청받은 id 의 recruit 가 없을 경우 호출되는 함수
if (check == "true") {
	console.log("작동확인");
	$.ajax({
		type: "get",
		url: "/mypage/error",
		success: function(done) {
			console.log("status:" + status);
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
	location.href('/recruitpage/new');
}

// 검색버튼 클릭 시 작동하는 함수
function search() {
	var searchKeyword = document.getElementById('searchKeyword').value;

	// 검색란에 값이 입력된 채로 검색버튼을 누르면 ajax 로 controller에 데이터 전송
	if (searchKeyword != null && searchKeyword != "") {
		$.ajax({
			type: 'get',
			url: '/recruitpage/list',
			data: searchKeyword.stringify(),
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				document.getElementById('recruitList').replaceWith(data);
			},
			error: function(error) {
				console.log(error);
			}

		});
	} if (searchKeyword == null || searchKeyword == "") {
		searchKeyword = null;
		$.ajax({
			type: 'get',
			url: '/recruitpage/list',
			data: searchKeyword,
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				document.getElementById('recruitList').replaceWith(data);
			},
			error: function(error) {
				console.log(error);
			}

		});
	}

}