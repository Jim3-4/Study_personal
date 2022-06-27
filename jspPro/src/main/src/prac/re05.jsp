<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 12:42:05</title>
</head>
<body>
<h3></h3>
<form action="re05_ok.jsp">
아이디: <input type="text"  id="id" name="id" value="jay"><br>
비밀번호 :<input type="text" id="pwd" name="pwd"  value="12345">
<input type="submit">
</form>
<%
String ok=request.getParameter("ok");
String error=request.getParameter("error");
%>
ok=<%=ok %><br>
error=<%=error %><br>

<%
if(ok!=null)%> <script>alert("로그인성공");</script><%
%><% else if(error!=null){
%><script>alert("로그인실패");</script><%
}else{}%>
</body>
</html>