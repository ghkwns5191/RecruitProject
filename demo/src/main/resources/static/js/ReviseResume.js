/**
 * 
 */
window.onload = function () {

    // 현재 접속 중인 url 을 구하고 해당 url 에서 id 값을 추출하는 작업
    var pathname = window.location.pathname;
    var id = pathname.split("/").pop();

    // 아이디값을 기준으로 resume 정보 불러오기
    $.ajax({
        type: 'get',
        url: '/resume/detail/' + id,
        async: false,
        contentType: 'json/application',
        success : function(resume) {
            console.log(resume);


            // resume id 값을 기준으로 imgfile 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/resume/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(imgfile) {
                    console.log(imgfile);
                },
                error : function(error) {
                    console.log(error);
                }
            });

            // resume id 값을 기준으로 academic 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/academic/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(academicList) {
                    console.log(academicList);
                    var index = academicLength;

                    for (let i = 0; i < index; i++) {
                        // 입력칸 넣는 코드
                        if (academicList[i].type == 'highschool') {
                            var typeselect = 
                                "<tr>" +
                                "<td>구분</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_type form-select form-select-sm'>" +                      
                                "<option value='highschool' selected>고등학교</option> " +
                                "<option value='university' >대학교</option>" +
                                "<option value='graduateSchool' >대학원</option>" +
                                "</select></td>" +
                                "</tr>";
                        } else if (academicList[i].type == 'university') {
                            var typeselect = 
                                "<tr>" +
                                "<td>구분</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_type form-select form-select-sm'>" +                      
                                "<option value='highschool'>고등학교</option> " +
                                "<option value='university' selected>대학교</option>" +
                                "<option value='graduateSchool' >대학원</option>" +
                                "</select></td>" +
                                "</tr>";
                        } else if (academicList[i].type == 'graduateSchool') {
                            var typeselect = 
                                "<tr>" +
                                "<td>구분</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_type form-select form-select-sm'>" +                      
                                "<option value='highschool' >고등학교</option> " +
                                "<option value='university' >대학교</option>" +
                                "<option value='graduateSchool' selected>대학원</option>" +
                                "</select></td>" +
                                "</tr>";
                        }

                        if (academicList[i].studying == 'attending') {
                            var studyingselect = 
                                "<tr>" +
                                "<td>졸업여부</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_studying form-select form-select-sm'>" +
                                "<option value='attending' selected>재학중</option>" +
                                "<option value='off'>휴학중</option>" +
                                "<option value='graduated'>졸업</option>" +
                                "</select></td>" +
                                "</tr>";            
                        } else if (academicList[i].studying == 'off') {
                            var studyingselect = 
                                "<tr>" +
                                "<td>졸업여부</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_studying form-select form-select-sm'>" +
                                "<option value='attending'>재학중</option>" +
                                "<option value='off' selected>휴학중</option>" +
                                "<option value='graduated'>졸업</option>" +
                                "</select></td>" +
                                "</tr>";   
                        } else if (academicList[i].studying == 'graduated') {
                            var studyingselect = 
                                "<tr>" +
                                "<td>졸업여부</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='academic_studying form-select form-select-sm'>" +
                                "<option value='attending'>재학중</option>" +
                                "<option value='off'>휴학중</option>" +
                                "<option value='graduated' selected>졸업</option>" +
                                "</select></td>" +
                                "</tr>";   
                        }

                        if (academicList[i].gradefull == '4.0') {
                            var gradefullselect = 
                                "<tr>" +
                                "<td class='colsizecontrol'>학점</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td><input type='text' placeholder='학점' class='academic_grade inputcontrol form-control form-control-sm inputcontrol'></td><td style='width: 8x; align-items: center; font-size: 20px;'>/</td><td style='width: 220px;'> <select class='academic_gradefull form-select form-select-sm inputcontrol'>" +
                                "<option value='4.0' selected>4.0</option>" +
                                "<option value='4.3'>4.3</option>" +
                                "<option value='4.5'>4.5</option>" +
                                "</select></td>" +
                                "</tr>";           
                        } else if (academicList[i].gradefull == '4.3') {
                            var gradefullselect = 
                                "<tr>" +
                                "<td class='colsizecontrol'>학점</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td><input type='text' placeholder='학점' class='academic_grade inputcontrol form-control form-control-sm inputcontrol'></td><td style='width: 8x; align-items: center; font-size: 20px;'>/</td><td style='width: 220px;'> <select class='academic_gradefull form-select form-select-sm inputcontrol'>" +
                                "<option value='4.0'>4.0</option>" +
                                "<option value='4.3' selected>4.3</option>" +
                                "<option value='4.5'>4.5</option>" +
                                "</select></td>" +
                                "</tr>";      
                        } else if (academicList[i].gradefull == '4.5') {
                            var gradefullselect = 
                                "<tr>" +
                                "<td class='colsizecontrol'>학점</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td><input type='text' placeholder='학점' class='academic_grade inputcontrol form-control form-control-sm inputcontrol'></td><td style='width: 8x; align-items: center; font-size: 20px;'>/</td><td style='width: 220px;'> <select class='academic_gradefull form-select form-select-sm inputcontrol'>" +
                                "<option value='4.0'>4.0</option>" +
                                "<option value='4.3'>4.3</option>" +
                                "<option value='4.5' selected>4.5</option>" +
                                "</select></td>" +
                                "</tr>";      
                        }


                        var div = document.getElementById("academic");
                        var newarea = document.createElement("tbody");
                        newarea.classList.add("tablebody");
                        newarea.innerHTML = 
                          "<tr>" +
                          "<td class='column1st'>학교명</td>" +
                          "<td class='borderleft'>| </td>" +
                          "<td colspan='3' class='columncontent'><input type='text' placeholder='학교명을 입력하세요' class='academic_name form-control form-control-sm'></td>" +
                          "</tr>" +
                          typeselect +
                          "<tr>" +
                          "<td>재학기간</td>" +
                          "<td class='borderleft'>| </td>" +
                          "<td><input type='date' class='academic_start form-control form-control-sm inputcontrol'></td><td style='width: 8px; align-items: center; font-size: 20px;'>~</td><td> <input type='date' class='academic_end form-control form-control-sm inputcontrol'></td>" +
                          "</tr>" + 
                          studyingselect +
                          "<tr>" +
                          "<td>전공 / 계열</td>" +
                          "<td class='borderleft'>| </td>" +
                          "<td colspan='3'><input type='text' placeholder='전공명을 입력하세요' class='academic_major form-control form-control-sm'></td>" +
                          "</tr>" +
                          gradefullselect +
                          "<tr>" +
                          "<td>세부 학습 내용</td>" +
                          "<td class='borderleft'>| </td>" +
                          "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='상세 학습 내용을 입력하세요' class='form-control form-control-sm academic_detail'></textarea></td>" +
                          "</tr>" +
                          "<tr style='text-align: right'>" +
                          "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteacademic(this)' style='height: 30px;'></td></tr>";
                        div.appendChild(newarea);
                        // 입력칸에 데이터를 넣는 코드                                             
                        document.getElementsByClassName("academic_name")[i].value = academicList[i].name;
                        document.getElementsByClassName("academic_start")[i].value = academicList[i].start;
                        document.getElementsByClassName("academic_end")[i].value = academicList[i].end;
                        document.getElementsByClassName("academic_major")[i].value = academicList[i].major;
                        document.getElementsByClassName("academic_grade")[i].value = academicList[i].grade;
                        document.getElementsByClassName("academic_detail")[i].value = academicList[i].detail;
                        
                    }

                    
                }, 
                error : function(error) {
                    console.log(error);
                }
            });

            // resume id 값을 기준으로 activity 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/activity/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(activityList) {
                    console.log(activityList);
                    var index = activityLength;

                    for (let i = 0; i < index; i++) {
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

                        document.getElementsByClassName("activity_title")[i].value = activityList[i].title;
                        document.getElementsByClassName("activity_start")[i].value = activityList[i].start;
                        document.getElementsByClassName("activity_end")[i].value = activityList[i].end;
                        document.getElementsByClassName("activity_holdby")[i].value = activityList[i].holdby;
                        document.getElementsByClassName("activity_detail")[i].value = activityList[i].detail;
                    }
                },
                error : function(error) {
                    console.log(error);
                }
            });

            // resume id 값을 기준으로 career 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/activity/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(careerList) {
                    console.log(careerList);
                    var index = careerLength;

                    for (let i = 0; i < index; i++) {
                        if (careerList[i].working == 'working') {
                            var workingselect = 
                                "<tr>" +
                                "<td>구분</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='career_working form-select form-select-sm'>" +
                                "<option value='working' selected>재직중</option>" +
                                "<option value='quit'>퇴사</option> " +
                                "</select></td>" +
                                "</tr>";
                        } else if (careerList[i].working == 'quit') {
                            var workingselect = 
                                "<tr>" +
                                "<td>구분</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='career_working form-select form-select-sm'>" +
                                "<option value='working'>재직중</option>" +
                                "<option value='quit' selected>퇴사</option> " +
                                "</select></td>" +
                                "</tr>";
                        }
                        var div = document.getElementById("career");
                        var newarea = document.createElement("tbody");
                        newarea.classList.add("tablebody");
                        newarea.innerHTML =
                            "<tr>" +
                            "<td class='column1st'>회사명</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td colspan='3' class='columncontent'><input type='text' placeholder='회사명을 입력하세요' class='career_companyname form-control form-control-sm'></td>" +
                            "</tr>" +
                            workingselect +
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

                        document.getElementsByClassName("career_companyname")[i].value = careerList[i].companyname;
                        document.getElementsByClassName("career_start")[i].value = careerList[i].start;
                        document.getElementsByClassName("career_end")[i].value = careerList[i].end;
                        document.getElementsByClassName("career_ranks")[i].value = careerList[i].ranks;
                        document.getElementsByClassName("career_salary")[i].value = careerList[i].salary;
                        document.getElementsByClassName("career_jobduty")[i].value = careerList[i].jobduty;
                        document.getElementsByClassName("career_detail")[i].value = careerList[i].detail;
                    }

                },
                error: function(error) {
                    console.log(error);
                }
            });

            // resume id 값을 기준으로 certificate 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/certificate/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(certificateList) {
                    console.log(certificateList);
                    var index = certificateLength;

                    for (let i = 0; i < index; i++) {
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
                            "<tr style='text-align: right'                  >" +
                            "<td colspan='2' style='width: 580px;'></td><td><input type='button' class='btn-close' aria-label='Close' onClick='deletecertificate(this)' style='height: 30px;'></td></tr>";
                            div.appendChild(newarea);

                        document.getElementsByClassName("certificate_name")[i].value = certificateList[i].name;
                        document.getElementsByClassName("certificate_achievedate")[i].value = certificateList[i].achievedate;
                        document.getElementsByClassName("certificate_grade")[i].value = certificateList[i].grade;
                        document.getElementsByClassName("certificate_achievefrom")[i].value = certificateList[i].achievefrom;
                        document.getElementsByClassName("certificate_certificatenumber")[i].value = certificateList[i].certificatenumber;
                    }
                },
                error : function(error) {
                    console.log(error);
                }
            });

            // resume id 값을 기준으로 education 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/education/get' + id,
                async: false,
                contentType: 'json/application',
                success : function(educationList) {
                    var index = educationLength;

                    for (let i = 0; i < index; i++) {
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

                            document.getElementsByClassName("education_title")[i].value = educationList[i].title;
                            document.getElementsByClassName("education_start")[i].value = educationList[i].start;
                            document.getElementsByClassName("education_end")[i].value = educationList[i].end;
                            document.getElementsByClassName("education_holdby")[i].value = educationList[i].holdby;
                            document.getElementsByClassName("education_detail")[i].value = educationList[i].detail;
                    }
                },
                error : function(error) {

                }
            });

            // resume id 값을 기준으로 languages 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/languages/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(languagesList) {

                    if (languagesList[i].leveltalking == 'novice') {
                        var leveltalking_select = 
                            "<tr>" +
                            "<td>회화능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_leveltalking' form-select form-select-sm'>" +
                            "<option value='novice' selected>기초 일상 회화</option>" +
                            "<option value='intermediate'>비즈니스 회화</option>" +
                            "<option value='native'>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";
                    } else if (languagesList[i].leveltalking == 'intermediate') {
                        var leveltalking_select = 
                            "<tr>" +
                            "<td>회화능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_leveltalking' form-select form-select-sm'>" +
                            "<option value='novice'>기초 일상 회화</option>" +
                            "<option value='intermediate' selected>비즈니스 회화</option>" +
                            "<option value='native'>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";
                    } else if (languagesList[i].leveltalking == 'native') {
                        var leveltalking_select = 
                            "<tr>" +
                            "<td>회화능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_leveltalking' form-select form-select-sm'>" +
                            "<option value='novice'>기초 일상 회화</option>" +
                            "<option value='intermediate'>비즈니스 회화</option>" +
                            "<option value='native' selected>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";
                    }

                    if (languagesList[i].levelwriting == 'novice') {
                        var levelwriting_select = 
                            "<tr>" +
                            "<td>작문/독해능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_levelwriting' form-select form-select-sm'>" +
                            "<option value='novice' selected>기초 작문/독해</option>" +
                            "<option value='intermediate'>비즈니스 작문/독해</option>" +
                            "<option value='native'>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";
                    } else if (languagesList[i].levelwriting == 'intermediate') {
                        var levelwriting_select = 
                            "<tr>" +
                            "<td>작문/독해능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_levelwriting' form-select form-select-sm'>" +
                            "<option value='novice'>기초 작문/독해</option>" +
                            "<option value='intermediate' selected>비즈니스 작문/독해</option>" +
                            "<option value='native'>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";
                    } else if (languagesList[i].levelwriting == 'native') {
                        var levelwriting_select = 
                            "<tr>" +
                            "<td>작문/독해능력</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td><select class='languages_levelwriting' form-select form-select-sm'>" +
                            "<option value='novice'>기초 작문/독해</option>" +
                            "<option value='intermediate'>비즈니스 작문/독해</option>" +
                            "<option value='native' selected>원어민 수준</option>" +
                            "</select></td>" +
                            "</tr>";                        
                    }

                    var index = languagesLength;
                    for (let i = 0; i < index; i++) {
                        var div = document.getElementById("languages");
                        var newarea = document.createElement("tbody");
                        newarea.classList.add("tablebody");
                        newarea.innerHTML =
                            "<tr>" +
                            "<td class='column1st'>언어명</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td class='columncontent'><input type='text' placeholder='활용 가능한 언어를 입력하세요' class='languages_languages form-control form-control-sm'></td>" +
                            "</tr>" +
                            leveltalking_select +
                            levelwriting_select +
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

                            document.getElementsByClassName("languages_languages")[i].vaule = languagesList[i].languages;
                            document.getElementsByClassName("languages_test")[i].vaule = languagesList[i].test;
                            document.getElementsByClassName("languages_score")[i].vaule = languagesList[i].score;
                            document.getElementsByClassName("languages_certificatenumber")[i].vaule = languagesList[i].certificatenumber;
                    }
                },
                error : function(error) {

                }
            });

            // resume id 값을 기준으로 oe 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/overseasexperience/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(oeList) {
                    var index = oeLength;

                    for (let i = 0; i < index; i++) {

                        if (oeList[i].staying == 'staying') {
                            var staying_select = 
                                "<tr>" +
                                "<td>현재 체류여부</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='oe_staying form-select form-select-sm'>" +
                                "<option value='staying' selected>현재 체류 중</option>" +
                                "<option value='back'>현재 체류 중 아님</option>" +
                                "</select></td>" +
                                "</tr>";
                        } else if (oeList[i].staying == 'back') {
                            var staying_select = 
                                "<tr>" +
                                "<td>현재 체류여부</td>" +
                                "<td class='borderleft'>| </td>" +
                                "<td colspan='3'><select class='oe_staying form-select form-select-sm'>" +
                                "<option value='staying'>현재 체류 중</option>" +
                                "<option value='back' selected>현재 체류 중 아님</option>" +
                                "</select></td>" +
                                "</tr>";
                        }

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
                            staying_select +
                            "<tr>" +
                            "<td>해외 활동 내용</td>" +
                            "<td class='borderleft'>| </td>" +
                            "<td colspan='3' style='text-align: right;'><textarea rows='5' placeholder='체류 중의 상세 활동내용을 입력하세요' class='oe_detail form-control form-control-sm'></textarea></td>" +
                            "</tr>" +
                            "<tr style='text-align: right'>" +
                            "<td colspan='4' style='width: 580px;'></td><td style='width: 20px;'><input type='button' class='btn-close' aria-label='Close' onClick='deleteoe(this)' style='height: 30px;'></td></tr>";
                            div.appendChild(newarea);

                            document.getElementsByClassName("oe_country")[i].value = oeList[i].country;
                            document.getElementsByClassName("oe_start")[i].value = oeList[i].start;
                            document.getElementsByClassName("oe_end")[i].value = oeList[i].end;
                            document.getElementsByClassName("oe_detail")[i].value = oeList[i].detail;
                    }
                },
                error : function(error) {

                }
            });

            // resume id 값을 기준으로 portfolio 정보 불러오기
            $.ajax({
                type: 'get',
                url: '/portfolio/get/' + id,
                async: false,
                contentType: 'json/application',
                success : function(portfolioList) {
                    var index = portfolioLength;
                    for (let i = 0; i < index; i++) {
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

                            document.getElementsByClassName("portfolio_title")[i].value = portfolioList[i].title;
                            document.getElementsByClassName("portfolio_url1")[i].value = portfolioList[i].url1;
                            document.getElementsByClassName("portfolio_url2")[i].value = portfolioList[i].url2;
                               
                    }

                    $.ajax({
                        type: 'get',
                        url: '/portfoliofile/get/' + id,
                        async: false,
                        contentType: 'json/application',
                        success : function (portfoliofileList) {
                            var index = portfolioLength;
                            for (let i = 0; i < index; i++) {
                                document.getElementsByClassName("portfoliofiles")[i].value = portfoliofileList[i].oriname;
                            }
                            
                        },
                        error : function (error) {

                        }
                    });

                    
                },
                error : function(error) {

                }
            });

        }, 
        error : function(error) {
            console.log(error);
        }
    });
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


