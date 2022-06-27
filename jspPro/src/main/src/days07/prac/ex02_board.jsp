<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="auth.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오전 10:14:45</title>
</head>
<body>
<h3></h3>
<a href="ex02_default.jsp">Home</a><br>
<a href="ex02_list.jsp">글목록</a><br>
<%
if(logonID!=null){
%>
<a href="#">글쓰기 </a>
<%
if(logonID.equals("admin")){
	%>
	 <a href="#">글수정</a>
    	 <a href="#">글삭제</a>
	<%}}
	%>



</body>
</html>