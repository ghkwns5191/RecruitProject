<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="
    com.example.demo.recruit.service.RecruitService, 
    com.example.demo.recruit.entity.Recruit,
    java.util.List, java.util.ArrayList
    "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! 
	RecruitService recruitService = new RecruitService();
	Recruit recruit = new Recruit();
	
	List<Recruit> recruitList = recruitService.getRecruit();
	
	String title = recruit.getRecruit_title();
%>

제목 : <%= title %>
</body>
</html>