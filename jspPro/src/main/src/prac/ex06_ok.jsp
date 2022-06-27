<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int num;
	String output = "";
	int sum=0;
	try{
		num = Integer.parseInt(request.getParameter("num"));
		
		for(int i=1;i<=num;i++){
			output+= i==num? i : i+"+";
			sum+=i;
		}
		output+= "="+sum;
	}catch(Exception e){
		
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
	  
   });
</script>
</head>
<body>
<div id="demo"><%=output %></div>

<a href="ex06jsp">다시하기</a>
</body>
</html>