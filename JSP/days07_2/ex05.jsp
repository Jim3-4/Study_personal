<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 12:30:08</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex05.jsp</h3>

<%
	//4가지 Scope(영역): page,request,session,application
	//세션 부서번호 저장
	pageContext.setAttribute("job", "CLERK");  //page scope 해당 페이지에서 사용가능
	session.setAttribute("deptno",10); //session scope
	request.setAttribute("empno", 7369);
	application.setAttribute("dbcp", "oracle");

%>


job : <%= pageContext.getAttribute("job") %><br>
deptno : <%= session.getAttribute("deptno") %><br>
empno : <%= request.getAttribute("empno") %><br>  <!-- 포워딩 되는게 아니므로 유지 안된다. -->
dbcp : <%= application.getAttribute("dbcp") %><br>

<br>
<a href="ex05_02.jsp">ex05_02.jsp</a>
<!-- 
<!-- /days07/ex05.htm  --> 서블릿 호출 EX05 Session

 -->
  <br>
 <br>
 
 <a href="ex05.htm">서블릿 호출 Ex05_Session.java</a>

</body>
</html>