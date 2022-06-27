<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 8:26:56</title>
</head>
<body>
<h3></h3>
<form action="">
  <%
    //서버에서 쿠키값을 읽어오는 방법: 
    //1. 모든 쿠키 객체를 얻어온다. Cookies 클래스[]  - request.getCookies() 메소드 존재
    String cname;
    String cvalue;
  
    Cookie[] cookies = request.getCookies();
	  for(Cookie cookie : cookies){
	   cname = cookie.getName();
	   cvalue = URLDecoder.decode( cookie.getValue(),"UTF-8");
	   
	  
%>
	<input type="checkbox" name="ckbCookie" value="<%=cname %>" /><%=cname %>-<%=cvalue %>
	<br>
<%
 	 }
  %>
</form>
<a href="ex02_deleteCookie.jsp" id="delLink"> 쿠키삭제  </a>
<a href="ex02_editCookie.jsp" id="editLink"> 쿠키수정  </a>
<a href="ex02.jsp">home</a>
<script>
$("#delLink, #editLink").click(function(event){
	event.preventDefualt();
	var queryString =$("form").serialize();
	 //직렬화 : 코딩으로 할 작업을 자동으로 input태그의 value 값들을 &연산자로 만들어줌
	location.href=$(this).attr("href")+"?"queryString;
});
</script>
</body>
</html>