<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 21.-오후 4:49:56</title>
</head>
<body>
<h3></h3>
<form>
<%
//요청할때 
//전달된 모든 쿠키들을 배열형태로 얻어옴 



String cname, cvalue;
Cookie[] cookies=request.getCookies();
for(Cookie c:cookies){
cname=c.getName();
cvalue=URLDecoder.decode(c.getValue(),"UTF-8");
%>
<input type="checkbox" name="chbCookie" value="<%=cname %>" ><%=cname %>-<%=cvalue %><br>
<% 
}
%>
</form>
<br>
<!-- 체크박스를 체크 후 쿠키 삭제 링크 태그를 클릭하면 value 속성값=쿠키이름 
ex02_04.jsp?ckbCookie=name&ckbCookie=age -->
<a href="ex02_04.jsp">쿠키 삭제</a>
<a href="ex02_05.jsp">쿠키 수정 </a>
<a href="ex02.jsp">쿠키 Home</a>
<script>
$("a").on("click",function(event){
	event.preventDefualt();
	//체크된 체크박스 얻어와서 value 속성값을 얻어와야지 
	location.href=$(this).attr("href");
	
	//꼭 기억
	var queryString = $("form").serialize(); 
    //직렬화 : 코딩으로 할 작업을 자동으로 input태그의 value 값들을 &연산자로 만들어줌
	//alert(queryString); 
	location.href=$(this).attr("href")+"?"+queryString;
});
</script>
</body>
</html>