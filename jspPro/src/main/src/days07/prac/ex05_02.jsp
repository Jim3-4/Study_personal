<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 3:19:22</title>
</head>
<body>
<h3></h3>job : <%= pageContext.getAttribute("job") %><br>
deptno : <%= session.getAttribute("deptno") %><br>
empno : <%= request.getAttribute("empno") %><br>  <!-- 포워딩 되는게 아니므로 유지 안된다. -->
dbcp : <%= application.getAttribute("dbcp") %><br>
</body>
</html>