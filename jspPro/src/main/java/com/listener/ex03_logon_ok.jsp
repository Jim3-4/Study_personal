<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id=request.getParameter("id");
String passwd=request.getParameter("passwd");

//로그인 성공가정 
session.setAttribute("member",id);

String location="/jspPro/days09/ex03.jsp"; //메인페이지 
String referer=(String)session.getAttribute("referer");
if(referer!=null){
	location=referer;
	session.removeAttribute("referer");
}

response.sendRedirect(location);
%>