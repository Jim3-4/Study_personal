<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 19.-오후 7:36:29</title>
</head>
<body>
<h3></h3>
<div id="tab-1">
정수입력: <input type="text" name="num"  id="num"  value="10">
<br>
<a href="/jspPro/prac/ex06_ok.jsp" id="link">here</a>
</div>
<script>
$(function(){
	$("#link").on("click",function(){
		$(this).attr("href",function(){
			return val+"?num="+$("num").val();
		});
	});
});
</script>
</body>
</html>