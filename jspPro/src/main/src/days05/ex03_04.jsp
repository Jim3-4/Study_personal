<%@page import="java.util.Date"%>
<%@page import="days05.MemberInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2022.06.20 11:45:25</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
</head>
<body>
<h3>ex03_04.jsp</h3>
<%
   //1.파리미터 - 변수저장
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String passwd = request.getParameter("passwd");
    String email = request.getParameter("email");

%>
<jsp:useBean id="info" class="days05.MemberInfo"></jsp:useBean>
<jsp:setProperty property="id" name="info" value='<%= request.getParameter("id") %>'/>
<jsp:setProperty property="name" name="info" value='<%= request.getParameter("name") %>'/>
<jsp:setProperty property="passwd" name="info" value='<%= request.getParameter("passwd") %>'/>
<jsp:setProperty property="registerDate" name="info" value='<%= new Date() %>'/>
<jsp:setProperty property="email" name="info" value='<%= request.getParameter("email") %>'/>

<h3>MemberInfo 정보 출력</h3>
<!-- //3.자바 빈즈 정보 출력 -->
아이디: <%= info.getId() %><br>
이름: <%= info.getName() %><br>
비밀번호: <%= info.getPasswd() %><br>
등록일: <%= info.getRegisterDate() %><br>
이메일: <%= info.getEmail() %><br>





</body>
</html>