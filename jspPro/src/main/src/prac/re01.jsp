<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 19.-오후 7:49:25</title>
</head>
<body>
<h3></h3>
<script>
$(function(){
	$("form").submit(function(event){
		$(this).attr("action","http://localhost/jspPro/review");
	});
});
</script>
<div>
<form action=""  method="post">
Name:<input type="text"  id="name" name="name" autofocus="autofocus">
<br>

Age:<input type="text" id="age" name="age">
<button type="submit">전송</button>
  </form>
</div>
</body>
</html>