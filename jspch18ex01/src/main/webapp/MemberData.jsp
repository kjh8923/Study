<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- java.sql 패키지에 있는 필요한 클래스들 import -->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %> 
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	//oracle driver경로
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	String query = "select * from member01"; //db에서 사용하는 sql문
%>
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
<title>Insert title here</title>
</head>
<body>

<h3>JDBC를 이용한 데이터베이스 처리</h3>
<%
	try{
		Class.forName(driver);
		//driver는 오라클드라이버클래스 경로
		//"oracle.jdbc.driver.OracleDriver"
		//Class에 있는 forName(클래스경로) 메서드는 해당 클래스를 찾아서 로드
		connection = DriverManager.getConnection(url, uid, upw);
		//url은 오라클서버 경로 "jdbc:oracle:thin:@localhost:1521:xe"
		//uid는 계정 'scott', upw는 패스워드 'tiger'
		statement = connection.createStatement();
		//sql문을 실행하는 객체
		resultSet = statement.executeQuery(query);
		//executeQuery(sql문)는 select sql문에서 사용하는 메서드 ResultSet 객체를 반환
		//executeUpdate(sql문)는 select 이외의 DML(데이터조작명령)에서 사용 정수값을 반환
		while(resultSet.next()){
			String id = resultSet.getString("id");
			//파라메터 "id"는 테이블의 컬럼명, DB의 varchar2는 String이므로 getString()으로 추출
			//만일 DB의 데이터형이 number이면 getInt()로 추출
			String pw = resultSet.getString("pw");
			String name = resultSet.getString("name");
			String phone = resultSet.getString("phone");
			
			out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br/>");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(resultSet != null)
				resultSet.close(); //종료시 객체들 close
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
%>
</body>
</html>