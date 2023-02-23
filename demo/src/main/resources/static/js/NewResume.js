/**
 * 
 */
var academicLength = 0;
var activityLength = 0;
var careerLength = 0;
var certificateLength = 0;
var educationLength = 0;
var langaugesLength = 0;
var oeLength = 0;
var portfolioLength = 0;

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
	portfolioLength++;
}

function deleteportfolio(data) {
	document.getElementById("portfolio").removeChild(data.parentNode);
	portfolioLength--;
}

function addoe() {
	console.log("함수작동");
	var div = document.getElementById("oe");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>체류 국가명</label><input type='text' name='country' placeholder='체류 국가명을 입력하세요' class='oe_country'><br>"
		+ "<label>시작일</label><input type='date' class='oe_start'><br>"
		+ "<label>종료일</label><input type='date' class='oe_end'><br>"
		+ "<label>현재 체류 여부</label><select class='oe_staying'"
		+ "<option value='staying' selected>현재 체류 중</option"
		+ "<option value='back'>현재 체류 중 아님</option>"
		+ "</select><br>"
		+ "<label>상세 내용</label><br><textarea rows='15' cols='60' name='detail' placeholder='상세 근무내용을 입력하세요' class='oe_detail'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteoe(this)'>";
	div.appendChild(newarea);
	oeLength++;
}

function deleteoe(data) {
	document.getElementById("oe").removeChild(data.parentNode);
	oeLength--;
}

function addlanguages() {
	console.log("함수작동");
	var div = document.getElementById("languages");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>언어명</label><input type='text' placeholder='활용 가능한 언어를 입력하세요' class='languages_languages'><br>"
		+ "<label>회화 능력</label><select class='languages_leveltaking'>"
		+ "<option value='novice' selected>기초 일상 회화</option>"
		+ "<option value='intermediate'>비즈니스 회화</option>"
		+ "<option value='native'>원어민 수준</option>"
		+ "</select><br>"
		+ "<label>작문/독해 능력</label><select class='langauges_levelwriting>'"
		+ "<option value='novice' selected>기초 작문/독해</option>"
		+ "<option value='intermediate'>비즈니스 작문/독해</option>"
		+ "<option value='native'>원어민 수준</option>"
		+ "</select><br>"
		+ "<label>어학시험명</label><input type='text' placeholder='응시했던 어학시험 이름을 입력하세요' class='languages_test'><br>"
		+ "<label>점수 및 등급</label><input type='text' placeholder='취득한 점수 혹은 등급을 입력하세요' class='languages_score'><br>"
		+ "<label>취득일</label><input type='date' class='languages_achievedate'><br>"
		+ "<label>성적표 번호</label><input type='text' placeholder='취득한 성적표 번호를 입력하세요' class='languages_certificatenumber'><br>"
		+ "<input type='button' value='삭제' onClick='deletelanguages(this)'>";
	div.appendChild(newarea);
	langaugesLength++;
}

function deletelanguages(data) {
	document.getElementById("languages").removeChild(data.parentNode);
	langaugesLength--;
}

function addeducation() {
	console.log("함수작동");
	var div = document.getElementById("education");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>교육명</label><input type='text' placeholder='교육명을 입력하세요' class='education_title'><br>"
		+ "<label>교육 시작일</label><input type='date' class='education_start'><br>"
		+ "<label>교육 종료일</label><input type='date' class='education_end'><br>"
		+ "<label>교육기관</label><input type='text' placeholder='교육기관명을 입력하세요' class='education_holdby'><br>"
		+ "<label>교육 상세내용</label><br><textarea rows='15' cols='60' placeholder='교육 상세내용을 입력하세요' class='education_detail'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteeducation(this)'>";
	div.appendChild(newarea);
	educationLength++;
}

function deleteeducation(data) {
	document.getElementById("education").removeChild(data.parentNode);
	educationLength--;
}

function addcertificate() {
	console.log("함수작동");
	var div = document.getElementById("certificate");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>자격증명</label><input type='text' placeholder='자격증 이름을 입력하세요' class='certificate_name'><br>"
		+ "<label>자격증 취득일</label><input type='date' class='certificate_achievedate'><br>"
		+ "<label>등급 / 점수</label><input type='text' placeholder='등급 / 점수를 입력하세요' class='certificate_grade'><br>"
		+ "<label>자격증 발급기관</label><input type='text' placeholder='자격증 발급기관을 입려하세요' class='certificate_achievefrom'>만원<br>"
		+ "<label>자격증 번호</label><input type='text' placeholder='자격증 번호를 입력하세요' class='certificate_certificatenumber'><br>"
		+ "<input type='button' value='삭제' onClick='deletecertificate(this)'>";
	div.appendChild(newarea);
	certificateLength++;
}

