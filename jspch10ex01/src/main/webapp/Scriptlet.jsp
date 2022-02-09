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
<title>Jsp scriptlet</title>
</head>
<body>

<div class="container">
	<h3>구구단 2단</h3>
	<hr/>
	<%
		int i=0;
		while(true){
			i++;
			out.println("2 x " + i + " = " + (2*i) + "<br/>");
			//out은 Printwriter 객체로 jsp제공 내부 객체
	%>
	=======<br/> <!-- scriptlet을 작성 중간에 자바 코드가 아닌 문장 등이 나오면 스크립트릿은 분할 사용할 수 있다 -->
	<%
		if(i>8){
			break;
		}
	}
	%>
</div>
<br/><br/>
<div class="container">
	<h3>구구단</h3>
	<hr/>
	<%
		for(int a=2; a<10; a++){
			out.println(a + "단을 출력합니다." + "<br/>");
			for(int b=1; b<10; b++){
				out.println(a + "x" + b + " = " + (b*a) + "<br/>");
			}
		}
	%>
</div>	
</body>
</html>