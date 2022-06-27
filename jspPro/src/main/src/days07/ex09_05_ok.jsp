<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="com.util.Cookies"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 9:08:00</title>
</head>
<body>
<h3></h3>
<%
Cookies cookies=new Cookies(request);
Set <Entry <String, Cookie>> set= cookies.cookieMap.entrySet();
Iterator<Entry <String ,Cookie>>ir=set.iterator();
while(ir.hasNext()){
	Entry<String, Cookie> entry =ir.next();
	String cname=entry.getKey();
	/* entry.getValue() 여기까지가 쿠키객체 가져온것   value를 가져오려면 하번더 */
	String cvalue=entry.getValue().getValue();
%>
<li><%=cname %>-<%=cvalue %></li>
<%} %>
<hr>
id: ${cookie.id.value }<br>
user: ${cookie.user.value }<br>
age: ${cookie.age.value }<br>
<hr>
<!-- entry에 키값이 쿠키이름 -->
<c:forEach items="${cookie }"  var="entry">
<!-- 변수선언 -->
<c:set value="${entry.value }" var="c"></c:set>
<li>${entry.key }-${c.value }</li>
</c:forEach>
</body>
</html>