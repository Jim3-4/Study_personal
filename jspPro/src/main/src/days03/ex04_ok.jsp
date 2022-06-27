<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String id=request.getParameter("id");
String passwd=request.getParameter("passwd");
//DB 회원테이블 id /passwd 로그인 성공, 실패 
String location="ex04.jsp";
if(id.equals("admin")&&passwd.equals("1234")){
	String pid;
	location += "?id=admin&ok";
}else{
	  location += "?error";
}
response.sendRedirect(location);
%>