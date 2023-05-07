/**
 *
 */
var academicLength = 0;
var activityLength = 0;
var careerLength = 0;
var certificateLength = 0;
var educationLength = 0;
var languagesLength = 0;
var oeLength = 0;
var portfolioLength = 0;

function addportfolio() {
  var div = document.getElementById("portfolio");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>포트폴리오 제목</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' name='title' placeholder='제목을 입력하세요' class='portfolio_title form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>URL1</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' name='url1' placeholder='포트폴리오 관련 url 을 입력하세요' class='portfolio_url1 form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>URL2</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' name='url2' placeholder='포트폴리오 관련 url 을 입력하세요' class='portfolio_url2 form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>포트폴리오 파일</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='file' class='portfoliofiles'></td>" +
    "</tr>" +
	"<tr style='text-align: right'>" +
    "<td colspan='2' style='width: 580px;'></td><td><input type='button' class='btn-close' aria-label='Close' onClick='deleteportfolio(this)' style='height: 30px;'></td></tr>";
	div.appendChild(newarea);
  portfolioLength++;
}

function deleteportfolio(data) {
  document.getElementById("portfolio").removeChild(data.closest(".tablebody"));
  portfolioLength--;
}

function addoe() {
  var div = document.getElementById("oe");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>체류 국가명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' name='country' placeholder='체류 국가명을 입력하세요' class='oe_country form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td>체류기간</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='date' class='oe_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td style='width: 220px;'> <input type='date' class='oe_end form-control form-control-sm inputcontrol'></td>" +
    "</tr>" +
	"<tr>" +
    "<td>현재 체류여부</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><select class='oe_staying form-select form-select-sm'>" +
    "<option value='staying' selected>현재 체류 중</option>" +
    "<option value='back'>현재 체류 중 아님</option>" +
    "</select></td>" +
    "</tr>" +
	"<tr>" +
    "<td>해외 활동 내용</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='체류 중의 상세 활동내용을 입력하세요' class='oe_detail form-control form-control-sm'></textarea></td>" +
    "</tr>" +
    "<tr style='text-align: right'>" +
    "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteoe(this)' style='height: 30px;'></td></tr>";
	div.appendChild(newarea);
  oeLength++;

}

function deleteoe(data) {
  document.getElementById("oe").removeChild(data.closest(".tablebody"));
  oeLength--;
}

function addlanguages() {
  var div = document.getElementById("languages");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>언어명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='활용 가능한 언어를 입력하세요' class='languages_languages form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td>회화능력</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><select class='languages_leveltalking' form-select form-select-sm'>" +
    "<option value='novice' selected>기초 일상 회화</option>" +
    "<option value='intermediate'>비즈니스 회화</option>" +
    "<option value='native'>원어민 수준</option>" +
    "</select></td>" +
    "</tr>" +
	"<tr>" +
    "<td>작문/독해능력</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><select class='languages_levelwriting' form-select form-select-sm'>" +
    "<option value='novice' selected>기초 작문/독해</option>" +
    "<option value='intermediate'>비즈니스 작문/독해</option>" +
    "<option value='native'>원어민 수준</option>" +
    "</select></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>어학시험명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='응시했던 어학시험 이름을 입력하세요' class='languages_test form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>점수 및 등급</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='취득한 점수 혹은 등급을 입력하세요' class='languages_score form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>성적표 번호</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='취득한 성적표 번호를 입력하세요' class='languages_certificatenumber form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr style='text-align: right'>" +
    "<td colspan='2' style='width: 580px;'></td><td><input type='button' class='btn-close' aria-label='Close' onClick='deletelanguages(this)' style='height: 30px;'></td></tr>";
	div.appendChild(newarea);
	languagesLength++;

}

function deletelanguages(data) {
  document.getElementById("languages").removeChild(data.closest(".tablebody"));
  languagesLength--;
}

function addeducation() {
  var div = document.getElementById("education");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>교육명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' placeholder='교육명을 입력하세요' class='education_title form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>교육기간</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='date' class='education_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td style='width: 220px;'> <input type='date' class='education_end form-control form-control-sm inputcontrol'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>교육기관</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' placeholder='교육기관명을 입력하세요' class='education_holdby form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td>상세 교육 내용</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='교육 상세내용을 입력하세요' class='education_detail form-control form-control-sm'></textarea></td>" +
    "</tr>" +
    "<tr style='text-align: right'>" +
    "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteeducation(this)' style='height: 30px;'></td></tr>";
	div.appendChild(newarea);
  educationLength++;

}

