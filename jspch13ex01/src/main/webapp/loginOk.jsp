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
<title>로그인 처리</title>
</head>
<body>

<%!
	String id, pw;	
%>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	if(id.equals("abcde") && pw.equals("12345")){
		Cookie cookie = new Cookie("id", id); //"id"는 생성할 쿠기 이름 값은 변수 id
		cookie.setMaxAge(60); //최대 유지시간(초)
		response.addCookie(cookie); //응답객체에 쿠기 저장
		response.sendRedirect("welcome.jsp");
	}
	else{
		response.sendRedirect("Login.html");
	}
%>
</body>
</html>