<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 10:31:40</title>
</head>
<body>
<h3></h3>
<!-- c:forEach var="변수명" items="컬렉션, 배열 ,맵 "
c:forEach begin ="시작값" end="끝값" step="중가치" var="변수명" -->

<!-- 1+ 2+ 3+ 4+ 5+ 6+ 7+ 8+ 9+ 10+ =55 -->

<!-- 1번째방법 -->
<c:set var="sum" value="0"></c:set>
<c:forEach begin="1" end="10" step="1" var="i">
   <c:if test="${i eq 10 }">${i }</c:if>
      <c:if test="${i ne 10 }">${i }+</c:if>
<c:set var="sum" value="${sum+i }"></c:set>
 </c:forEach>
 =${sum }
 
 <hr>
 <!-- 2번째방법 -->
 <c:forEach begin="1" end="10" step="1" var="i"> 
<!--  += 문자열 연결 연산자  -->
    ${i += (i eq 10 ? "" : "+") }
    <c:set var="sum2"  value="${sum2+i }"></c:set>
<%-- 
	위에꺼랑 같은코딩 
    <c:set var="sum"  ${sum+i }> ${sum+i }</c:set> --%>
</c:forEach>
=${sum } 

<hr>
 <c:forEach begin="1" end="10" step="2" var="i" varStatus="status"> 
 <!-- 
 ${status.current} 현재 for문의 해당하는 번호
${status.index} 0부터의 순서
${status.count} 1부터의 순서
${status.first} 첫 번째인지 여부
${status.last} 마지막인지 여부
${status.begin} for문의 시작 번호
${status.end} for문의 끝 번호
${status.step} for문의 증가값
 -->
 <c:if test="${status.first}">첫번째</c:if>
  <c:if test="${status.last}">마지막</c:if>
 test-${i }:[ ${status.count}/${status.index}/${status.first}/${status.last}]<br>
 
 </c:forEach>

</body>
</html>