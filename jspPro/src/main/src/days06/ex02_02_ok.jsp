<%@page import="java.net.URLEncoder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//쿠키생성 
//Cookie c=new Cookie(쿠키이름,쿠키값 );
String cookieName=request.getParameter("cookieName");
String cookieValue=request.getParameter("cookieValue");

Cookie cookie=new Cookie(cookieName,URLEncoder.encode(cookieValue, "UTF-8"));

//js반드시 주의 
//jsp 반드시 주의 --쿠키값이 한글일경우 utf-8 인코딩필요 

//2. c.setDomain(domain)  localhost
//c.setPath(url)


//브라우저종료시에 쿠키를 지운다. 
//0이면 즉시 지워라 
cookie.setMaxAge(-1); 

//경로 webContent밑의 모든 요청을 쿠키값가지고 전송하겠다는 의미
cookie.setPath("/");

//쿠키에 저장해라 
response.addCookie(cookie);

//리다이렉트 
String location="ex02.jsp";
response.sendRedirect(location);
%>