function deleteeducation(data) {
  document.getElementById("education").removeChild(data.closest(".tablebody"));
  educationLength--;
}

function addcertificate() {
  var div = document.getElementById("certificate");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>자격증명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='자격증 이름을 입력하세요' class='certificate_name form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td class='column1st'>취득일</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='date' class='certificate_achievedate form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td class='column1st'>등급 / 점수</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='등급 / 점수를 입력하세요' class='certificate_grade form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>발급기관</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='자격증 발급기관을 입려하세요' class='certificate_achievefrom form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr>" +
    "<td class='column1st'>자격증 번호</td>" +
    "<td class='borderleft'>| </td>" +
    "<td class='columncontent'><input type='text' placeholder='자격증 번호를 입력하세요' class='certificate_certificatenumber form-control form-control-sm'></td>" +
    "</tr>" +
	"<tr style='text-align: right'>" +
    "<td colspan='2' style='width: 580px;'></td><td><input type='button' class='btn-close' aria-label='Close' onClick='deletecertificate(this)' style='height: 30px;'></td></tr>";
	div.appendChild(newarea);
	certificateLength++;

    
}

function deletecertificate(data) {
  document.getElementById("certificate").removeChild(data.closest(".tablebody"));
  certificateLength--;
}

function addcareer() {
  var div = document.getElementById("career");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>회사명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' placeholder='회사명을 입력하세요' class='career_companyname form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>구분</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><select class='career_working form-select form-select-sm'>" +
    "<option value='working' selected>재직중</option>" +
    "<option value='quit'>퇴사</option> " +
    "</select></td>" +
    "</tr>" +
    "<tr>" +
    "<td>근무기간</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='date' class='career_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td style='width: 220px;'> <input type='date' class='career_end form-control form-control-sm inputcontrol'></td>" +
    "</tr>" + 
	"<tr>" +
    "<td>직급</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><input type='text' placeholder='직급을 입력하세요' class='career_ranks form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>연봉</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><input type='text' placeholder='연봉을 입력하세요' class='career_salary form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>부서</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><input type='text' placeholder='근무 부서를 입력하세요' class='career_jobduty form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>세부 근무 성과</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='상세 근무내용 및 성과를 입력하세요' class='career_detail form-control form-control-sm'></textarea></td>" +
    "</tr>" +
    "<tr style='text-align: right'>" +
    "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deletecareer(this)' style='height: 30px;'></td></tr>";
  div.appendChild(newarea);
  careerLength++;
}

function deletecareer(data) {
  document.getElementById("career").removeChild(data.closest(".tablebody"));
  careerLength--;
}

function addactivity() {
  var div = document.getElementById("activity");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
  	"<tr>" +
    "<td class='column1st'>활동명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' placeholder='활동명을 입력하세요' class='activity_title form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>활동기간</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='date' class='activity_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td style='width: 220px;'> <input type='date' class='activity_end form-control form-control-sm inputcontrol'></td>" +
    "<tr>" +
    "<td>주최</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><input type='text' placeholder='주최단체명 등을 입력하세요' class='activity_holdby form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>세부 활동 내용</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='활동 상세내용을 입력하세요' class='activity_detail form-control form-control-sm'></textarea></td>" +
    "</tr>" +
    "<tr style='text-align: right'>" +
    "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteactivity(this)' style='height: 30px;'></td></tr>";
  div.appendChild(newarea);
  activityLength++;
}

function deleteactivity(data) {
  document.getElementById("activity").removeChild(data.closest(".tablebody"));
  activityLength--;
}

