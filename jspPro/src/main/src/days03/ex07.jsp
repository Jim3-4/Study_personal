<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오후 3:07:56</title>
</head>
<body>
<h3></h3>
<pre>

</pre>
<%
String contextPath=request.getContextPath();
%>
<form method="get"  action="<%= contextPath %>/member/get">
name: <input type="text"  name="name"  value="홍길동"><br>
age: <input type="text" name="age"  value="20"><br>
<input type="submit">
</form>

<form method="get"  action="<%= contextPath %>/member/post">
name: <input type="text"  name="name"  value="홍길동"><br>
age: <input type="text" name="age"  value="20"><br>
<input type="button"  value="POST 전송">
</form>

<script>
$("form:last-of-type :button").on("click",function(){
	//입력값에 유효성  검사 한 후 전송 
	$(this).parents("form").submit();
});
</script>
</body>
</html>