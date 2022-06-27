<%@page import="java.util.ArrayList"%>
<%@page import="days02.DeptDTO"%>
<%@page import="java.util.Iterator"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList<DeptDTO> list = (ArrayList<DeptDTO>) request.getAttribute("list");
%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오전 11:12:12</title>
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
    
    <script>
        $(function() {
            $("#selDept").wrap("<form></form>")
            .change(function(event) {
                if ($(this).val()) { //select태그 
                    $(this).parent() //select태그의 부모 =form태그 
                    .attr({ 
                        action: "<%=contextPath%>/scott/emp"
                        , method: "get"
                    })
                    .submit();
                } else {
                    alert("부서를 선택하세요~");
                }
            });
        });

    </script>
</body>
</html>