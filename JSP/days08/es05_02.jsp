<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 10:26:19</title>
</head>
<body>
<h3></h3>
<!--1번째방법 -->
<c:set value="${param.kor }" var="kor"></c:set>
<c:if test="${kor >=90 && kor<=100 }">수</c:if>
<c:if test="${kor >=90 && kor<=90 }">우</c:if>
<c:if test="${kor >=90 && kor<=80}">미</c:if>
<c:if test="${kor >=90 && kor<=70}">양</c:if>
<c:if test="${kor >=90 && kor<=100 }">가</c:if>



<c:choose>
    <c:when test="${kor >=90 && kor<=100 }">수</c:when>
    <c:when test="${kor ge 80 and kor lt 90 }">우</c:when>
    <c:when test="">미</c:when>
    <c:when test="">양</c:when>
    <c:otherwise>가</c:otherwise>
</c:choose>
</body>
</html>