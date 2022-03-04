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
<title>load.jsp</title>
</head>
<body>

<div id="div1">
	<h2>Let jQuery AJAX change this text</h2>
</div>
<button id="btn1">Get External Content</button><br/><br/>
<button id="btn2">Get External Content(id로 지정)</button><br/><br/>
<button id="btn3">callback 처리</button>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		$("#div1").load("txt/demo_test.txt");
		//서버의 txt/demo_text.txt를 가져와 #div1엘리먼트 내용에 출력(로딩)
	});
	$("#btn2").click(function(){
		$("#div1").load("txt/demo_test.txt #p1");
		//서버의 txt/demo_text.txt에서 id="p1"인 것만 가져와 #div1엘리먼트 내용에 출력(로딩)
	});
	$("#btn3").click(function(){
		$("#div1").load("txt/demo_test.txt", function(responseTxt, statusTxt, xhr){
			if(statusTxt == "success")
				alert("External content loaded successfully!");
			if(statusTxt == "error")
				alert("Error: " + xhr.status + ": " + xhr.statusText);
		});
	});
});
</script>
</body>
</html>