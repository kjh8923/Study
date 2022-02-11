<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.kjh.ch23ex02.Memberinfo" scope="page"/>
<jsp:setProperty name="member" property="name" value="홍길동"/>
<jsp:setProperty name="member" property="id" value="abc"/>
<jsp:setProperty name="member" property="pw" value="12345"/>
<!-- useBean에서는 id로 set, getProperty에서는 name으로 사용 property는 데이터클래스의 멤버변수이름 -->
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
<title>EL을 getProperty대신 사용</title>
</head>
<body>

<h3>Bean을 getProperty로 출력</h3>
<hr/>
이름 : <jsp:getProperty name="member" property="name"/><br/>
아이디 : <jsp:getProperty name="member" property="id"/><br/>
비밀번호 : <jsp:getProperty name="member" property="pw"/><br/><br/>
<h3>EL로 출력</h3>
<hr/>
이름 : ${member.name}<br/>
아이디 : ${member.id}<br/>
비밀번호 : ${member.pw}<br/>
</body>
</html>