<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
String fname=request.getPrameter("fname");
String lname=request.getPrameter("lname");

fname=<%= fname %><br>
lname=<%= lname %>
</body>
</html>