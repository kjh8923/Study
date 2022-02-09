<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>response 객체 메서드</title>
</head>
<body>

<%!
	int age;
%>
<%
	String str = request.getParameter("age");
	//getParameter() 메서드는 문자열을 반환한다
	age = Integer.parseInt(str);
	if(age >= 20){
		response.sendRedirect("pass.jsp?age=" + age);
		//response 객체의 sendRedirect("문자열 경로")는 경로로 페이지 이동
		//jsp의 페이지 이동 경로시 값을 보낼시는 ?속성=값을 경로뒤에 붙인다(html과 동일) 
	}
	else{
		response.sendRedirect("ng.jsp?age=" + age);
	}
%>
</body>
</html>