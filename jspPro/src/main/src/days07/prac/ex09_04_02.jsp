<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 4:13:03</title>
</head>
<body>
<h3></h3>
요청urI: <%=request.getRequestURI() %><br>
요청 url: <%= request.getRequestURL()%>

요청urI: ${pageContext.request.requestURI }
urL: ${pageContext.request.requestURL  }

<%
request.setAttribute("name", "ghd");
session.setAttribute("age",20);
%>
name=${requestScope.name }
age=${requestScope.age }
name=${name }
age=${age }
</body>
</html>