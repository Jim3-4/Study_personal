<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.util.Cookies"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="auth.jspf" %>
<%-- 
include.jspf 인정하는 jsp파일을 추가 
<%
//로그인(인증)한다면 쿠키이름(auth) 쿠키값(로그인id) 저장 
String cname="auth";
String logonID=null;

Cookies cookies = new Cookies(request);
if(cookies.exists(cname)){
	  cname= cookies.getValue(cname);
}

%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오전 10:13:56</title>
<style>
  div{
    border: 1px solid gray;
    width:300px;
    height:100px;
    padding:20px;
  }
</style>
<script>
   $(document).ready(function (){     
	   $("#logon span").fadeOut(5000);
   });
</script>
</head>
<body>
<h3>deault.jsp-메인페이지 </h3>
<%
if(logonID==null){ //로그인 인증x
%>
<div id="logon">
  <form action="ex02_logon.jsp">
      아이디 : <input type="text" name="id" value="admin" /><br>
    비밀번호 : <input type="password" name="passwd" value="1234" /><br>
    <input type="submit" value="로그인" />
    <input type="button" value="회원가입" /> 
      <%
     //?error 달려있다면
    String error = request.getParameter("error");
    if(error != null){
    %>
    <span style="color: red">로그인 실패했습니다.</span>
    <%
    }
     %>
  <script>
  $(function(){
	  $("#logon span").fadeOut(5000);
  });
  </script>
  </form>
</div>
<%
}else{//로그인 인증O
%>	
<div id="logout">
[]님 환영합니다. <br>
<a href="ex02_logout.jsp">로그아웃</a>
</div>

<% 
}
%>



<!-- 로그인안해도 사용가능  -->
<a href="/jspPro/cstvsboard/list.htm">게시판</a>
<a href="#">공지사항</a>

<!-- 반드시 로그인해야지만 사용가능  -->
  <a href="#">일정관리</a><br>
   <a href="#">자료실</a><br>
  
<!-- 관리자 권한이 잇어야함  -->
<%
if(logonID.equals("admin")){
%>
<a href="#">사원관리-(관리자 권한)</a><br>
<a href="#">급여관리-(관리자 권한)</a><br>
<%
}
%>


</body>
</html>