<%@page import="days02.DeptDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 10:06:16</title>
</head>
<body>
<h3></h3>
<%
DeptDTO dto=new DeptDTO(10,"QC","SEOUL");
%>
<%-- <c:set var="dto2"  value="${dto}"></c:set> --%>
<c:set var="dto2"  value="<%=dto %>"></c:set>
deptno: ${dto2.deptno }<br>
dname:${dto2.dname }<br>
loc:${dto2.loc }<br>

<!-- deptno10->50 수정  -->
<!-- target => 대상의  property=>속성을 value=>로 바꾸겟다 .
target: 프로퍼티 값을 설정할 대상 객체 지정 
자바빈, 맵, 표현식, el
property: 설정할 프로퍼티의 이름 지정 
 -->
 <hr>
<c:set target="${dto2}" property="deptno" value="50"></c:set>
deptno: ${dto2.deptno }<br>
dname:${dto2.dname }<br>
loc:${dto2.loc }<br>
</body>
</html>