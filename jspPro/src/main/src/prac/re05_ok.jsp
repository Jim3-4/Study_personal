<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
String location="re05.jsp";

if(id.equals("jay")&&pwd.equals("12345")){
	location+="?id=jay&ok";
}else{
	location+="?error";
}
response.sendRedirect(location);
%>