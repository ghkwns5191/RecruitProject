/**
 * 
 */

function openPop() {
	window.open("/member/usernamecheck", "usernameVal",
		"width=350px, height=30px");
};

window.onload = function() {

	document.getElementById("username").value = localStorage.getItem('username');
	console.log(localStorage.getItem('username'));
	console.log(document.getElementById("username").value);
	window.localStorage.removeItem('username');
E

}

function validateAndSubmit(event) {

	event.preventDefault();

	var regEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	// 이메일 입력 정규식
	var regPw = /^(?=.*[a-zA-Z0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;
	// 비밀번호 입력 정규식 (영문, 숫자, 특수문자(!@#$%^&*)를 포함하는 8자리 이상의 비밀번호 입력)
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;

	if(regEmail.test(email) && regPw.test(password)) {
		var memberDto = {
			username : document.getElementById("username").value,
			password : password,
			sort : document.querySelector("[name='sort']:checked").value,
			name : document.getElementById("name").value,
			phone : document.getElementById("phone").value,
			email : email,
			birthday : document.getElementById("birthday").value,
			address : document.getElementById("address").value


		}
		// ajax 회원가입
		$.ajax({
			type: 'post',
			url : '/join',
			data: JSON.stringify(memberDto),
			dataType: 'json/application',
			success: function(data) {
				// 확인 및 취소 입력에 따라 페이지 다르게 이동
				var joinSuccess = window.confirm("회원가입이 완료되었습니다. 로그인 페이지로 이동하시겠습니까?");
				if(joinSuccess) {
					location.href="/login";
				} else {
					location.href="/";
				}
				
			},
			error: function(e) {
				console.log("회원가입 실패 ㅠ");
				console.log(e);
			}

		});
	} else if (!regEmail.test(email) && regPw.test(password)) {
		window.alert("이메일을 형식에 맞게 다시 입력하세요.");
	} else if (regEmail.test(email) && !regPw.test(password)) {
		window.alert("비밀번호는 영문,숫자,특수문자(!@#$%^&*)를 포함하여 8자리 이상으로 입력해주세요");
	} else if (!regEmail.test(email) && !regPw.test(password)) {
		window.alert("이메일과 비밀번호를 형식에 맞게 다시 입력하세요");
	}

}