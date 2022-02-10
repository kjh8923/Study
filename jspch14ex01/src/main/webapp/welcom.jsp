<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>로그인 성공처리 jsp</title>
</head>
<body>

<h3>로그인 성공시 설정한 세션의 이름과 값</h3>
<%
	Enumeration<String> enumeration = session.getAttributeNames(); //Enumeration은 저장된 복수개의 항목을 저장하고 이를 처리하는 메서드를 가짐
																   //getAttributeNames()메서드는 session의 이름들을 Enumeration(String)형태로 반환(반복해서 원소를 처리하는 형식의 객체)
																   //Enumeration은 찾는 원소가 더 있는지를 파악하는 메서드
																   //hasMoreElements()와 원소를 반환해주는 nextElement() 메서드를 가짐
	while(enumeration.hasMoreElements()) {
		String sName = enumeration.nextElement().toString(); //session의 이름
		String sValue = (String)session.getAttribute(sName); //이름에 해당하는 값
														     //getAttribute()는 Object를 반환하므로 문자열로 캐스팅
		if(sValue.equals("abcde")){
			out.println(sValue + "님 안녕하세요." + "<br/>"); //session에 저장한 값은 보통 id파악을 위해 사용
		}
	}
%>
<br/>
<a href="S_logout.jsp"><button type="submit" class="btn btn-primary" style="float:right">로그아웃</button></a>
</body>
</html>