function deletecertificate(data) {
	document.getElementById("certificate").removeChild(data.parentNode);
	certificateLength--;
}

function addcareer() {
	console.log("함수작동");
	var div = document.getElementById("career");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>회사명</label><input type='text' placeholder='회사명을 입력하세요' class='career_companyname'><br>"
		+ "<label>구분</label><select class='career_working'>"
		+ "<option value='working' selected>재직중</option>"
		+ "<option value='quit'>퇴사</option> "
		+ "</select><br>"
		+ "<label>시작일</label><input type='date' class='career_start'><br>"
		+ "<label>종료일</label><input type='date' class='career_end'><br>"
		+ "<label>직급</label><input type='text' placeholder='직급을 입력하세요' class='career_ranks'><br>"
		+ "<label>연봉</label><input type='text' placeholder='직급을 입력하세요' class='career_salary'>만원<br>"
		+ "<label>부서</label><input type='text' placeholder='근무 부서를 입력하세요' class='career_jobduty'>만원<br>"
		+ "<label>상세 근무내용</label><br><textarea rows='15' cols='60' placeholder='상세 근무내용을 입력하세요' class='career_detail'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deletecareer(this)'>";
	div.appendChild(newarea);
	careerLength++;
}

function deletecareer(data) {
	document.getElementById("career").removeChild(data.parentNode);
	careerLength--;
}

function addactivity() {
	console.log("함수작동");
	var div = document.getElementById("activity");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>활동명</label><input type='text' placeholder='활동명을 입력하세요' class='activity_title'><br>"
		+ "<label>시작일</label><input type='date' class='activity_start'><br>"
		+ "<label>종료일</label><input type='date' class='activity_end'><br>"
		+ "<label>주최</label><input type='text' placeholder='주최단체명 등을 입력하세요' class='activity_holdby'><br>"
		+ "<label>활동 상세내용</label><br><textarea rows='15' cols='60' placeholder='활동 상세내용을 입력하세요' class='activity_detail'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteactivity(this)'>";
	div.appendChild(newarea);
	activityLength++;
}

function deleteactivity(data) {
	document.getElementById("activity").removeChild(data.parentNode);
	activityLength--;
}

function addacademic() {
	console.log("함수작동");
	var div = document.getElementById("academic");
	var newarea = document.createElement("p");
	newarea.innerHTML = "<label>학교명</label><input type='text' placeholder='학교명을 입력하세요' class='academic_name'><br>"
		+ "<label>구분</label><select class='academic_type'>"
		+ "<option value='unselected' selected disabled>구분</option>"
		+ "<option value='highschool' >고등학교</option> "
		+ "<option value='university' >대학교</option>"
		+ "<option value='graduateSchool' >대학원</option>"
		+ "</select><br>"
		+ "<label>시작일</label><input type='date' class='academic_start'><br>"
		+ "<label>종료일</label><input type='date' class='academic_end'><br>"
		+ "<label>졸업여부</label><select class='academic_studying'>"
		+ "<option value='unselected' selected disabled>선택</option>"
		+ "<option value='attending'>재학중</option>"
		+ "<option value='off'>휴학중</option>"
		+ "<option value='graduated'>졸업</option>"
		+ "</select><br>"
		+ "<label>전공</label><input type='text' placeholder='전공명을 입력하세요' class='academic_major'><br>"
		+ "<label>학점</label><input type='text' placeholder='학점' class='academic_grade'> / <select class='academic_gradefull'>"
		+ "<option value='4.0'>4.0</option>"
		+ "<option value='4.3' selected>4.3</option>"
		+ "<option value='4.5'>4.5</option>"
		+ "</select><br>"
		+ "<label>학력 상세내용</label><br><textarea rows='15' cols='60' placeholder='상세 학습 내용을 입력하세요' class='academic_detail'></textarea><br>"
		+ "<input type='button' value='삭제' onClick='deleteacademic(this)'>";
	div.appendChild(newarea);
	academicLength++;
}

function deleteacademic(data) {
	document.getElementById("academic").removeChild(data.parentNode);
	academicLength--;
}

