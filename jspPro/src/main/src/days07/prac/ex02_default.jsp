<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="auth.jspf" %>
<%
  //auth 쿠키이름으로 id 저장 유무에 따라 인증 여부 확인
  /* 
  String auth = null;
  String cname= "auth";
  Cookies cookies = new Cookies(request);
  if(cookies.exists(cname)){
	  auth = cookies.getValue(cname);
  }
   */
   
   //위의 코딩 들을 auth.jspf  파일로 빼고 -> include 지시자를 사용해 수정
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="">
<style>
 div{
   border: 1px solid gray;
   width: 300px;
   height: 100px;
   padding: 20px;
 }
</style>
<script>
   $(document).ready(function (){     
	   $("#logon span").fadeOut(5000);
   });
</script>
</head>
<body>
 <h3>default(main) page</h3>
 
 
 <%
   if(logonID==null){
%>

 <div id="logon">
   <form action="ex02_logon.jsp">
     아이디: <input type="text" name="id" value="admin" /><br>
     비밀번호: <input type="password" name="passwd" value="1234"  /><br>
     <input type="submit" value="로그인" />
     <input type="button" value="회원가입" />
     <br>
     <%
     //?error 달려있다면
    String error = request.getParameter("error");
    if(error != null){
    %>
    <span style="color: red">로그인 실패했습니다.</span>
    <%
    }
     %>
   </form>
 </div>
<%	   
   }else{
%>
 <div id="logout">
 [<%=logonID %>]님 환영합니다.<br>
 <a href="ex02_logout.jsp">로그아웃</a>
 </div>
<%
   }
 %>
 
 <!-- 인증, 권한 따라 사용할 메뉴 처리 -->
<!--  게시판과 공지사항은 인증/권한 없이 사용 가능 -->
 <a href="ex02_board.jsp">게시판</a><br>
 <a href="ex02_notice.jsp">공지사항</a><br>
 
 <%
   if(logonID!=null){ //로그인 되어졌음 (인증O)
%>
   <a href="#">일정관리</a><br>
   <a href="#">자료실</a><br>
<%
     if(logonID.equals("관리자")){
    %>
       <a href="#">사원관리-(관리자 권한)</a><br>
       <a href="#">급여관리-(관리자 권한)</a><br>
    <%
     }
   }
 %>
</body>
</html>