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
//스크립트릿- 자바코딩 
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
%>
name=<%= name %>
age= <%= age %>
</body>
</html>