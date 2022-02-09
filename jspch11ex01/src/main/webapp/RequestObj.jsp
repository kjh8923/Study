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
<title>request객체의 정보관련 메서드</title>
</head>
<body>

<div class="container">
	<h3>request객체의 메서드들</h3>
	<hr/>
	<%
		out.println("서버 : " + request.getServerName() + "<br/>"); //localhost
		out.println("포트 번호 : " + request.getServerPort() + "<br/>"); //8181
		out.println("요청 방식 : " + request.getMethod() + "<br/>"); //GET, POST
		out.println("프로토콜 : " + request.getProtocol() + "<br/>"); //HTTP/1.1
		out.println("URL : " + request.getRequestURL() + "<br/>"); //hrrp://localhost:8181/jspch11ex01/requestobj.jsp로 URL은 전체 경로
		out.println("URI : " + request.getRequestURI() + "<br/>"); //port번호 이후 경로
		out.println("Query : " + request.getQueryString() + "<br/>");
	%>
</div>
</body>
</html>