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
<title>로그아웃시 쿠키처리</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getValue().equals("abcde")){
				cookies[i].setMaxAge(0); //쿠기제거는 setMaxAge 시간을 0으로 해주면 유효기간이 지난 것으로 처리
				response.addCookie(cookies[i]); //삭제되는 cookie를 클라이언트로 보내주어야 클라이언트에서 cookie를 삭제
			}
		}
	}
%>

<script>
$(document).ready(function(){
	alert(document.cookie); //클라이언트의 쿠기는 document객체의 cookie객체에 저장되고 이름은 서버에서 생성시 만든 이름으로 저장
							//로그아웃시는 cookie가 없어서 안보임
});
</script>
</body>
</html>