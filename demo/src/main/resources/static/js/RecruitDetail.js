/**
 * 
 */
 
 
// 지원하기 버튼 클릭 시 작동하는 함수
function applyto(recruitid) {
	var id = recruitid;
	console.log(id);
	$.ajax({
		type: 'post',
		async: false,
		url: '/apply/input/' + id,
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log(error);
			location.reload();
		}
	});
}

// 돌아기기 버튼 클릭 시 작동하는 함수
function bakctoList() {
	// 바로 이전 url 로 이동
	history.go(-1);
}            