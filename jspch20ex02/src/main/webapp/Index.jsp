<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%!
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
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
<title>Prepared</title>
</head>
<body>

<h3>PreparedStatement클래스 사용</h3>
<%
	try{
		Class.forName(driver);
		connection = DriverManager.getConnection(url, uid, upw);
		int n = 0; //db에서 sql처리 후 받는 값(select 아닌 경우)
		String query = "insert into member01 (id, pw, name, phone) values (?, ?, ?, ?)";
		//preparedStatement에서 사용하는 query문에는 값이 들어갈 자리를 ?으로 처리
		preparedStatement = connection.prepareStatement(query);
		//query문을 포함하고 있는 sql 실행문으로 ?에 set메서드로 값을 넣어줌
		//preparedStatement 객체의 setDataType(?순서번호, "값") 메서드로 값을 넣어줌, ex - setString(1, "aaaa");
		//set메서드는 db의 데이터형이 varchar2나 char로 문자열이면 setString(순서, 값), number이면 setInt(순서, 값)
		//순서는 1부터 시작하며 ?의 순서
		preparedStatement.setString(1, "006"); //id
		preparedStatement.setString(2, "123"); //pw
		preparedStatement.setString(3, "홍길동"); //name
		preparedStatement.setString(4, "010-1234-4567"); //phone
		//sql이 insert이므로 executeUpdate()메서드를 사용
		n = preparedStatement.executeUpdate();
		
		preparedStatement.setString(1, "007"); //id
		preparedStatement.setString(2, "234"); //pw
		preparedStatement.setString(3, "이순신"); //name
		preparedStatement.setString(4, "010-5564-2107"); //phone
		//sql이 insert이므로 executeUpdate()메서드를 사용
		n = preparedStatement.executeUpdate();
		
		preparedStatement.setString(1, "008"); //id
		preparedStatement.setString(2, "658"); //pw
		preparedStatement.setString(3, "장영실"); //name
		preparedStatement.setString(4, "010-7826-3485"); //phone
		//sql이 insert이므로 executeUpdate()메서드를 사용
		n = preparedStatement.executeUpdate();
		
		if(n==1)
			out.println("intsert success");
		else
			out.println("intsert fali");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(preparedStatement != null)
				preparedStatement.close(); //종료시 객체들 close
			if(connection != null)
				connection.close();
			if(resultSet != null)
				resultSet.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
%>

<div class="container">
	<h3>수직배치 form</h3>
	<form action="#" method="POST">
		<div class="form-group">
			<!-- form-group클래스는 수직배치시 입력요소간 여유 확보 -->
			<!-- label과 입력요소 input을 수용 -->
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="eamil"/>
			<!-- 입력요소에는 form-control 클래스를 추가(100%너비) -->
		</div>
		<div class="form-group">
			<!-- form-group클래스는 수직배치시 입력요소간 여유 확보 -->
			<!-- label과 입력요소 input을 수용 -->
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" id="pwd" placeholder="Enter pswd" name="pswd"/>
			<!-- 입력요소에는 form-control 클래스를 추가(100%너비) -->
		</div>
		<!-- checkbox는 from-check, form-check-label, form-check-input 클래스 사용 -->
		<div class="form-group form-check">
			<label class="form-check-label">
				<input class="form-check-input" type="checkbox" name="remember">Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">
			Submit
		</button>
		<!-- button은 from-control을 사용안하고 인라인으로 사용 -->
	</form>
</div>
</body>
</html>