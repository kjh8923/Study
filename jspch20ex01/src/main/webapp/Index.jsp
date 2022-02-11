<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kjh.ch20ex01.MemberDAO" %>
<%@ page import = "com.kjh.ch20ex01.DbcpDAO" %>
<%@ page import = "com.kjh.ch20ex01.MemberDTO" %>
<%@ page import = "java.util.*" %>
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
<title>DAO, DTO의 index파일</title>
</head>
<body>

<h3>DAO, DTO클래스 사용</h3>
<hr/>
<%
	//MemberDAO memberDAO = new MemberDAO();
	DbcpDAO dbcpDAO = new DbcpDAO();
	//ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
	ArrayList<MemberDTO> dtos = dbcpDAO.memberSelect();
	for(int i=0; i<dtos.size(); i++){ //ArrayList의 크기는 size()메서드 사용
		MemberDTO dto = dtos.get(i); //ArrayList의 원소를 반환하는 메서드는 get(index)
		//MemberDTO클래스의 get 메서드를 이용하여 멤버변수값을 구함
		String name = dto.getName();
		String id = dto.getId();
		String pw = dto.getPw();
		String phone = dto.getPhone();
		
		out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br/>");
	}
%>
</body>
</html>