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
<title>로그인 처리 jsp</title>
</head>
<body>

<%!
	String id, pw;
%>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	if(id.equals("abcde") && pw.equals("12345")) {
		session.setAttribute("id", id); //HttpSession session
										//setAttribute(String arg0, Object arg1) 파라메타로 문자열 이름(String)을 사용하고 값은 어느 객체(Object)가 와도 됨
										//session에 id라는 속성의 파라메터로 받은 id값 abcde를 설정
		response.sendRedirect("S_welcom.jsp");								
	}
	else{
		//로그인 실패이므로 다시 Login.html로 이동
		response.sendRedirect("S_Login.html");
	}
%>
</body>
</html>