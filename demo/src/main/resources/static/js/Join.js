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
		// ajax 회원가입
	} else if (!regEmail.test(email) && regPw.test(password)) {
		window.alert("이메일을 형식에 맞게 다시 입력하세요.");
	} else if (regEmail.test(email) && !regPw.test(password)) {
		window.alert("비밀번호는 영문,숫자,특수문자(!@#$%^&*)를 포함하여 8자리 이상으로 입력해주세요");
	} else if (!regEmail.test(email) && !regPw.test(password)) {
		window.alert("이메일과 비밀번호를 형식에 맞게 다시 입력하세요");
	}

}