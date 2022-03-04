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
<title>ajax로 jsp파일 받아 처리</title>
</head>
<body>

<h3>ajax.jsp페이지</h3>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Logo</a>
	<!-- Link -->
	<ul class="navbar-nav">
		<li class="nav-item">
			<a id="a1" class="nav-link" href="#">Link1</a>
		</li>
		<li class="nav-item">
			<a id="a2" class="nav-link" href="#">Link2</a>
		</li>
		<!-- Dropdown -->
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				Dropdown link
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Link1</a>
				<a class="dropdown-item" href="#">Link2</a>
				<a class="dropdown-item" href="#">Link3</a>
			</div>
		</li>
	</ul>
</nav>
<div id="content">서버에서 온 내용 표시 할 위치</div>

<script>
$(document).ready(function(){
	$("#a1").click(function(e){
		e.preventDefault(); //브라우저 제공 a의 링크 기능을 비활성화, ajax 방식으로 보내겠다
		$.ajax({
			url : "data",
			type : "POST",
			data : "",
			dataType : "html", //return 데이터 형식으로 jsp가 변환된 파일
			success : function(data){
				$("#content").html(data);
			},
			error : function(){
				alert("fail");
			},
			complete : function(){
				console.log("always");
			}
		});
	});
	
	$("#a2").click(function(e){
		e.preventDefault(); //브라우저 제공 a의 링크 기능을 비활성화, ajax 방식으로 보내겠다
		$.ajax({
			url : "data2",
			type : "POST",
			data : "",
			dataType : "html", //return 데이터 형식으로 jsp가 변환된 파일
			success : function(data){
				$("#content").html(data);
			},
			error : function(){
				alert("fail");
			},
			complete : function(){
				console.log("always");
			}
		});
	});
});
</script>
</body>
</html>