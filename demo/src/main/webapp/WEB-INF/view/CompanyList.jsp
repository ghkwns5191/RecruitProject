<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="
    com.example.demo.recruit.service.CompanyService, 
    com.example.demo.recruit.entity.Company,
    java.util.List, java.util.ArrayList
    "%>
    <%@taglib prefix="c" uri="http://java.sum.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html lang="en">

<%! 
	CompanyService companyService = new CompanyService();	
	List<Company> companyList = companyService.getcompany();
	Company company = new Company();
	Integer maxcount = companyList.size()-1;
	
	
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
        content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../css/companyList.css">
    <title>등록된 업체 리스트</title>
</head>

<body>
    <div id="total-content">
        <label id="button_bunch">
            <button id="top_button" class="recruit_button">채용 정보</button>
            <button id="top_button" class="company_button">기업 리뷰</button>
        </label>
        <label id="banner">

        </label>
        <div id="main-content">
            <label id="search">
                <input type="text" placeholder="기업명을 입력하세요" class="search">
                <button class="search-button">검색</button>
            </label>

            <table id="company_table" class="company_list">
                <thead>
                    <th>번호</th>
                    <th>기업 이름</th>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>엘지생활건강 태국법인</td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>코스맥스</td>
                    </tr>

                    <tr>
                        <td>3</td>
                        <td>잼프린팅</td>
                    </tr>
                    <c:forEach var="i" begin="1" end="9">
                    ${i }
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</body>

</html>