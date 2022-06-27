<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8"); //post방식일때 안깨지게 
%>
<%
String name=request.getParameter("name");
String gender =request.getParameter("gender").equals("m")? "남자": "여자";
String[] pets=request.getParameterValues("pet");

%>
>name: <%=name%> <br>
>gender: ${param.gender} <br>
>favorite pet:
<%
for(int i=0; i<pets.length; i++){
%><%=pets[i]%>,<%
}
%>

<%@page import="java.util.Enumeration" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<h3>파라미터명 전부 출력</h3>
<ol>
<%
Map<String, String[]> map = request.getParameterMap();
Set<Entry<String, String[]>> set = map.entrySet();
Iterator<Entry<String, String[]>> ir = set.iterator();

while(ir.hasNext()){

	Entry<String, String[]> entry = ir.next();
	String names = entry.getKey();
	String[] values = entry.getValue();%>
	<li> <%=names %>, <%=Arrays.toString(values) %> </li> 
<%
}
%>
</ol> --%>