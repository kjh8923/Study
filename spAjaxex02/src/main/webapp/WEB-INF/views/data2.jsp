<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>ajax가 받은 jsp변환 html</title>
</head>
<body>

<h3>data2.jsp입니다</h3>
<div id="tours">
	<h1>투어 가이드2</h1>
	<ul>
		<li class="usa tour">
			<h2>캐나다, 오타와</h2>
			<span class="details">100만원, 7일</span>
			<button class="book">예약하기</button>
		</li>
		<li class="europe tour">
			<h2>영국, 런던</h2>
			<span class="details">800만원, 7일</span>
			<button class="book">예약하기</button>
		</li>
		<li class="asia tour">
			<h2>한국, 서울</h2>
			<span class="details">100만원, 7일</span>
			<button class="book">예약하기</button>
		</li>
	</ul>
</div>
</body>
</html>