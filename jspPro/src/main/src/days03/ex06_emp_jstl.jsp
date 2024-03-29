<%@page import="java.util.Iterator"%>
<%@page import="days02.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 16.-오후 12:01:04</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex06_emp</h3>

<table border="1"style="width: 100%">
<thead>


</thead>
<tbody>
<c:if test="${ empty list }">	
 <tr>
      <td colspan="5"style="height: 200px">사원이 존재하지 않습니다.</td>
   </tr>
</c:if>
<c:if test=" ${ not empty list }">
	<c:forEach items="${ list }"  var="dto">
		 <tr>
              <td>${ dto.seq }</td>
              <td>
                  <a class="title" 
                      href="<%=contextPath %>/cstvsboard/content.html?seq=${dto.seq}">
                      ${ dto.title }</a>
                      <c:if test="${dto.newmark }">
                          <img src="<%=contextPath %>/days04/board/images/ico-new.gif" alt="" />
                      </c:if>
              </td>
              <td>
                  <c:if test="${dto.writer == '홍길동' }">
                      <img src="<%=contextPath %>/days04/board/images/star.gif" alt="" />
                  </c:if>
              <a href="mailto:${dto.email }">${ dto.writer }</a></td>
              <td>${ dto.writedate }</td>
              <td>${ dto.readed }</td>
            </tr>
	</c:forEach>
</c:if> 

</tbody>
<tfoot>
        <tr>

            <td colspan="5">
                ${param.selDept}번 부서원은 총  ${ list.size() } 명 입니다.
            </td>
        </tr>
    </tfoot>
</table>
<a href="<%=contextPath%>/scott/dept">다시하기</a>



</body>
</html>