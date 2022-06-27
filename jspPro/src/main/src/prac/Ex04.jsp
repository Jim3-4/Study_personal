<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String strNum = request.getParameter("num");
if(strNum==null) strNum="";
int n;

%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 19.-오후 4:17:04</title>
</head>
<body>
<h3></h3>
<script>
$(document).ready(function(){
	$("input:first").focus().select();
	$("form").submit(function(event){
		var pattrn=/^\d+$/; //처음부터 끝까지 다 숫자 
		if(pattern.test($("#num").val())){
			return;
		}else{
		$("span").text("not valid")
		.css("color","red")
		.show()
		.fadeOut(3000);
		event.preventDefault();
		}
	});
});
</script>
<form action=""> <!-- action에 안적으면 자기자신페이지 불러옴  -->
정수입력:<input type="text" id="num" name="num">
<br>
<span></span>
</form>
<%
if(strNum!=""){ 
	n= Integer.parseInt(strNum);
int sum=0;
for(int i=1; i<=n; i++){
	if(i==n){
%><%= i %><% /
}else{
%><%= i %>+<% 
	}
	sum+=i;
}//for
//out.append("="+sum);
		%>=<%=sum %><%
}	//if
%>
</body>
</html> --%>