<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="">
<style>
</style>
<script>
   $(document).ready(function (){     
   });
</script>
</head>
<body>

<!-- 꼭 기억해야할 사항 : 모든 입력태그의 name 속성값은 자바빈즈의 필드명과 동일하게 선언 -->
<form action="ex03_04.jsp">
<table border="1" style="width:400px">
   <tr>
      <td>아이디</td>
      <td><input type="text" name="id" value="admin" /></td>
   </tr>
   <tr>
      <td>이름</td>
      <td><input type="text" name="name" value="관리자" /></td>
   </tr>
   <tr>
      <td>비밀번호</td>
      <td><input type="password" name="passwd" value="1234" /></td>
   </tr>
   <tr>
      <td>이메일</td>
      <td><input type="text" name="email" value="admin@naver.com " /></td>
   </tr> 
   <tr>
      <td colspan="2">
         <input type="submit" />
         <input type="reset" />
      </td>
   </tr>
</table>
</form>
</body>
</html>