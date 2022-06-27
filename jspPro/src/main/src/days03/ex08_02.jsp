<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오후 4:01:28</title>
</head>
<body>
<h3></h3>
<form action="ex08_03.jsp"  method="get">
address:<input type="text" name="address" value="서울 역삼동"><br>
tel:<input type="text" name="tel" value="010-2222-2222"><br>
<input type="button" value="Prev"  onclick="history.back()">
<input type="submit" value="next">

</form>
</body>
</html>