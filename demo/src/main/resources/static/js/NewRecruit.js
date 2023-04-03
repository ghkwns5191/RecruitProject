/**
 * 
 */

// 사용할 데이터 정의
var select = document.getElementById("workingdays");
var input_css = document.getElementById("workingdays_input");

input_css.style.display = "none";

select.addEventListener("change", function(e) {
	console.log(e);
	console.log(select.value);
	var str = "input manually";
	console.log(select.value === str);

	if (select.value === str) {
		input_css.style.display = "inline-block";
	} else {
		input_css.style.display = "none";
	}

});






// 등록하기 버튼 누르면 동작
function register() {
	
	var recruit_title = document.getElementById('title').value;
var recruit_career = document.getElementById('career').value;

var recruit_period = document.getElementById('period_salary').value;
var recruit_salary = document.getElementById('salary').value;
var recruit_currency = document.getElementById('salary_currency').value;


var workingdays_value = document.getElementById('workingdays').value;
if (workingdays_value != 'input manually') {
	recruit_workingdays = document.getElementById('workingdays').value;
} else {
	recruit_workingdays = document.getElementById('workingdays_input').value;
}
var recruit_detail = document.getElementById('detail').value;
var recruit_phonenumber = document.getElementById('phonenumber').value;
var recruit_attn = document.getElementById('attn').value;
var recruit_deadline = document.getElementById('deadline').value;

var recruitDto = {
	title: recruit_title,
	career: recruit_career,
	salary: recruit_period + " " + recruit_salary + " " + recruit_currency,
	workingdays: recruit_workingdays,
	detail: recruit_detail,
	phonenumber: recruit_phonenumber,
	attn: recruit_attn,
	deadline: recruit_deadline
};

	console.log(recruitDto);
	$.ajax({
		type: 'post',
		async: false,
		url: '/recruit/input',
		contentType: "application/json",
		data: JSON.stringify(recruitDto),
		success: function(data) {
			console.log(data);
			console.log("채용공고 등록정보 전송");
			// 채용공고 리스트 페이지로 이동
			location.href = "/recruitpage/list";
		},
		error: function(error) {
			console.log(error);
		}
	});
}

// 취소하기 버튼 누르면 동작 (채용공고 리스트 페이지로 이동)
function backtoList() {
	location.href = "/recruitpage/list";
}