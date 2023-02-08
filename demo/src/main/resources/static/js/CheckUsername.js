/**
 * 
 */

function checkUsername() {
	var username = document.getElementById("username").value;
	console.log(username);
	$.ajax({
		type: "post", // 타입
		url: "/member/usernamecheck",
		async: true, // 비동기 여부 (비동기 = true)

		dataType: "text",
		data: {
			"username": username
		},
		success: function(result) {
			console.log(result);

			$("#checkresult").replaceWith(result);
		},
		error: function(request, status, error) {
			console.log(request, status, error);
		}
	})

}

function insertUsername() {
	var username = document.getElementById("username").value;
	console.log(username);
	localStorage.setItem("username", username);
	opener.location.reload();
	window.close();
}