<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오전 9:27:49</title>
</head>
<body>
<h3></h3>
<%
//로그인성공 다시 페이지 요청 ex03.jsp?id=admin&ok
//로그인실패 						ex03.jsp?error
		String ok=request.getParameter("ok");
		String error=request.getParameter("error");
%>
<%
//ok파라미터가 붙어져있을때
//로그인 성공
//alert("로그인 성공 또는 실패 경고창")
//웹서버에서 경고창x 
if(ok != null){ 
		%><script>alert("로그인 성공")</script><%
	}else if(error!=null) { //?error가 넘어왔단 소리
		%><script>
		   alert("로그인 실패!!!");
		    $(":text").eq(0).focus().select();
		</script><%
	}//else{ }//제일 처음 페이지 요청할 떄
 %>
%>

<form action="ex03_ok.jsp" method="get">
아이디 : <input type="text" name="id" value="admin" /><br> 
비밀번호 : <input type="password" name="passwd" value="1234" /><br> 
<input type="submit" />
</form>
</body>
</html>