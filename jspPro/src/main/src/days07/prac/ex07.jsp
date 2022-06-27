<%@page import="days07.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 3:36:01</title>
</head>
<body>
<h3></h3>
<%
Member member=new Member("admin","관리자",20,"서울시","010-2222-3423");
session.setAttribute("user", member);
%>
세션에서 member 객체인 user를 얻어와서 출력
<%
Member user=(Member)session.getAttribute("user");
%>
id=<%=user.getId() %>
age=<%=user.getName() %>
<%-- addr=${user.adder } --%>
</body>
</html>