function addacademic() {
  console.log("작동?");
  var div = document.getElementById("academic");
  var newarea = document.createElement("tbody");
  newarea.classList.add("tablebody");
  newarea.innerHTML =
    "<tr>" +
    "<td class='column1st'>학교명</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' class='columncontent'><input type='text' placeholder='학교명을 입력하세요' class='academic_name form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td>구분</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><select class='academic_type form-select form-select-sm'>" +
    "<option value='unselected' selected disabled>구분</option>" +
    "<option value='highschool' >고등학교</option> " +
    "<option value='university' >대학교</option>" +
    "<option value='graduateSchool' >대학원</option>" +
    "</select></td>" +
    "</tr>" +
    "<tr>" +
    "<td>재학기간</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='date' class='academic_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td> <input type='date' class='academic_end form-control form-control-sm inputcontrol'></td>" +
    "</tr><tr>" +
    "<td>졸업여부</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><select class='academic_studying form-select form-select-sm'>" +
    "<option value='unselected' selected disabled>선택</option>" +
    "<option value='attending'>재학중</option>" +
    "<option value='off'>휴학중</option>" +
    "<option value='graduated'>졸업</option>" +
    "</select></td>" +
    "</tr>" +
    "<tr>" +
    "<td>전공 / 계열</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3'><input type='text' placeholder='전공명을 입력하세요' class='academic_major form-control form-control-sm'></td>" +
    "</tr>" +
    "<tr>" +
    "<td class='colsizecontrol'>학점</td>" +
    "<td class='borderleft'>| </td>" +
    "<td><input type='text' placeholder='학점' class='academic_grade inputcontrol form-control form-control-sm inputcontrol'></td><td style='width: 8x; align-items: center; font-size: 20px;'>/</td><td style='width: 220px;'> <select class='academic_gradefull form-select form-select-sm inputcontrol'>" +
    "<option value='4.0'>4.0</option>" +
    "<option value='4.3' selected>4.3</option>" +
    "<option value='4.5'>4.5</option>" +
    "</select></td>" +
    "</tr>" +
    "<tr>" +
    "<td>세부 학습 내용</td>" +
    "<td class='borderleft'>| </td>" +
    "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='상세 학습 내용을 입력하세요' class='form-control form-control-sm academic_detail'></textarea></td>" +
    "</tr>" +
    "<tr style='text-align: right'>" +
    "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteacademic(this)' style='height: 30px;'></td></tr>";
  div.appendChild(newarea);
  academicLength++;
}

function deleteacademic(data) {
  document.getElementById("academic").removeChild(data.closest(".tablebody"));
  academicLength--;
}

window.onload = function () {
  $.ajax({
    type: "get",
    url: "/member/sendMemberData",
    success: function (member) {
      // 이력서 기본 정보 로드
      document.getElementById("name").value = member.name;
      document.getElementById("phone").value = member.phone;
      document.getElementById("email").value = member.email;
      document.getElementById("birthday").value = member.birthday;

      var fulladdress = member.address;
      if (fulladdress.length <= 50) {
        document.getElementById("add1").value = fulladdress;
        document.getElementById("add2").value = " ";
      } else if (fulladdress.length > 50) {
        let i = 0;
        let index = fulladdress.indexOf(" ");
        while (i <= 50) {
          i = fulladdress.indexOf(" ", index + 1);
        }
        var add1 = fulladdrees.slice(0, i);
        var add2 = fulladdrees.slice(i + 1, fulladdress.length);

        document.getElementById("add1").value = add1;
        document.getElementById("add2").value = add2;
      }
    },
    error: function (request, status, error) {
      console.log(request);
      console.log(status);
      console.log(error);
    },
  });

  bindDomEvent();
};

