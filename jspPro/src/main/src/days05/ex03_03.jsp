<%@page import="java.util.Date"%>
<%@page import="days05.MemberInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="">
<style>
</style>
<script>
   $(document).ready(function (){     
   });
</script>
</head>
<body>

<%
	String id = request.getParameter("id");	
	String name = request.getParameter("name");	
	String passwd = request.getParameter("passwd");		
	String email = request.getParameter("email");	

	MemberInfo info = new MemberInfo();
	info.setId(id);
	info.setName(name);
	info.setPasswd(passwd);
	info.setRegisterDate(new Date()); //등록일은 받아오지 않고 현재로
	info.setEmail(email);
%>

<h3>멤버 정보 출력</h3>
아이디 : <%=info.getId() %><br>
이름 : <%=info.getName() %><br>
비밀번호 : <%=info.getPasswd() %><br>
등록일 : <%=info.getRegisterDate() %><br>
이메일 : <%=info.getEmail() %><br>
</body>
</html>