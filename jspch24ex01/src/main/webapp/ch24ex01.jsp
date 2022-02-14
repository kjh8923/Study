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
<title>JSTL CORE</title>
</head>
<body>

<h3>JSTL CORE LIB</h3>
<hr/>
<h4>c:set</h4>
<c:set var="varName" value="varValue"></c:set> <!-- var은 변수명, value는 변수 값, 시작과 종료태그는 필수 -->

<h4>출력</h4>
<c:out value="${varName}"></c:out> <!-- value속성은 출력할 값을 나타내며 값은 EL을 사용하여 표시 -->

<h4>변수제거</h4>
<c:remove var="varName"/> <!-- var에 제거할 변수명 -->

<p>제거 후 출력</p>
varName : <c:out value="${varName}"></c:out>

<br/><br/>

<h4>예외 처리</h4>
<c:catch var="error"><%= 2/0 %></c:catch> <!-- var은 예외내용 저장변수이고 내용부분에 예외 발생 가능문 작성 -->
<p>예외내용 : <c:out value="${ error }"></c:out></p>

<br/><br/>

<h4>if처리 태그</h4>
<!-- if문의 조건처리는 관계연산이나 논리연산으로 처리 하므로 EL의 연산처리를 사용 -->
<!-- 결과가 true이면 내용으로 들어가고(즉 자바나 js의 {}) false이면 못들어감 -->
<c:if test="${ 1+2==3 }"> 1 + 2 = 3 </c:if>
<hr/>
<c:if test="${ 1+2!=3 }"> 1 + 2 != 3 </c:if> <!-- false여서 내용으로 못들어가 출력 안됨 -->

<br/><br/>

<h4>다중 조건 처리(if~else if~else 또는 switch)</h4>
<c:set var="name" value="홍길동"/>
<c:choose>
	<c:when test="${ name eq '철수' }">철수 입니다.</c:when> <%-- else if --%>
	<c:when test="${ name eq '홍길동' }">홍길동 입니다.</c:when>
	<c:otherwise>사람이 없습니다.</c:otherwise> <%-- else --%>
</c:choose>
<hr/>
<c:choose>
	<c:when test="${ empty param.name }"> <%-- empty는 EL의 비어있음 확인 연산자, 비어있으면 true(반대는 not empty) --%>
										  <%-- param은 form 파라메타를 처리하는 jsp내부 객체 --%>
	<form>
	이름 : <input type="text" name="name">
		  <input type="submit" value="확인">
	</form>
	</c:when>
	<c:when test="${ param.name == 'admin' }">
		관리자 작업
	</c:when>
	<c:when test="${ param.name eq 'user' }">
		일반 사용자. 회원 <c:out value="${ param.name }"/>
	</c:when>
	<c:otherwise>
		기타 작업
	</c:otherwise>
</c:choose>

<br/><br/>

<h4>반복처리 forEach 태그</h4>
<!-- 배열이나 반복 가능한 객체를 나타내는 items속성이 없이 forEach사용 -->
<!-- 이때 var은 자바나 js의 반복변수 i처럼 사용 -->
<c:forEach var="fEach" begin="0" end="30" step="3">
	${ fEach }&nbsp;
</c:forEach>
<hr/>
<!-- 배열 선언 -->
<c:set var="arr" value="<%= new int[] {1,2,3,4,5} %>"></c:set>
<!-- items 속성은 배열객체의 값, var 속성은 배열객체의 원소를 나타내는 변수 -->
<c:forEach items="${ arr }" var="i">
	${ i }&nbsp;
</c:forEach>

<br/><br/>

<h4>페이지 이동(_self로 이동)</h4>
<c:redirect url="http://www.naver.com">
	Naver
</c:redirect>
</body>
</html>