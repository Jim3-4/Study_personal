<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 3:09:38</title>
</head>
<body>
<h3></h3>
<%
pageContext.setAttribute("job", "CLERK");  //page scope 해당 페이지에서 사용가능
session.setAttribute("deptno",10);
request.setAttribute("empno",7369);
application.setAttribute("dbcp", "oracle");
%>

job:<%=pageContext.getAttribute("job") %>
deptno: <%=session.getAttribute("deptno") %>
empno:<%=request.getAttribute("empno") %>
dbcp:<%=application.getAttribute("dbcp") %>


<a href="ex05_02.jsp">ex05_02.jsp</a>
 <a href="ex05.htm">서블릿 호출 Ex05_Session.java</a>
</body>
</html>