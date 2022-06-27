<%@page import="days07.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 2:40:28</title>
</head>
<body>
<h3></h3>
<%
Member member=new Member("admin","관리자",20,"서울시","010-333-2222");
session.setAttribute("user",member);

%></body>
<%
Member user=(Member)session.getAttribute("user");
%>
id=<%=user.getId() %><br>
name=<%=user.getName() %><br>
<!-- el안에서 세션에 있는 user 객체를 바로 사용할 수 있다 . -->
<%-- age=${ user.age }<br>
addr=${ user.addr }
tel=${ user.tel } --%>
</html>