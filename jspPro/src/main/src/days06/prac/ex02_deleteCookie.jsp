<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//js 쿠키 삭제 : 쿠키 생성 + 만료시점(-10)을 과거로 설정해서 
	
	//서버에서 쿠키 삭제 : 개념 똑같다 
	//		쿠키 생성 + getMaxAge(0)
	
	
	//?ckbCookie=id&ckbCookie=age
	String [] delete_cnames = request.getParameterValues("ckbCookie");
	for(int i=0; i<delete_cnames.length;i++){
		String cname= delete_cnames[i];
		Cookie cookie = new Cookie(cname, "");
		cookie.setPath("/");
		cookie.setMaxAge(0); // 쿠키삭제 -1(브라우저 닫으면 자동 삭제)
		
		response.addCookie(cookie);
	}
%>
<script>
	alert("체크한 모든 쿠키 삭제 완료");
	location.href="ex02_getCookie.jsp"; //sendRedirect와 똑같음
</script>