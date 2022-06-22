<%@ page import="com.util.Cookies" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="auth.jspf" %>
<%-- <%
String cname="auth";
String logonID=null;

Cookies cookies = new Cookies(request);
if(cookies.exists(cname)){
	  cname= cookies.getValue(cname);
}

%> --%>
<%
/* 쿠키삭제: 만기시점 0설정  
쿠키객체를 하나 생성해서  쿠키객체를 보낸다. ,*/
Cookie c=Cookies.createCookie("auth","","/",0);
response.addCookie(c);

//ex02_defualt.jsp 이동

//메인 페이지로 이동
  //response.sendRedirect("ex02_default.jsp"); 왜 이거 안쓰냐면
  //중간에 경고창을 띄우고 이동하려고 script에서 작성
%>  
<script>
alert("[<%=logonID%>]님 로그아웃되었어요");
location.href="ex02_defulat.jsp;
</script>
