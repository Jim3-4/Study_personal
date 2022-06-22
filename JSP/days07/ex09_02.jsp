<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 3:37:23</title>
</head>
<body>
<h3></h3>
<%
request.setAttribute("title", "jsp");
%>

${"제목:"+=title }<br>
<hr>
<!-- p264 세미콜론 연산자  -->
<!-- ${A; B}  B값만 출력된다 C는 안됨-->
${1+1 ; 10+10; }

<!-- 할당대입연산자 
var1에 값을 할당하고 var1출력하겠다.  -->


${var1=10}
</body>
</html>