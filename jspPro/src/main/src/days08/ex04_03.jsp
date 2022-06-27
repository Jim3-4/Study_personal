<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 23.-오전 10:13:25</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex04_03.jsp</h3>

<%
   Map<String, String>map = new HashMap<>();
   map.put("id","admin");
   map.put("passwd","1234");
%>

<c:set var="m" value="<%= map %>"></c:set>
<!-- Map 객체의 key를 이용해 value 출력 -->
m.id = ${ m.id }<br>
m.passwd = ${ m.passwd }<br>

<!-- map.put("name","hong") 엔트리를 맵에 추가 -->
<%-- <c:set target="<%= map %>" property="name" value="hong"></c:set> --%>
<c:set target="${ m }" property="name" value="hong"></c:set>

m.name = ${ m.name }<br>

</body>
</html>