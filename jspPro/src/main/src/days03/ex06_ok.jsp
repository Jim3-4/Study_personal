<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="days02.DeptDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오전 10:45:30</title>
</head>
<body>
<h3></h3>
   <select id="selDept" name="selDept">
        <option >선택...</option>
        <%
        Iterator<DeptDTO> ir = list.iterator();
        while (ir.hasNext()) {
            DeptDTO dto = ir.next();
        %>
        <option value="<%=dto.getDeptno()%>"><%=dto.getDname()%></option>
        <%
        }
        %>
    </select>
</body>
</html> --%>