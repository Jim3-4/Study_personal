<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오후 4:01:20</title>
</head>
<body>
<h3></h3>
<%
String name=request.getParameter("name");
String age=request.getParameter("age");
%>
<form action="ex08_02.jsp"  method="get">
name:<input type="text" name="name" value="홍길동"><br>
age:<input type="text" name="age" value="20"><br>
<input type="submit" value="next">
<input type="hidden" name="name" value="<%=name%>">
<input type="hidden" name="age" value="<%=age%>">
</form>
<script>
      <%
         Enumeration<String> en =  request.getParameterNames();
         while( en.hasMoreElements() ){
             String pname = en.nextElement();
             String pvalue = request.getParameter(pname);
        %>
        $("form").append("<input type='hidden' name='<%= pname %>' value='<%= pvalue %>'>");
        <%
         }
      %>
</script>
</body>
</html> --%>