/**
 * 
 */
 
 function back() {
	history.go(-1);
}

function toRevise(resumeid) {
	location.href="/mypage/resume/revise/" + resumeid;
}