<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
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
<title>parameter 처리메서드들</title>
</head>
<body>

<%!
	String name, id, pw, major, protocol;
	//form에서 오는 name속성값들을 저장할 변수 선언
	String[] hobbys;
	//복수개로 form에서 오는 체크박스 선택값을 저장하는 배열 변수
%>
<%
	request.setCharacterEncoding("UTF-8"); //post방식에서의 한글 인코딩
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	major = request.getParameter("major");
	protocol = request.getParameter("protocol");
	hobbys = request.getParameterValues("hobby"); //복수개의 값이 오므로 getParameterValues("hobby")를 사용
%>
이름 : <%= name %> <br/>
아이디 : <%= id %> <br/>
비밀번호 : <%= pw %> <br/>
취미 : <%= Arrays.toString(hobbys) %> <br/>
전공 : <%= major %> <br/>
프로토콜 : <%= protocol %>
</body>
</html>