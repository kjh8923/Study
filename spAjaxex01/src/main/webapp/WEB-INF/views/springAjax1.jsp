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
<title>Spring + Ajax</title>
</head>
<body>

<button id="btn1">js객체값을 만들어서 서버로 보내기</button>
<div id="result">이곳에다 서버로부터 온 결과를 출력</div>
<br/>
<h4>form에서 서버로 submit하기 위한 form</h4>
<form action="formact" id="frm1" name="frm1" method="POST">
	name : <input type="text" name="name"/><br/>
	age : <input type="text" name="age"/><br/>
	<input type="submit" value="call"/>
</form>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		//서버로 보낼 데이터는 js객체형 변수로 만들어 사용
		let form = {
			name : "jamong",
			age : 23
		};
		
		$.ajax({
			url : "requestObject", //서버요청경로
			type : "POST", //method방식
			data : form, //서버로 보낼 데이터
			success : function(data){ //여기의 파라메터 data는 서버에서 받은 데이터 
				$("#result").text(data);
			},
			error : function(){
				alert("버튼클릭시 에러 발생");
			}
		});
	});
	
	//form의 submit를 클릭시 처리
	//submit이벤트는 form의 이벤트이므로 form을 선택
	//form의 submit시는 원래 브라우저에서 제공하는 서버 전송 기능을 사용
	$("#frm1").submit(function(event){
		//JS에서 submit를 가로채서 사용하므로 원래 기능을 비활성화
		event.preventDefault();
		$.ajax({
			url : $("#frm1").attr("action"), //시작태그의 action속성값을 반환
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(), //form의 입력값을 문자열로 직렬화
			success : function(data){ //여기의 파라메터 data는 서버에서 받은 데이터 
				$("#result").text(data);
			},
			error : function(){
				alert("form submit시 에러 발생");
			}
		});
	});
});
</script>
</body>
</html>