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
<title>upload</title>
</head>
<body>

<h3>Single file</h3>
<form name="fileSingle" action="uploadSingle" method="POST" enctype="multipart/form-data">
	<input type="file" name="file"/>
	<input type="text" name="src" placeholder="업로드한 사람 이름을 작성"/>
	<input type="submit" value="single file"/>
</form>
<hr/>
<h3>Multi file</h3>
<form name="fileMulti" action="uploadMulti" method="POST" enctype="multipart/form-data">
	<input multiple="multiple"	type="file" name="file"/> <!-- 다중파일 업로드 -->
	<input type="text" name="src" placeholder="업로드한 사람 이름을 작성"/>
	<input type="submit" value="multi file"/>
</form>	
</body>
</html>