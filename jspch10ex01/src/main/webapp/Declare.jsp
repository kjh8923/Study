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
<title>Jsp 선언 태그</title>
</head>
<body>

<div class="container">
	<h3>jsp 선언 태그</h3>
	<hr/>
	<!-- 선언 태그는 %!태그이다 -->
	<%!
		//변수 선언
		int i = 10; //변수 선언(선언태그 안에서 선언된 변수는 전역변수)
		String str = "ABCDE";
	%>
	<%!
		//메서드 선언
		public int sum(int a, int b){
			return a+b;
		}
	%>
	<!-- 하나의 선언태그에 만들어도 무방하며 스그립트릿으로 만들어도 된다 -->
	<%
		//scriptlet으로 변수 및 메서드 사용
		out.println("i = " + i + "<br/>"); //변수 출력
		out.println("str = " + str + "<br/>");
		out.println("sum = " + sum(1,5)); //메서드 호출
	%>
</div>
</body>
</html>