<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 15.-오전 11:40:51</title>
</head>
<body>
<h3>ex03_ok.jsp</h3>
<%
int pn=Integer.parseInt(request.getParameter("n"));

%>
>request.getParameter("n"): <%=pn %><br>
>EL:${param.n }<br>

</body>
</html>