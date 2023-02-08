/**
 * 
 */

function addportfolio() {
	console.log("함수작동");
	var div = document.getElementById("portfolio");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>제목</label><input type='text' name='title' placeholder='제목을 입력하세요'><br>"
		+ "<label>제목</label><input type='text' name='file1' placeholder='제목을 입력하세요'><br>"
		+ "<label>제목</label><input type='text' name='file2' placeholder='제목을 입력하세요'><br>"
		+ "<label>제목</label><input type='text' name='url1' placeholder='url 을 입력하세요'><br>"
		+ "<label>제목</label><input type='text' name='url2' placeholder='url 을 입력하세요'><br>"
		+ "<input type='button' value='삭제' onClick='deleteportfolio(this)'>";
	div.appendChild(newarea);
}

function deleteportfolio(data) {
	document.getElementById("portfolio").removeChild(data.parentNode);
}

function addoe() {
	console.log("함수작동");
	var div = document.getElementById("oe");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>체류 국가명</label><input type='text' name='country' placeholder='체류 국가명을 입력하세요'><br>"
		+ "<label>시작일</label><input type='date'><br>"
		+ "<label>종료일</label><input type='date'><br>"
		+ "<label>현재 체류 여부</label><br>"
		+ "<label>체류 중</label><input type='radio' name='staying' value='staying'>"
		+ "<label>귀국</label><input type='radio' name='staying' value='back'>"
		+ "<label>상세 내용</label><br><textarea rows='15' cols='60' name='detail' placeholder='상세 근무내용을 입력하세요'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteoe(this)'>";
	div.appendChild(newarea);
}

function deleteoe(data) {
	document.getElementById("oe").removeChild(data.parentNode);
}

function addlanguages() {
	console.log("함수작동");
	var div = document.getElementById("languages");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>언어명</label><input type='text' placeholder='활용 가능한 언어를 입력하세요'><br>"
		+ "<label>회화 능력</label><br>"
		+ "<label>기초 일상 회화</label><input type='radio' name='leveltalking' value='novice'>"
		+ "<label>비즈니스 회화</label><input type='radio' name='leveltalking' value='intermediate'>"
		+ "<label>원어민 수준</label><input type='radio' name='leveltalking' value='native'>"
		+ "<br><label>작문/독해 능력</label><br>"
		+ "<label>기초 작문/독해</label><input type='radio' name='levelwriting' value='novice'>"
		+ "<label>비즈니스 작문/독해</label><input type='radio' name='levelwriting' value='intermediate'>"
		+ "<label>원어민 수준</label><input type='radio' name='levelwriting' value='native'>"
		+ "<br><label>어학시험명</label><input type='text' placeholder='응시했던 어학시험 이름을 입력하세요'><br>"
		+ "<label>점수 및 등급</label><input type='text' placeholder='취득한 점수 혹은 등급을 입력하세요'><br>"
		+ "<label>취득일</label><input type='date'><br>"
		+ "<label>성적표 번호</label><input type='text' placeholder='취득한 성적표 번호를 입력하세요'><br>"
		+ "<input type='button' value='삭제' onClick='deletelanguages(this)'>";
	div.appendChild(newarea);
}

function deletelanguages(data) {
	document.getElementById("languages").removeChild(data.parentNode);
}

function addeducation() {
	console.log("함수작동");
	var div = document.getElementById("education");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>교육명</label><input type='text' placeholder='교육명을 입력하세요'><br>"
		+ "<label>교육 시작일</label><input type='date'><br>"
		+ "<label>교육 종료일</label><input type='date'><br>"
		+ "<label>교육기관</label><input type='text' placeholder='교육기관명을 입력하세요'><br>"
		+ "<label>교육 상세내용</label><br><textarea rows='15' cols='60' placeholder='교육 상세내용을 입력하세요'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteeducation(this)'>";
	div.appendChild(newarea);
}

function deleteeducation(data) {
	document.getElementById("education").removeChild(data.parentNode);
}

function addcertificate() {
	console.log("함수작동");
	var div = document.getElementById("certificate");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>자격증명</label><input type='text' placeholder='자격증 이름을 입력하세요'><br>"
		+ "<label>자격증 취득일</label><input type='date'><br>"
		+ "<label>등급 / 점수</label><input type='text' placeholder='등급 / 점수를 입력하세요'><br>"
		+ "<label>자격증 발급기관</label><input type='text' placeholder='자격증 발급기관을 입려하세요'>만원<br>"
		+ "<label>자격증 번호</label><input type='text' placeholder='자격증 번호를 입력하세요'><br>"
		+ "<input type='button' value='삭제' onClick='deletecertificate(this)'>";
	div.appendChild(newarea);
}

