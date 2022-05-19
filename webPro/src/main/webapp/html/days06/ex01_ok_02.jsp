<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String cars= request.getParameter("cars");
//int deptno= Integer.parseInt(request.getParameter("deptno"));
String content1= request.getParameter("content1");
String content2= request.getParameter("content2");
%>

소유한 자동차 : <%=cars %>

하고싶은말: <%=content1 %>
<br>
길게하고싶은말: <%=content2.replace("\r\n","<br>") %>
</body>
</html>