<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 9:08:17</title>
</head>
<body>
<h3></h3>
<%
// ex01_02.jsp?name=hong 이렇게 넘어오도록 
String pname=null;


try{
	pname=request.getParameter("name").toUpperCase(); //대문자변환
}catch(Exception e){
	e.printStackTrace();
	pname="guest";
}
%>
>name= <%=pname%><br>

</body>
</html>