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
<title>Jsp expression(표현식) 태그 %=</title>
</head>
<body>

<div class="container">
	<h3>Jsp 표현식 태그</h3>
	<hr/>
	<%!
		//선언태그
		int i = 10;
		String str = "abc";
		private int sum(int a, int b){
			return a+b;
		}
	%>
	<!-- 표현식에는 종료를 나타내는 ;을 사용안함, 표현식 안에서는 java주석(//) 사용 안됨 -->
	<%= i %><br/>
	<%= str %><br/>
	<%= sum(1,5) %> <!-- 메서드 호출 시 리턴값 -->
</div>
</body>
</html>