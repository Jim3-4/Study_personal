<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 17.-오후 3:08:34</title>
</head>
<body>
<h3></h3>
<pre>
jsp 9가지 기본객체 -request, response
out 출력 스트림 

out.append()
out.print()
<%
out.flush();
%>
out.println()+"\r\n"
</pre>


버퍼크기:<%=out.getBufferSize() %> kb==buffer="8kb"<br>
<!-- 그 전의 것을 다 클리어 -->
<%
out.clearBuffer();
%>
남은버퍼크기 <%=out.getRemaining() %>
autoflash: <%=out.isAutoFlush() %>


</body>
</html>