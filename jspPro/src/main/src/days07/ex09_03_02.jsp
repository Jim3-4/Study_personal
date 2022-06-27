<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="days07.FormatUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 4:07:59</title>
</head>
<body>
<h3></h3>
<pre>

</pre>
<%
long price=22345;
/* request.setAttribute("price", price); */

%>

<!-- jstl 변수선언 -->
<!-- 변수명이 price 값이 value   -->
<c:set var="price" value="<%=price %>"> </c:set>
FormatUtil.staticNumber() price=${ FormatUtil.staticNumber(price,"#,##0")} <br>
<%
//객체생성
FormatUtil fu=new FormatUtil();
//객체를 저장을 해야지, 저 밖에서 사용할 수 있다. 
request.setAttribute("f", fu);
%>
FormatUtil.staticNumber() price=${ f.Number(price,"#,##0")} <br>
</body>
</html>