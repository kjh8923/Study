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
<title>param 객체</title>
</head>
<body>

<h3>form의 파라메타 처리 내부 객체 param</h3>
<%
	String id = request.getParameter("id"); //form에서 보내는 name="id" 속성값(입력값)을 구함
	String pw = request.getParameter("pw");
%>

<h3>expression으로 출력</h3>
아이디 : <%= id %><br/>
비밀번호 : <%= pw %><br/>

<!-- param 내장 객체를 사용하는 방법, 이때는 EL방식 사용 가능 -->
<h3>param과 EL로 출력</h3>
아이디 : ${param.id}<br/>
비밀번호 : ${param.pw}<br/>

<!-- EL안에 사용하기 위해선 xxx.Scope 내장 객체를 사용하여 xxx객체의 값을 구함 -->
applicationScope : ${applicationScope.application_name}<br/>
sessionScope : ${sessionScope.session_name}<br/>

context 초기화 파라메타<br/>	<!-- web.xml에서 설정 -->
<!-- initParam내장 객체를 사용 -->
<h3>initParam과 EL로 출력</h3>
${initParam.con_name}<br/>
${initParam.con_id}<br/>
${initParam.con_pw}<br/>
</body>
</html>