window.onload = function() {
	$.ajax({
		type: "get",
		url: "/member/sendMemberData",
		success: function(member) {
			// 이력서 기본 정보 로드
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

	bindDomEvent();
}



function submit() {
	
	
	console.log('academic 개수 : ' + academicLength);

	// resume 입력 정보
	var resume_title = document.getElementById("title").value;
	var resume_cv = document.getElementById("cv").value;
	var resume_openforheadhunter = document.querySelector('input[name="openforheadhunter"]:checked').value;

	// imgfile 입력 정보
	const imageInput = $("#imgfile")[0].files[0];
	const formData = new FormData();
	formData.append("imgfile", imageInput);

	// academic 입력정보
	var academicList = [];
	for (let i = 0; i < academicLength; i++) {
		var academic_start = document.getElementsByClassName('academic_start')[i].value;
		var academic_end = document.getElementsByClassName('academic_end')[i].value;
		var academic_studying = document.getElementsByClassName('academic_studying')[i].value;
		var academic_type = document.getElementsByClassName('academic_type')[i].value;
		var academic_name = document.getElementsByClassName('academic_name')[i].value;
		var academic_major = document.getElementsByClassName('academic_major')[i].value;
		var academic_grade = document.getElementsByClassName('academic_grade')[i].value;
		var academic_gradefull = document.getElementsByClassName('academic_gradefull')[i].value;
		var academic_detail = document.getElementsByClassName('academic_detail')[i].value;	
		
		console.log(i +"의 시작일"+ academic_start);	
		
		var academicDto = {
			start : academic_start,
			end : academic_end,
			studying : academic_studying,
			type : academic_type,
			name : academic_name,
			major : academic_major,
			grade : academic_grade,
			gradefull : academic_gradefull,
			detail : academic_detail
		};
		academicList.push(academicDto);
	}
	
	// activity 입력정보
	var activityList = [];
	for (let i = 0; i < activityLength; i++) {
		var activity_start = document.getElementsByClassName('activity_start')[i].value;
		var activity_end = document.getElementsByClassName('activity_end')[i].value;
		var activity_title = document.getElementsByClassName('activity_title')[i].value;
		var activity_holdby = document.getElementsByClassName('activity_holdby')[i].value;
		var activity_detail = document.getElementsByClassName('activity_detail')[i].value;
		
		var activityDto = {
			start : activity_start,
			end : activity_end,
			title : activity_title,
			holdby : activity_holdby,
			detail : activity_detail
		};
		
		activityList.push(activityDto);
	}
	
	// career 입력정보
	var careerList = [];
	for (let i = 0; i < careerLength; i++) {
		var career_start = document.getElementsByClassName('career_start')[i].value; 
		var career_end = document.getElementsByClassName('career_end')[i].value; 
		var career_working = document.getElementsByClassName('career_working')[i].value; 
		var career_companyname = document.getElementsByClassName('career_companyname')[i].value; 
		var career_ranks = document.getElementsByClassName('career_ranks')[i].value; 
		var career_salary = document.getElementsByClassName('career_salary')[i].value; 
		var career_jobduty = document.getElementsByClassName('career_jobduty')[i].value; 
		var career_detail = document.getElementsByClassName('career_detail')[i].value; 
		
		var careerDto = {
			start : career_start,
			end : career_end,
			working : career_working,
			companyname : career_companyname,
			ranks : career_ranks,
			salary : career_salary,
			jobduty : career_jobduty,
			detail : career_detail
		};
		careerList.push(careerDto);
	}
	
	// certificate 입력정보
	var certificateList = [];
	for (let i = 0; i < certificateLength; i++) {
		var certificate_achievedate = document.getElementsByClassName('certificate_achievedate')[i].value;
		var certificate_name = document.getElementsByClassName('certificate_name')[i].value;
		var certificate_grade = document.getElementsByClassName('certificate_grade')[i].value;
		var certificate_achievefrom = document.getElementsByClassName('certificate_achievefrom')[i].value;
		var certificate_certificatenumber = document.getElementsByClassName('certificate_certificatenumber')[i].value;
		
		var certificateDto = {
			achievedate : certificate_achievedate,
			name : certificate_name,
			grade : certificate_grade,
			achievefrom : certificate_achievefrom,
			certificatenumber : certificate_certificatenumber
		};
		certificateList.push(certificateDto);
	}
	
	// education 입력정보
	var educationList = [];
	for (let i = 0; i < educationLength; i++) {
		var education_start = document.getElementsByClassName('education_start')[i].value;
		var education_end = document.getElementsByClassName('education_end')[i].value;
		var education_title = document.getElementsByClassName('education_title')[i].value;
		var education_holdby = document.getElementsByClassName('education_holdby')[i].value;
		var education_detail = document.getElementsByClassName('education_detail')[i].value;
		
		var educationDto = {
			start : education_start,
			end : education_end,
			title : education_title,
			holdby : education_holdby,
			detail : education_detail
		};
		educationList.push(educationDto);
	}
	
	// languages 입력정보
	var languagesList = [];
	for (let i = 0; i < languagesLength; i++) {
		var langauges_langauges = document.getElementsByClassName('languages_languages')[i].value;
		var langauges_leveltalking = document.getElementsByClassName('languages_leveltalking')[i].value;
		var langauges_levelwriting = document.getElementsByClassName('languages_levelwriting')[i].value;
		var langauges_test = document.getElementsByClassName('languages_test')[i].value;
		var langauges_score = document.getElementsByClassName('languages_score')[i].value;
		var langauges_achievedate = document.getElementsByClassName('languages_achievedate')[i].value;
		var langauges_certificatenumber = document.getElementsByClassName('languages_certificatenumber')[i].value;
		
		var langaugesDto = {
			langauges = languages_langauges,
			leveltalking = languages_leveltalking,
			levelwriting = languages_levelwriting,
			test = languages_test,
			score = languages_score,
			achievedate = languages_achievedate,
			certificatenumber = languages_certificatenumber
		};
		languagesList.push(langaugesDto);
	}
	
	// oe 입력정보
	var oeList = [];
	for (let i = 0; i < oeLength; i++) {
		var oe_start = document.getElementsByClassName('oe_start')[i].value;
		var oe_end = document.getElementsByClassName('oe_end')[i].value;
		var oe_staying = document.getElementsByClassName('oe_staying')[i].value;
		var oe_country = document.getElementsByClassName('oe_country')[i].value;
		var oe_detail = document.getElementsByClassName('oe_detail')[i].value;
		
		var oeDto = {
			start : oe_start,
			end : oe_end,
			staying : oe_staying,
			country : oe_country,
			detail : oe_detail
		};
		oeList.push(oeDto);
	}
	
	// resume 저장하는 ajax
	$.ajax({
		type: "post",
		url: "/resume/input",
		data: {
			title: resume_title,
			cv: resume_cv,
			openforheadhunter: resume_openforheadhunter,
		},
		success: function(data) {
			resumeOk = true;
			console.log(data);
			console.log("ajax 동작");
			// imgfile 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/imgfile/new",
				data: formData,
				contentType: false,
				processData: false,
				success: function(data) {
					
					console.log(data);
					console.log("imgfile 입력");

				},
				error: function(request, status, error) {
					console.log(request.toString());
					console.log(status);
					console.log(error);
				}
			});
			// academic 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/academic/input",
				contentType: "application/json",
				data: JSON.stringify(academicList),
				success: function(data) {
					
					console.log(data);
					console.log("academic 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			// activity 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/activity/input",
				contentType: "application/json",
				data: JSON.stringify(activityList),
				success: function(data) {
					
					console.log(data);
					console.log("activity 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			// career 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/career/input",
				contentType: "application/json",
				data: JSON.stringify(careerList),
				success: function(data) {
					
					console.log(data);
					console.log("career 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			// certificate 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/certificate/input",
				contentType: "application/json",
				data: JSON.stringify(certificateList),
				success: function(data) {
					
					console.log(data);
					console.log("certificate 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			// education 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/education/input",
				contentType: "application/json",
				data: JSON.stringify(educationList),
				success: function(data) {
					
					console.log(data);
					console.log("certificate 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			//langauges 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/languages/input",
				contentType: "application/json",
				data: JSON.stringify(languagesList),
				success: function(data) {
					
					console.log(data);
					console.log("certificate 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
			//oe 저장하는 ajax
			$.ajax({
				type: "post",
				url: "/languages/input",
				contentType: "application/json",
				data: JSON.stringify(oeList),
				success: function(data) {
					
					console.log(data);
					console.log("certificate 입력");
				},
				error: function(request, status, error) {
					console.log("요청 : " + request);
					console.log("상태 : " +  status);
					console.log("error 내용 :" + error);
				}
			});
		},
		error: function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
			console.log("ajax 동작")
		}
	})
		setTimeout(location.replace("/mypage/resume"), 5000);
}

function bindDomEvent() {
	$("#imgfile").on("change", function() {
		var fileName = $(this).val().split("\\").pop(); // 이미지 파일명
		var fileExt = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출
		fileExt = fileExt.toLowerCase(); // 확장자 소문자로 변환
		if (fileExt != "jpg" && fileExt != "jpeg" && fileExt != "gif" && fileExt != "png" && fileExt != "bmp") {
			window.alert("이미지 파일만 등록 가능합니다.");
			return;
		}

		$(this).siblings("#imgfile").html(fileName);
	})
}




