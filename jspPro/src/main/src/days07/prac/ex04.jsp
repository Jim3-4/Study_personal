<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 3:04:40</title>
</head>
<body>
<h3></h3>
<%
String sid=session.getId();
long ms=session.getCreationTime();
long lastms=session.getLastAccessedTime();
%>
JSESSIONID(session id) = <%= sid %><br>
session creation Time = <%= ms %>ms<br>
session last Accessed Time = <%=lastms %>ms<br>
<%
String pattern="yyyy-mm-dd HH:mm:ss";
SimpleDateFormat sdf=new SimpleDateFormat(pattern);
Date d=new Date();
d.setTime(ms);
%>
</body>
</html>