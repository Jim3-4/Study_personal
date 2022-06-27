<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@page import="java.time.LocalDateTime" %> 
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Date now=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
String strDate=sdf.format(now);

int age=20;
String today=getNow();
%>
<%! //변수 선언문=> 변수, 메소드 
String name="홍길동";
public String getNow(){
	return LocalDateTime.now().toString();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 19.-오전 10:59:34</title>
</head>
<body>
<h3></h3>

날짜(now):<input type="text" value="<%=now.toLocaleString()%>"><br>
이름(name):<input type="name"  value="<%=name %>"><br>
나이:<input type="age" value="<%=age %>"><br>
날짜:<input type="date" value="<%=strDate%>"><br>
날짜:<input type="date" value="<%=today%>"><br>
날짜(today) : <span><%=today%></span><br>
<script>
$(document).ready(function(){
	
});
</script>
 </body>
</html>