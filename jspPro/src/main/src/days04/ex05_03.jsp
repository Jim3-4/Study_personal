<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 17.-오후 3:18:46</title>
</head>
<body>
<h3></h3>
<pre>
pageContext  - JSP페이지에 대한 정보 저장객체 
JSP 페이지의 기본 객체 얻어올 수 있다. -request, response ,out등등
속성처리기능 
페이지 흐름제어 
에러 데이터 구할 수 있다. 

</pre>

<%
pageContext.getRequest(); // request
pageContext.getResponse(); // response
pageContext.getSession(); // session
pageContext.getServletContext(); // application
pageContext.getServletConfig(); // config
pageContext.getOut();
%>
<%=request==pageContext.getRequest() %>
</body>
</html>