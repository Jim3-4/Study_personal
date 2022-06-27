<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//js쿠키삭제? 쿠키 새로 생성+만료시점 과거 
//jsp 쿠키 삭제? c.setMaxAge(-1)브라우저 종료=> 자동삭제
											//	  (0)  쿠키 바로 삭제 
	String[] del_cnames=request.getParameterValues("ckbCookie");
	for(int i=0; i<del_cnames.length; i++){
		Cookie c=new Cookie(del_cnames[i],"");
		c.setMaxAge(0); // 바로삭제
		response.addCookie(c); //쿠키객체를 웹 브라우저로 보낸다 .
	}
%>
<script>
alert("체크한 쿠키 모두 삭제 완료 ");
location.href="ex02_03.jsp";
</script>