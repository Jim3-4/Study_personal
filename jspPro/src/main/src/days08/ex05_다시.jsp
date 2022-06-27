<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 10:24:32</title>
</head>
<body>
<h3></h3>
<c:set var="num">${param.num }</c:set>
<c:if test="${num % 2 eq 0 }">짝수</c:if>
<c:if test="${num % 2 ne 0 }">홀수</c:if>
</body>
</html>