function deletecertificate(data) {
	document.getElementById("certificate").removeChild(data.parentNode);
}

function addcareer() {
	console.log("함수작동");
	var div = document.getElementById("career");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>회사명</label><input type='text' placeholder='회사명을 입력하세요'><br>"
		+ "<label>구분</label><select>"
		+ "<option value='working' selected>재직중</option>"
		+ "<option value='quit'>퇴사</option> "
		+ "</select><br>"
		+ "<label>시작일</label><input type='date'><br>"
		+ "<label>종료일</label><input type='date'><br>"
		+ "<label>직급</label><input type='text' placeholder='직급을 입력하세요'><br>"
		+ "<label>연봉</label><input type='text' placeholder='직급을 입력하세요'>만원<br>"
		+ "<label>부서</label><input type='text' placeholder='근무 부서를 입력하세요'>만원<br>"
		+ "<label>상세 근무내용</label><br><textarea rows='15' cols='60' placeholder='상세 근무내용을 입력하세요'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deletecareer(this)'>";
	div.appendChild(newarea);
}

function deletecareer(data) {
	document.getElementById("career").removeChild(data.parentNode);
}

function addactivity() {
	console.log("함수작동");
	var div = document.getElementById("activity");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>활동명</label><input type='text' placeholder='활동명을 입력하세요'><br>"
		+ "<label>시작일</label><input type='date'><br>"
		+ "<label>종료일</label><input type='date'><br>"
		+ "<label>주최</label><input type='text' placeholder='주최단체명 등을 입력하세요'><br>"
		+ "<label>활동 상세내용</label><br><textarea rows='15' cols='60' placeholder='활동 상세내용을 입력하세요'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteactivity(this)'>";
	div.appendChild(newarea);
}

function deleteactivity(data) {
	document.getElementById("activity").removeChild(data.parentNode);
}

function addacademic() {
	console.log("함수작동");
	var div = document.getElementById("academic");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>학교명</label><input type='text' placeholder='학교명을 입력하세요'><br>"
		+ "<label>구분</label><select>"
		+ "<option value='unselected' selected disabled>구분</option>"
		+ "<option value='highschool' >고등학교</option> "
		+ "<option value='university' >대학교</option>"
		+ "<option value='graduateSchool' >대학원</option>"
		+ "</select><br>"
		+ "<label>시작일</label><input type='date'><br>"
		+ "<label>종료일</label><input type='date'><br>"
		+ "<label>졸업여부</label><select>"
		+ "<option value='unselected' selected disabled>선택</option>"
		+ "<option value='attending'>재학중</option>"
		+ "<option value='off'>휴학중</option>"
		+ "<option value='graduated'>졸업</option>"
		+ "</select><br>"
		+ "<label>전공</label><input type='text' placeholder='전공명을 입력하세요'><br>"
		+ "<label>학점</label><input type='text' placeholder='학점'> / <select>"
		+ "<option value='4.0'>4.0</option>"
		+ "<option value='4.3' selected>4.3</option>"
		+ "<option value='4.5'>4.5</option>"
		+ "</select><br>"
		+ "<label>학력 상세내용</label><br><textarea rows='15' cols='60' placeholder='상세 학습 내용을 입력하세요'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteacademic(this)'>";
	div.appendChild(newarea);
}

function deleteacademic(data) {
	document.getElementById("academic").removeChild(data.parentNode);
}

window.onload = function() {
	$.ajax({
		type: "get",
		url: "/member/sendMemberData",
		success: function(member) {

			document.getElementById("name").value = member.name;
			document.getElementById("phone").value = member.phone;
			document.getElementById("email").value = member.email;
		},
		error: function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
		}
	})
}



function submit() {
	console.log("동작");
	var resume_title = document.getElementById("title").value;
	var resume_cv = document.getElementById("cv").value;
	var resume_openforheadhunter = document.querySelector('input[name="openforheadhunter"]:checked').value;
	console.log(resume_title);
	console.log(resume_cv);
	console.log(resume_openforheadhunter);
	$.ajax({
		type: "post",
		url: "/resume/input",
		data: {
			title: resume_title,
			cv: resume_cv,
			openforheadhunter: resume_openforheadhunter
		},
		success: function(data) {
			console.log(data);
			console.log("ajax 동작");
			location.href("/mypage/resume");

		},
		error: function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
			console.log("ajax 동작")
		}
	})
}


