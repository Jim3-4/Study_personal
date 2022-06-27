<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path="ex05_finish.jsp";
RequestDispatcher dispatcher = request.getRequestDispatcher(path);
dispatcher.forward(request, response);
%>