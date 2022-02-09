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
<title>파라메타값 forward</title>
</head>
<body>

<h3>파라메타값을 전달해주는 forward 액션태그</h3>
<jsp:forward page="forward_param.jsp">
	<jsp:param name="id" value="abcdef"/>
	<jsp:param name="pw" value="1234"/>
</jsp:forward>
<!-- jsp:forward태그가 jsp:param태그를 가지므로 종료 태그 별도 만듦 -->
<!-- 페이지 이동시 파라메타 값을 가지고 이동 -->
</body>
</html>