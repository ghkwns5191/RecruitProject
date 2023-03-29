/**
 * 
 */
 
 
// 지원하기 버튼 클릭 시 작동하는 함수
function apply() {
	
	
	$.ajax({
		type: 'post',
		contentType: 'application/json',
		async: false,
		url: '/apply/input',
		data,
		success: function(data) {
			console.log(data);
		},
		error: function(error) {
			console.log(error);
		}
	});
}

// 돌아기기 버튼 클릭 시 작동하는 함수
function bakctoList() {
	
}