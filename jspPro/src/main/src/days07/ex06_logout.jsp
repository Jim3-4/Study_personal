<%@ page import="com.util.Cookies" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="ex06_auth.jspf" %>

<%
//세션자동삭제 
//세션강제삭제
session.invalidate();
%>  
<script>
alert("[<%=logonID%>]님 로그아웃되었어요");
location.href="ex06_defulat.jsp;
</script>
