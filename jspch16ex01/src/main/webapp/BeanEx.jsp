<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="com.kjh.ch16ex01.Student" scope="page"/> 
<!-- id는 bean이름, class는 데이터클래스 경로, scope는 범주 -->
<!-- 즉, Student 클래스를 student bean으로 사용 -->
<jsp:useBean id="people" class="com.kjh.ch16ex01.People" scope="page"/>    
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
<title>bean관련 액션태그 사용</title>
</head>
<body>

<div class="container">
	<h3>bean관련 액션태그 사용</h3>
	<hr/>
	<!-- bean클래스의 속성들을 설정(set) -->
	<!-- 내부적으로는 Bean클래스 해당 setter메서드를 호출 -->
	<!-- name속성에 bean id, property는 bean클래스의 속성 이름, value에는 값을 작성 -->
	<!-- jsp에서 값은 모두 문자열로 처리 -->
	<jsp:setProperty name="student" property="name" value="홍길동"/>
	<jsp:setProperty name="student" property="age" value="13"/>	<!-- 13은 클래스에서는 int형, 하지만 여기선 문자열로 처리 -->
	<jsp:setProperty name="student" property="grade" value="6"/>
	<jsp:setProperty name="student" property="studentNum" value="7"/>
	
	<!-- bean클래스의 속성값을 반환(get)하여 그 위치에 문자열로 출력 -->
	<h2>이름 : <jsp:getProperty name="student" property="name"/></h2>
	나이 : <jsp:getProperty name="student" property="age"/><br/>
	학년 : <jsp:getProperty name="student" property="grade"/><br/>
	번호 : <jsp:getProperty name="student" property="studentNum"/>
</div>
<br/><br/>
<div class="container">
	<jsp:setProperty property="name" name="people" value="김아무개"/>
	<jsp:setProperty property="id" name="people" value="KIM"/>
	<jsp:setProperty property="address" name="people" value="서울 강서구 화곡동"/>
	<jsp:setProperty property="age" name="people" value="32"/>
	
	이름 : <jsp:getProperty property="name" name="people"/><br/>
	id : <jsp:getProperty property="id" name="people"/><br/>
	주소 : <jsp:getProperty property="address" name="people"/><br/>
	나이 : <jsp:getProperty property="age" name="people"/><br/>
	
	<jsp:setProperty property="name" name="people" value="박아무개"/>
	<jsp:setProperty property="id" name="people" value="PARK"/>
	<jsp:setProperty property="address" name="people" value="서울 강서구 등촌동"/>
	<jsp:setProperty property="age" name="people" value="22"/>
	
	이름 : <jsp:getProperty property="name" name="people"/><br/>
	id : <jsp:getProperty property="id" name="people"/><br/>
	주소 : <jsp:getProperty property="address" name="people"/><br/>
	나이 : <jsp:getProperty property="age" name="people"/><br/>
</div>
</body>
</html>