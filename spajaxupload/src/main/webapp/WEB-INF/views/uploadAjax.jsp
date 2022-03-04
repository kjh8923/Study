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
<title>upload Ajax처리</title>
</head>
<body>

<h3>Ajax upload</h3>
<form action="file" id="frm" enctype="multipart/form-data" method="POST">
	<input multiple="multiple" type="file" id="images" name="images">
</form>

<button id="btn1">file</button>
<div id="result">결과 출력</div>

<script>
$(document).ready(function(){
	$("#btn1").on('click', function(){
		let form = new FormData($('#frm')[0]); //form에서 입력한 데이터를 ajax로 보내기 위한 형태로 반환하는 생성자(업로드시 사용)
		$.ajax({
			url : "file",
			type : "POST",
			data : form,
			contentType : false, //upload시에 입력 필수
			processData : false, //upload시에 입력 필수
			success : function(data){
				for(let i=0; i<data.length; i++){
					$('#result').append(data[i] + '<br>');
				}
			},
			error : function(){
				alert("file err");
			}
		});
	});
});
</script>
</body>
</html>