<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 12:30:14</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex05_02.jsp - JSP 4가지 영역(Scope)이해 및 활용</h3>

job : <%= pageContext.getAttribute("job") %><br>
deptno : <%= session.getAttribute("deptno") %><br>
empno : <%= request.getAttribute("empno") %><br>  <!-- 포워딩 되는게 아니므로 유지 안된다. -->
dbcp : <%= application.getAttribute("dbcp") %><br>

<br>

<pre>
1. 세션 언제 종료?
	- 웹 브라우저 종료(닫기)
	- 웹 브라우저 열기 + 요청/응답 X -> 자동 종료
	세션 20분 후에 종료된다.
	-강제 세션 종료 == session.invalidate()
2. 세션 유효 시간
	-마지막 요청/ 응답 있는 후 20분 유효 시간.
	-web.xml에서 설정 가능


</pre>

</body>
</html>