<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="auth.jspf" %>
<%
/* 
 String auth = null;
 String cname= "auth";
 Cookies cookies = new Cookies(request);
 if(cookies.exists(cname)){
   auth = cookies.getValue(cname);
 }
  */
 //auth 쿠키 제거
 int expiry = 0;
 Cookie cookie = cookies.createCookie(cname, "", "/", expiry);
  //cookie.setMaxAge(0);
  response.addCookie(cookie);
  
  //메인 페이지로 이동
  //response.sendRedirect("ex02_default.jsp"); 왜 이거 안쓰냐면
  //중간에 경고창을 띄우고 이동하려고 script에서 작성
%>
<script>
  alert("[<%=logonID%>]님 로그아웃 되었습니다.");
  location.href="ex02_default.jsp";
</script>