<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String pn=request.getParameter("n");
String content="";
//n파라미터가 넘어오지 않으면 null처리 
if(pn!=null){
int n= Integer.parseInt(request.getParameter("n"));
int sum=0;
for(int i=1; i<=n; i++){
	content+=(i==n ? i: i+"+");
	sum+=i;
}
content+="="+sum;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 14. - 오후 4:37:32</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h3>ex05_02.jsp</h3>

<!-- action="" 자기 자신 URL 호출 -->
<!-- 
정수를 입력하고 엔터를 치면 서브밋(서버 제출) -> ex05_02.jsp 응답
 -->
<form>
<!--  value값 상태관리  -->
  정수 입력 : <input type="text" name="n" value="<%= pn==null? "":pn%>"> 
 <br>
 <span></span>
 <p id="demo">
   <%
   if( pn != null){
	   %>
	   <%=content %>
   <% 
   }
   %>
   %>
 </p>
</form>
<script type="text/javascript">
$(function(){
	$(":text:first")
		.focus()
		.select();
	
	$("form").submit (function(){
		//숫자가 한개이상 되어야 한다. 
		var pattern=/^d+$/
		if(pattern.test($(":text:first").val())){
			return;
		}
		//$("forom>span") ==		$("span","form");
		$("span","form").text("Not Valid").css("color","red")
		.show().fadeOut(3000);
		event.preventDefault();
		//유효성 검사 실패
	});
	});
</script>
</body>
</html>