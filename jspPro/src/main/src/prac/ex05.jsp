<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String output ="";
String operator="+" ;
int num1=0, num2=0;
try{
	num1 = Integer.parseInt(request.getParameter("n1"));
	num2 = Integer.parseInt(request.getParameter("n2"));
	operator = request.getParameter("op");
	double result = 0;
	
	switch(operator){
	case "+" : result = num1+num2; break;
	case "-" : result = num1-num2; break;
	case "*" : result = num1*num2; break;
	case "/" : result = num1/num2; break;
	}
	
	output = String.format("%d%s%d=%.2f", num1,operator,num2, result);
}catch(Exception e){
	System.out.println(e.toString());
}
%>

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
	   
	   $(":text").eq(1).on("keyup", function(event) {
	   	if(event.keyCode==13){
	   		$("form").submit();
	   	}
	   })//keyup
	   
	   //jquert select option selected 설정하는 코딩
	   $("#op").val("<%=operator%>");
	   
   });//ready
</script>
</head>
<body>
<!--
       ㄱ. 마지막으로  n2 입력 후  엔터 치면 
       ㄴ. 상태가 유지 되면서
       ㄷ. p 태그의 연산 결과 출력.
-->
<form method="get">
  <input type="text" id="n1" name="n1"  autofocus value="${param.n1}"/> <!-- 0이 아니라 공백 -->
  <select id="op" name="op">
 <option>+</option>
 <option>-</option>
 <option>*</option>
 <option>/</option>
  </select>
  <input type="text" id="n2" name="n2" value="${param.n2 }" />
</form>

<p id="demo"> <%=output %></p>

<a href="ex_05.jsp?name=admin&age=20">a태그</a>
</body>
</html>