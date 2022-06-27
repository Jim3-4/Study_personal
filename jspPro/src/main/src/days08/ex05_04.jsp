<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 10:47:47</title>
</head>
<body>
<h3></h3>
<c:set var="m" value="<%=new int[] {1, 4, 5, 4, 2} %>"></c:set>

<c:forEach items="${m }" var="n" varStatus="status">
    <li>m[${status.index}] : ${n } - ${status.first}/${status.last }</li>
</c:forEach>

<hr>

<!-- c:url -->
<c:url var="url" value="ex05jsp"></c:url>
<c:redirect url="${url }">
 <!-- c:url -->
<c:url var="url" value="ex05.jsp"></c:url>
<c:redirect url="${url }">
<!--리다이렉트 될때 파라미터값을 가져가고 싶을때   -->
    <c:param name="name" value="admin"></c:param>
    <c:param name="age" value="10"></c:param>
</c:redirect>
</c:redirect>
</body>
</html>