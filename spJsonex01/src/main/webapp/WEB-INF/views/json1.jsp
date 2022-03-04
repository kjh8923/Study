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
<title>json</title>
</head>
<body>

<h3>json 문자열에서 js객체 생성</h3>
<p id="demo1"></p>
<p id="demo2"></p>
<script>
//json문자열을 js의 문자열로 정의
const txt = '{"name" : "John", "age" : 30, "city" : "New York"}';
//json문자열을 js의 문자열로 정의한 변수를 parse()로 변환하면 js의 객체로 변환
const obj = JSON.parse(txt);
document.getElementById("demo1").innerHTML = obj.name + ", " + obj.age + ", " + obj.city;

const obj1 = {name : "John", age : 30, city : "New York"}; //js의 object
const myJSON = JSON.stringify(obj1); //json문자열로 변환
document.getElementById("demo2").innerHTML = myJSON;
</script>
</body>
</html>