function submit() {
  console.log("academic 개수 : " + academicLength);

  // resume 입력 정보
  var resume_title = document.getElementById("title").value;
  var resume_cv = document.getElementById("cv").value;
  var resume_openforheadhunter = document.querySelector(
    'input[name="openforheadhunter"]:checked'
  ).value;

  // imgfile 입력 정보
  const imageInput = $("#imgfile")[0].files[0];
  const formData = new FormData();
  formData.append("imgfile", imageInput);

  // academic 입력정보
  var academicList = [];
  for (let i = 0; i < academicLength; i++) {
    var academic_start =
      document.getElementsByClassName("academic_start")[i].value;
    var academic_end = document.getElementsByClassName("academic_end")[i].value;
    var academic_studying =
      document.getElementsByClassName("academic_studying")[i].value;
    var academic_type =
      document.getElementsByClassName("academic_type")[i].value;
    var academic_name =
      document.getElementsByClassName("academic_name")[i].value;
    var academic_major =
      document.getElementsByClassName("academic_major")[i].value;
    var academic_grade =
      document.getElementsByClassName("academic_grade")[i].value;
    var academic_gradefull =
      document.getElementsByClassName("academic_gradefull")[i].value;
    var academic_detail =
      document.getElementsByClassName("academic_detail")[i].value;

    console.log(i + "의 시작일" + academic_start);

    var academicDto = {
      start: academic_start,
      end: academic_end,
      studying: academic_studying,
      type: academic_type,
      name: academic_name,
      major: academic_major,
      grade: academic_grade,
      gradefull: academic_gradefull,
      detail: academic_detail,
    };
    academicList.push(academicDto);
  }

  // activity 입력정보
  var activityList = [];
  for (let i = 0; i < activityLength; i++) {
    var activity_start =
      document.getElementsByClassName("activity_start")[i].value;
    var activity_end = document.getElementsByClassName("activity_end")[i].value;
    var activity_title =
      document.getElementsByClassName("activity_title")[i].value;
    var activity_holdby =
      document.getElementsByClassName("activity_holdby")[i].value;
    var activity_detail =
      document.getElementsByClassName("activity_detail")[i].value;

    var activityDto = {
      start: activity_start,
      end: activity_end,
      title: activity_title,
      holdby: activity_holdby,
      detail: activity_detail,
    };

    activityList.push(activityDto);
  }

  // career 입력정보
  var careerList = [];
  for (let i = 0; i < careerLength; i++) {
    var career_start = document.getElementsByClassName("career_start")[i].value;
    var career_end = document.getElementsByClassName("career_end")[i].value;
    var career_working =
      document.getElementsByClassName("career_working")[i].value;
    var career_companyname =
      document.getElementsByClassName("career_companyname")[i].value;
    var career_ranks = document.getElementsByClassName("career_ranks")[i].value;
    var career_salary =
      document.getElementsByClassName("career_salary")[i].value;
    var career_jobduty =
      document.getElementsByClassName("career_jobduty")[i].value;
    var career_detail =
      document.getElementsByClassName("career_detail")[i].value;

    var careerDto = {
      start: career_start,
      end: career_end,
      working: career_working,
      companyname: career_companyname,
      ranks: career_ranks,
      salary: career_salary,
      jobduty: career_jobduty,
      detail: career_detail,
    };
    careerList.push(careerDto);
  }

  // certificate 입력정보
  var certificateList = [];
  for (let i = 0; i < certificateLength; i++) {
    var certificate_achievedate = document.getElementsByClassName(
      "certificate_achievedate"
    )[i].value;
    var certificate_name =
      document.getElementsByClassName("certificate_name")[i].value;
    var certificate_grade =
      document.getElementsByClassName("certificate_grade")[i].value;
    var certificate_achievefrom = document.getElementsByClassName(
      "certificate_achievefrom"
    )[i].value;
    var certificate_certificatenumber = document.getElementsByClassName(
      "certificate_certificatenumber"
    )[i].value;

    var certificateDto = {
      achievedate: certificate_achievedate,
      name: certificate_name,
      grade: certificate_grade,
      achievefrom: certificate_achievefrom,
      certificatenumber: certificate_certificatenumber,
    };
    certificateList.push(certificateDto);
  }

  // education 입력정보
  var educationList = [];
  for (let i = 0; i < educationLength; i++) {
    var education_start =
      document.getElementsByClassName("education_start")[i].value;
    var education_end =
      document.getElementsByClassName("education_end")[i].value;
    var education_title =
      document.getElementsByClassName("education_title")[i].value;
    var education_holdby =
      document.getElementsByClassName("education_holdby")[i].value;
    var education_detail =
      document.getElementsByClassName("education_detail")[i].value;

    var educationDto = {
      start: education_start,
      end: education_end,
      title: education_title,
      holdby: education_holdby,
      detail: education_detail,
    };
    educationList.push(educationDto);
  }

  // languages 입력정보
  var languagesList = [];
  for (let i = 0; i < languagesLength; i++) {
    var languages_languages = document.getElementsByClassName(
      "languages_languages"
    )[i].value;
    var languages_leveltalking = document.getElementsByClassName(
      "languages_leveltalking"
    )[i].value;
    var languages_levelwriting = document.getElementsByClassName(
      "languages_levelwriting"
    )[i].value;
    var languages_test =
      document.getElementsByClassName("languages_test")[i].value;
    var languages_score =
      document.getElementsByClassName("languages_score")[i].value;
    var languages_achievedate = document.getElementsByClassName(
      "languages_achievedate"
    )[i].value;
    var languages_certificatenumber = document.getElementsByClassName(
      "languages_certificatenumber"
    )[i].value;

    var langaugesDto = {
      languages: languages_languages,
      leveltalking: languages_leveltalking,
      levelwriting: languages_levelwriting,
      test: languages_test,
      score: languages_score,
      achievedate: languages_achievedate,
      certificatenumber: languages_certificatenumber,
    };
    languagesList.push(langaugesDto);
  }

  // oe 입력정보
  var oeList = [];
  for (let i = 0; i < oeLength; i++) {
    var oe_start = document.getElementsByClassName("oe_start")[i].value;
    var oe_end = document.getElementsByClassName("oe_end")[i].value;
    var oe_staying = document.getElementsByClassName("oe_staying")[i].value;
    var oe_country = document.getElementsByClassName("oe_country")[i].value;
    var oe_detail = document.getElementsByClassName("oe_detail")[i].value;

    var oeDto = {
      start: oe_start,
      end: oe_end,
      staying: oe_staying,
      country: oe_country,
      detail: oe_detail,
    };
    oeList.push(oeDto);
  }

  // portfolio 입력정보

  var portfolioData = new FormData();

  for (let i = 0; i < portfolioLength; i++) {
    var portfolio_title =
      document.getElementsByClassName("portfolio_title")[i].value;
    var portfolio_url1 =
      document.getElementsByClassName("portfolio_url1")[i].value;
    var portfolio_url2 =
      document.getElementsByClassName("portfolio_url2")[i].value;

    portfolioData.append("portfoliofile", $(".portfoliofiles")[i].files[0]);
    portfolioData.append("title", portfolio_title);
    portfolioData.append("url1", portfolio_url1);
    portfolioData.append("url2", portfolio_url2);
  }

  // resume 저장하는 ajax
  $.ajax({
    type: "post",
    url: "/resume/input",
    async: false,
    data: {
      title: resume_title,
      cv: resume_cv,
      openforheadhunter: resume_openforheadhunter,
    },
    success: function (data) {
      console.log(data);
      console.log("ajax 동작");
      // imgfile 저장하는 ajax
      $.ajax({
        type: "post",
        url: "/imgfile/new",
        async: false,
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
          console.log(data);
          console.log("imgfile 입력");
        },
        error: function (request, status, error) {
          console.log(request.toString());
          console.log(status);
          console.log(error);
        },
      });
      // academic 저장하는 ajax
      $.ajax({
        type: "post",
        url: "/academic/input",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(academicList),
        success: function (data) {
          console.log(data);
          console.log("academic 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      // activity 저장하는 ajax
      $.ajax({
        type: "post",
        url: "/activity/input",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(activityList),
        success: function (data) {
          console.log(data);
          console.log("activity 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      // career 저장하는 ajax
      $.ajax({
        type: "post",
        url: "/career/input",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(careerList),
        success: function (data) {
          console.log(data);
          console.log("career 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      // certificate 저장하는 ajax
      $.ajax({
        type: "post",
        url: "/certificate/input",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(certificateList),
        success: function (data) {
          console.log(data);
          console.log("certificate 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      // education 저장하는 ajax
      $.ajax({
        type: "post",
        async: false,
        url: "/education/input",
        contentType: "application/json",
        data: JSON.stringify(educationList),
        success: function (data) {
          console.log(data);
          console.log("education 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      //langauges 저장하는 ajax
      $.ajax({
        type: "post",
        async: false,
        url: "/languages/input",
        contentType: "application/json",
        data: JSON.stringify(languagesList),
        success: function (data) {
          console.log(data);
          console.log("languages 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      //oe 저장하는 ajax
      $.ajax({
        type: "post",
        async: false,
        url: "/overseas/input",
        contentType: "application/json",
        data: JSON.stringify(oeList),
        success: function (data) {
          console.log(data);
          console.log("oe 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
      // portfolio 저장하는 ajax
      $.ajax({
        type: "post",
        async: false,
        url: "/portfolio/input",
        contentType: false,
        processData: false,
        data: portfolioData,
        success: function (data) {
          console.log(data);
          console.log("portfolio 입력");
        },
        error: function (request, status, error) {
          console.log("요청 : " + request);
          console.log("상태 : " + status);
          console.log("error 내용 :" + error);
        },
      });
    },
    error: function (request, status, error) {
      console.log(request);
      console.log(status);
      console.log(error);
      console.log("ajax 동작");
    },
  });

  // 5초 이후 이력서 목록으로 이동.
  setTimeout(() => (location.href = "/mypage"), 0000);
}

function back() {
	history.go(-1);
}

function bindDomEvent() {
  $("#imgfile").on("change", function () {
    var fileName = $(this).val().split("\\").pop(); // 이미지 파일명
    var fileExt = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출
    fileExt = fileExt.toLowerCase(); // 확장자 소문자로 변환
    if (
      fileExt != "jpg" &&
      fileExt != "jpeg" &&
      fileExt != "gif" &&
      fileExt != "png" &&
      fileExt != "bmp"
    ) {
      window.alert("이미지 파일만 등록 가능합니다.");
      return;
    }

    $(this).siblings("#imgfile").html(fileName);
  });
}

function previewimage(event) {
  var reader = new FileReader();
  reader.onload = function () {
    var output = document.getElementById("preview");
    output.src = reader.result;
  };
  reader.readAsDataURL(event.target.files[0]);
}
