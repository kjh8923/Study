<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>게시판 입력 from</title>
</head>
<body>
<div class="container">
	<h3>게시판 입력 form</h3>
	<hr/>
	<form action="write.do" method="POST">
		<div class="input-group mb-3 input-group-sm">	<!-- input과 도움말을 묶는 클래스, input-group-sm/lg 도움말 사이즈 -->
			<div class="input-group-prepend">	<!-- 도움말 위치 표시 클래스 -->
				<span class="input-group-text">이름</span> <!-- 도움말 내용 표시 클래스 -->
			</div>
			<input type="text" class="form-control" placeholder="Username" id="usr" name="bName"/>
		</div>
		<div class="input-group mb-3 input-group-sm">	<!-- input과 도움말을 묶는 클래스, input-group-sm/lg 도움말 사이즈 -->
			<div class="input-group-prepend">	<!-- 도움말 위치 표시 클래스 -->
				<span class="input-group-text">제목</span> <!-- 도움말 내용 표시 클래스 -->
			</div>
			<input type="text" class="form-control" placeholder="Title" id="tit" name="bTitle"/>
		</div>
		<div class="input-group mb-3 input-group-sm">	<!-- input과 도움말을 묶는 클래스, input-group-sm/lg 도움말 사이즈 -->
			<div class="input-group-prepend">	<!-- 도움말 위치 표시 클래스 -->
				<span class="input-group-text">내용</span> <!-- 도움말 내용 표시 클래스 -->
			</div>
			<textarea class="form-control" placeholder="Content" row="10" cols="30" name="bContent" style="height : 350px;"></textarea>
		</div>
		<a href="list.do">
			<button type="button" class="btn btn-success" style="float: right;">
				목록보기
			</button>
		</a>
		<button type="submit" class="btn btn-primary" style="float: right;">
			입력
		</button>
	</form>
</div>
</body>
</html>