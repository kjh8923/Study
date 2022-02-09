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
<title>로그인 성공시 쿠기 처리</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies(); //쿠키는 복수개가 될 수 있으므로 배열 형태로 처리
	for(int i=0; i<cookies.length; i++){ 
		String id = cookies[i].getValue(); //쿠기의 값을 원소별로 얻어냄
		out.println(id + "<br/>");
		if(id.equals("abcde")){
			out.println(id + "님 안녕하세요." + "<br/>");
		}
	}
%>

<br/>
<a href="Logout.jsp">로그아웃</a>

<script>
$(document).ready(function(){
	alert(document.cookie); //클라이언트의 쿠기는 document객체의 cookie객체에 저장되고 이름은 서버에서 생성시 만든 이름으로 저장
});
</script>
</body>
</html>