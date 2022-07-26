<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>/error/error_page.jsp   p 157</h3>

 <h3><c:out value="${ exception.getMessage() }"></c:out></h3>
  
  <ul>
    <c:forEach items="${exception.getStackTrace() }" var="stack">
      <li><c:out value="${ stack }"></c:out></li>
    </c:forEach>
  </ul>

</body>
</html>