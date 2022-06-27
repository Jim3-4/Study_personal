<%@page import="com.util.Cookies"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

   //member 컬렉션
   HashMap<String, String> member = new HashMap<>();
   member.put("admin","1234"); //관리자 권한
   member.put("hong","1234");   //일반 권한
   member.put("park","1234");    //일반 권한
   
   //위가 db라고 가정 (시간관계상)
   String id = request.getParameter("id");
   String passwd = request.getParameter("passwd"); 
   
   if(id.equals("admin")&&passwd.equals("1234")){
	   Cookie cookie = Cookies.createCookie("auth", "관리자", "/", -1);
	   response.addCookie(cookie); 
	   response.sendRedirect("ex02_default.jsp");
   }else if(id.equals("hong")&&passwd.equals("1234")){
	   Cookie cookie = Cookies.createCookie("auth", id, "/", -1);
	   response.addCookie(cookie); 
	   response.sendRedirect("ex02_default.jsp");
   }else if(id.equals("park")&&passwd.equals("1234")){
	   Cookie cookie = Cookies.createCookie("auth", id, "/", -1);
	   response.addCookie(cookie); 
	   response.sendRedirect("ex02_default.jsp");
   }else{
	   response.sendRedirect("ex02_default.jsp?error");
   }
   
%>