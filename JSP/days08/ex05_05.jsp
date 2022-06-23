<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 11:05:55</title>
</head>
<body>
<h3></h3>
<pre>

</pre>
<%
    FileReader fr = null;

    try {
        String path = "days08/ex01.jsp";
        String realPath = request.getRealPath(path);

        fr = new FileReader(realPath);
%>
    <pre>
        실제배포경로 = <%=realPath %> <br />
        <c:out value="<%=fr %>" escapeXml="true"></c:out>
    </pre>
<%
    } catch (Exception e) {
%>
    에러: <%=e.getMessage() %>
<%        
    } finally {
        if (fr != null) {
            try { fr.close(); } catch (IOException ex) {}
        }
    }
%>
<c:catch var="ex">
</c:catch>

<c:if test="${ex != null }">
    ${ex }
</c:if>
</body>
</html>