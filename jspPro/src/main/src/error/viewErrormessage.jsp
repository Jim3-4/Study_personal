<%@page isErrorPage="true"%> <!-- 이부분 반드시 작성  -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 9:17:48</title>
</head>
<body>
<h3></h3>
빠른시간안에 에러처리해결하겠습니다
<p>
   에러 타입: <%=exception.getClass().getName() %> <br />
    에러 메시지: <%=exception.getMessage() %> <br />
</p>
</body>
</html>