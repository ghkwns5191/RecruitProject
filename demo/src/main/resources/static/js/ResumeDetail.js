/**
 * 
 */
 
 function back() {
	history.go(-1);
}

function toRevise(resumeid) {
	location.href="/mypage/user/resume/revise/" + resumeid;
}