<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 9:33:51</title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/myoracle">
SELECT deptno, dname, loc 
from dept
</sql:query>
<c:forEach items="${rs.rows}" var="dto">
<li>${dto.detpno }-${dto.loc }</li>
</c:forEach>
<h3></h3>
</body>
</html>