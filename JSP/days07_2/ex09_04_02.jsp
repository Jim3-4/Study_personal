<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 4:39:12</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex09_04_02.jsp</h3>

요청 URI:<%= request.getRequestURI() %><br>
요청 URL:<%= request.getRequestURL() %><br>

<hr />
요청 URI : ${ pageContext.request.requestURI } <br>
요청 URL : ${ pageContext.request.requestURL } <br>


<!-- 그냥 request 객체는 없다. 그래서 기본 객체인 pageContext를 사용해서 request객체를 불러온다.  -->





<hr />
<%

	request.setAttribute("name", "홍킬동");
	session.setAttribute("age", 20);
	
%>
name = ${requestScope.name }<br>
age = ${requestScope.age }<br>
<hr>
내부목적으로 모든 영역(scope) 다 뒤져서 가져온다.

name = ${name }<br>
name = ${age }<br>

<hr>

<%
	String color = request.getParameter("color");
%>
color = <%= color %><br>
color = ${ param.color }<br>

<hr>

<a href="ex09_04_03.jsp?color=red&color=black&color=blue">ex09_04_03.jsp</a>




</body>
</html>