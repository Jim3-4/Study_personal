<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session.invalidate();//세션강제제거 
String location="/jspPro/days09/ex03.jsp"; //메인페이지 
response.sendRedirect(location);
%>