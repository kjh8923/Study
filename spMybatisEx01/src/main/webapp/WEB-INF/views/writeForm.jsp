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
<title>Mybatis writeForm</title>
</head>
<body>

<!-- <h3>writeForm</h3>
<table width="500" cellpadding="0" cellspacting="0" border="1">
	<form action="write" method="post">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="mWriter" size="50"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="mContent" size="150"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력"/>&nbsp;&nbsp;
				<a href="list">목록보기</a>&nbsp;&nbsp;
				<a href="buy_ticket">Ticket Transaction</a>
			</td>
		</tr>
	</form>
</table> -->


<div class="container">
	<h3>게시판 입력 form</h3>
	<hr/>
	<form action="write" method="POST">
		<div class="input-group mb-3 input-group-sm">	<!-- input과 도움말을 묶는 클래스, input-group-sm/lg 도움말 사이즈 -->
			<div class="input-group-prepend">	<!-- 도움말 위치 표시 클래스 -->
				<span class="input-group-text">이름</span> <!-- 도움말 내용 표시 클래스 -->
			</div>
			<input type="text" class="form-control" placeholder="Username" id="usr" name="mWriter"/>
		</div>
		<div class="input-group mb-3 input-group-sm">	<!-- input과 도움말을 묶는 클래스, input-group-sm/lg 도움말 사이즈 -->
			<div class="input-group-prepend">	<!-- 도움말 위치 표시 클래스 -->
				<span class="input-group-text">내용</span> <!-- 도움말 내용 표시 클래스 -->
			</div>
			<textarea class="form-control" placeholder="Content" rows="10" cols="30" name="mContent" style="height : 350px;"></textarea>
		</div>
		<a href="buy_ticket">
			<button type="button" class="btn btn-secondary" style="float: right;">
				Ticket Transaction
			</button>
		</a>	
		<a href="list">
			<button type="button" class="btn btn-success" style="float: right;">
				목록보기
			</button>
			<button type="submit" class="btn btn-primary" style="float: right;">
				입력
			</button>
		</a>

	</form>
</div>
</body>
</html>