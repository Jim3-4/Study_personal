<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 3:37:30</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex09_02.jsp</h3>


<%
	//JSP 4가지 영역에 저장이 되어 있어야지 EL 사용 가능
	

request.setAttribute("title", "JSP 프로그래밍");
%>


${"제목 : "+= title }<br>


<hr>

<!-- p264 세미콜론 연산자 -->
${1+1 ; 10+10}<br>
<!-- ; 뒤쪽만 계산 결과로 출력     20 나옴 -->

<hr>
<!-- p265 할당(대입) 연산자 
	변수 var1에 10값을 할당하고 var1을 출력하겠다.
-->
${var1=10 }<br>

<hr>
<!-- 연산자 우선순위가 있다. -->



</body>
</html>