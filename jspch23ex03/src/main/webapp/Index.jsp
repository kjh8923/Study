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
<title>Jsp 내부객체를 EL로 사용하기</title>
</head>
<body>

<h3>Jsp내부객체용 Form</h3>
<form action="objelok.jsp" method="POST">
	아이디 : <input type = "text" name="id"><br/>
	비밀번호 : <input type = "password" name="pw">
	<input type="submit" value="login">
</form>

<%
//각각의 객체에 이름 속성과 값을 설정
application.setAttribute("application_name", "application_value");
session.setAttribute("session_name", "session_value");
pageContext.setAttribute("page_name", "page_value");
request.setAttribute("request_name", "request_value");
%>
<hr/>
pageContextScope : ${pageScope.page_name}<br/> <!-- 다른 페이지 에서는 사용못함 -->
requestScope : ${requestScope.request_name}<br/> <!-- 다른 페이지 에서는 사용못함 -->
</body>
</html>