<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 10:31:35</title>
</head>
<body>
<h3></h3>
<div style="text-align: center;">
	<table width="600" border="1" align="center">
		<tr>
			<td colspan="3">
<!-- 			top부분이 필요하다면  include 지시자 
jsp:include로 불러오기, top부분 수정이 필요하면 top.jsp만 수정  -->
<!-- flush: 출력버퍼에 담겨있는 응답데이터를 클라이언트에게 전송하고 출력버퍼를 비우겠다. -->
				<jsp:include page="/layout/top.jsp" flush="false"></jsp:include>
			</td>
		</tr>
		
		<tr height ="300">
			<td width="150" valign="top" style="background: yellow">
				<jsp:include page="/days05/layout/left.jsp"></jsp:include>
			</td>
			<td>
			<a href="ex02_memberAdd.jsp">회원추가</a>
					회원관리 Content부분<br>
					회원관리 Content부분<br>
							회원관리 Content부분<br>
									회원관리 Content부분<br>
											회원관리 Content부분<br>
			</td>

			<td valign="top" style="background: red">
				<jsp:include page="/days05/layout/right.jsp"></jsp:include>
			</td>
		</tr>
		
		<tr>
			<td colspan="3">
			<!-- 	include액션태그로 bottom.jsp페이지를 포함하면서 
				msg파라미터를 넘겨주고 싶다면  -->
				<jsp:include page="/layout/bottom.jsp">
				<jsp:param value="hi~~~ " name="msg">
				</jsp:include>
			</td>
		</tr>
		
	</table>
</div>
</body>
</html>