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
<title>list.jsp</title>
</head>
<body>

<div class="container">
<h3 class="text-center text-danger">게시판 List</h3>
	<table class="table table-bordered table-hover">
		<thead class="thead-dark">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody> <!-- 게시판 리스트 부분으로 반복하여 출력 -->
			<!-- request객체의 속성은 el에서 바로 사용, 원래는 request.getAttribute("list") -->
			<c:forEach items="${ list }" var="dto">
				<tr>
					<td>${ dto.bId }</td>
					<td>${ dto.bName }</td>
					<td>
						<!-- 제목에 댓글 갯수를 --으로 표시하고 제목 클릭시 이 게시판 라인의 게시판 번호를 이용하여 db에서 해당 게시판번호 내용을 가져오는 것으로 처리  -->
						<c:forEach begin="1" end="${ dto.bIndent }">-</c:forEach>
						<a href="content_view.do?bId=${ dto.bId }">${ dto.bTitle }</a>
					</td>
					<td>${ dto.bDate }</td>
					<td>${ dto.bHit }</td>
				</tr>
			</c:forEach>	
		</tbody>
		<tfoot class="table-secondary">
			<tr>
				<td colspan="5">
					<a href="writeFormView.do">
						<button type="submit" class="btn btn-primary" style="float: right;">
							작성하기
						</button>
					</a>
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>