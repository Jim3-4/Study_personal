<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 11:35:04</title>
</head>
<body>
<h3></h3>
<%
   Date now = new Date();
%>

now: <%=now %><br>

<hr>
<c:set value="<%=now %>" var="now"></c:set>
<fmt:formatDate value="${now }"/>
 <fmt:formatDate value="${now }" dateStyle="default"/> <!-- 기본 --><br>
 <fmt:formatDate value="${now }" dateStyle="full"/> <br>
 <fmt:formatDate value="${now }" dateStyle="short"/> <br>
 <fmt:formatDate value="${now }" dateStyle="long"/> <br>
 <fmt:formatDate value="${now }" dateStyle="medium"/> <br>
 <hr>
  <fmt:formatDate value="${now }" type="date"/> <br>
 <fmt:formatDate value="${now }" type="time"/> <br>
 <fmt:formatDate value="${now }" type="both"/> <br>
 
  <hr />
 <fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일"/> <br>
 
 <%
 String strNow="2022년 06월 22일";
//1
 Date now2=new Date(2022-1900, 6-1, 22);
 
//2
String pattern="yyyy년 MM월 dd일";
 SimpleDateFormat sdf= new SimpleDateFormat(pattern);
 Date now3=sdf.parse(strNow);
 
//3
String pattern2="yyyy년 MM월 dd일";
DateTimeFormatter f=DateTimeFormatter.ofPattern(pattern2);
LocalDate now4=LocalDate.parse(strNow,f);

//4
 %>


</body>
</html>