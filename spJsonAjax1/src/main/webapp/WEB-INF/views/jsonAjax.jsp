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
<title>jsonAjax</title>
</head>
<body>

<h3>json으로 Ajax 주고 받기</h3>
<button id="btn1">Stringify</button>
<div id="result">결과 출력창</div>
<script>
$(document).ready(function(){
	$("#btn1").on('click', function(){
		let form = { //js의 object
			name : "jamong",
			age : 23
		};
		$.ajax({
			url : "stringify",
			type : "POST",
			data : JSON.stringify(form), //json문자열 형태로 보냄
			contentType : "application/json; charset=utf-8;",
			dataType : "json", //반환데이터형
			success : function(data){
				let txt = data.name + data.age;
				$('#result').text(txt);
			},
			error : function(){
				alert("stringify err");
			}
		});
	});
});
</script>
</body>
</html>