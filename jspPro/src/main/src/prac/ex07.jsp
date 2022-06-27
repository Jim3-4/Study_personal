+<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 12:17:03</title>
</head>
<body>
<h3></h3>
 <form action="ex07_ok.jsp" method="post">
 이름: <input type="text" name="name" value="김동준"/><br>
 성별: <input type="radio" name="gender" value="m" checked> 남자 
		<input type="radio" name="gender" value="w"> 여자
 		<br>
 좋아하는 동물 : <input type="checkbox" name="pet" value="puppy"/>강아지
 					<input type="checkbox" name="pet" value="pig"/>도새기
					<input type="checkbox" name="pet" value="cat"/>고양이
 
 <input type="submit" />
 </form>
</body>
</html>