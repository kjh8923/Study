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
<title>jquery .get/.post 메서드</title>
</head>
<body>

<h3>jquery .get과 .post메서드</h3>

<button id="btn1">send an HTTP get request</button><br/><br/>
<button id="btn2">send an HTTP post request</button>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		$.get("ajaxGet", function(data,status){
			//ajaxGet은 서버로 가는 요청경로, function은 콜백 함수
			//파라메타 data는 서버에서 전달된 데이터, status는 상태정보
			alert("Data : " + data + "\nStatus : " + status);
		});
	});
	$("#btn2").click(function(){
		$.post("ajaxPost", { //객체형으로 서버에 보내는 데이터
			name : "Donald Duck", 
			city : "Duckburg"
		}, function(data,status){ //콜백함수
			alert("Data : " + data + "\nStatus : " + status); //data는 서버 응답값
		});
	});
});
</script>
</body>
</html>