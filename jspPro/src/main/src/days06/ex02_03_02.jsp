<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 21.-오후 4:49:56</title>
</head>
<body>
<h3></h3>
<form>
<%
String cname, cvalue;
Cookie[] cookies=request.getCookies();
for(Cookie c: cookies){
	cname=c.getName();
	cvalue=URLDecoder.decode(c.getValue(),"UTF-8");
%>
<input type="checkbox" name="chkbox"  value="<%=cname %>"><%=cname %><%=cvalue %>
<% }%>

</form>
</body>
</html>