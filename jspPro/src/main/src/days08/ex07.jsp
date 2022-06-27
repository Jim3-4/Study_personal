<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 11:50:03</title>
</head>
<body>
<h3></h3>
<%
String msg="<b>Message</b>";
%>
  <c:set var="msg" value="<b>Message</b> 메시지 입니다."></c:set>
  <c:set var="m" value="1,2,3,4,5,6,7,8,9,10"></c:set>
  <!-- length() -->
  문자열 길이 : ${fn:length(msg) }<br>
  대문자 변환 : ${ fn:toUpperCase(msg) }<br>
  소문자 변환 : ${ fn:toLowerCase(msg) }<br>
  \${fn:substring(msg, 3,6) } : ${fn:substring(msg, 3,6) }<br>
  \${fn:replace(msg," ","-") } :  ${fn:replace(msg," ","-") } <br>
  \${fn:indexOf(msg,"메시지")} :  ${fn:indexOf(msg,"메시지")  } <br>
</body>
</html>