<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 9:40:43</title>
</head>
<body>
<h3></h3>
<pre>
변수지원 - c:set c:remove
흐름제어 - c:forEach c:if c:choose
URL 처리 - c:url c:redirect
출력태그 - c:out
데이터베이스 - sql:
XML 태그 - xml:
국제화
지역
메시지 - fmt:
숫자, 날짜형식
함수 - fn:

c:set :el 변수의 프로퍼티(속성) 값을 지정할때 사용
c:set var="변수명" value="값" scope=""
</pre>
<%
String name="김길동";
request.setAttribute("xxx", name);
%>
<%-- <c:set var="fullname"  value="<%=name %>"></c:set> --%>
<c:set var="fullname"  value="${xxx}"></c:set>
fullname=${fullname };
<c:remove var="fullname">
>fullname=${fullname }
</c:remove>
<%-- <c:set var="fullname"  value="${name}"></c:set> --%>
</body>
</html>