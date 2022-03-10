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
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>  <!-- 페이지 위조요청 방지를 위한 태그 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>회원가입창</title>
</head>
<body>

<div id="main" class="container mt-5">
	<!-- 회원가입 form -->
	<h3 class="text-center text-danger">회원가입</h3>
	<form action="join" method="post" id="frm1" name="frm1">
		<!-- csrf 방지 위해 헤더 부분을 숨겨서 추가 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="form-group">
			<label for="uId">아이디</label>
			<input type="email" class="form-control" name="pid" placeholder="E-mail주소 입력" id="uId" required/>	<!-- required : 필수사항 -->
		</div>
		<div class="form-group">
			<label for="uPw">비밀번호</label>
			<input type="password" class="form-control" name="ppw" id="uPw" placeholder="비밀번호 입력" required/>
		</div>
		<div class="form-group">
			<label for="uAddress">주소</label>
			<input type="text" class="form-control" name="paddress" id="uAddress" placeholder="주소 입력" required/>
		</div>
		<div class="form-group">
			<label for="uHobby">취미</label>
			<input type="text" class="form-control" name="phobby" id="uHobby" placeholder="취미 입력" required/>
		</div>
		<div class="form-group">
			<label for="uProfile">내용</label>
			<textarea class="form-control" name="pprofile" id="uProfile" rows="10" placeholder="자기소개를 작성하세요" required></textarea>
		</div>
		<button type="submit" class="btn btn-success">회원가입</button>&nbsp;&nbsp;
		<button type="reset" class="btn btn-danger">취소</button>		
	</form>
</div>

<script>
$(document).ready(function(){
	$("#frm1").submit(function(event){
		event.preventDefault(); //원래 form의 기능인 submit를 ajax로 처리
		$.ajax({
			type : $("#frm1").attr("method"),
			url : $("#frm1").attr("action"),
			data : $("#frm1").serialize(),
			success : function(data){	//모달창을 이용하여 가입결과를 출력
				if(data.search("join-success") > -1){
					$(".modal-body").text("회원가입을 축하합니다.");
					//$("#modalBtn")[0].click(); //자동클릭
					$("#modalBtn").trigger("click"); //자동클릭
					$("#closeBtn").click(function(event){
						event.preventDefault();
						location.href="login_view"; //페이지 이동
					});
				}
				else{
					$(".modal-body").text("동일한 아이디가 존재합니다");
					//$("#modalBtn")[0].click();
					$("#modalBtn").trigger("click");
				}			
			},
			error : function(){
				$(".modal-body").text("동일한 아이디가 존재합니다");
				//$("#modalBtn")[0].click();
				$("#modalBtn").trigger("click");
			}
		});
	});
});	
</script>
</body>
</html>