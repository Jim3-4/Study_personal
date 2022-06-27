<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 4:38:36</title>
</head>
<body>
<h3></h3>
<a href="ex_09_04_03.jsp?color=red&color=black&color=blue">ss</a>


요청url: <%=request.getRequestURI() %><br>
요청url: <%=request.getRequestURL() %><br>

요청url:  ${pageContext.request.requestURI }<br>
요청url:  ${pageContext.request.requestURL }<br>

<%
request.setAttribute("name", "홍길동");
request.setAttribute("age", 20);
%>
<hr>
name=${requestScope.name}
age=${requestScope.age}

<hr>

<!--내부적으로 모든영역 다 뒤져서 가져온다   -->
name=${name }
age=${age}
<hr>
<%
String color=request.getParameter("color");
%>
color=<%=color %>
color=${param.color }
</body>
</html>