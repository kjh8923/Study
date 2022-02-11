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
<title>EL(Expression Language)</title>
</head>
<body>

<h3>EL 사용법</h3>
<hr/>
${10}<br/>	<!-- 10을 그 위치에 출력 -->
${99.99}<br/> 
${"ABC"}<br/>
${true}<br/>
<h3>EL에서 연산자 사용(산술, 비교, 조건, 논리)</h3>
<hr/>
${1 + 2}<br/>
${1 - 2}<br/>
${1 * 2}<br/>
${1 / 2}<br/>
${10 % 2}<br/>
${1 > 2}<br/>
${1 < 2}<br/>
${1 > 2 ? 1 : 2}<br/>	<!-- 조건 삼항 연산자 -->
${(1 > 2) || (1 < 2)}<br/>	<!-- 논리연산 -->
</body>
</html>