<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="auth.jspf" %>
<!-- "/auth.jspf" / 안쓰는 이유는 /를 쓰면 jspPro밑에 있다는 소리이다. -->
<!-- 여기서는 같은 폴더내에 있으므로 /를 안쓰는거다. -->

<%-- 
<%
	String cname = "auth";
	String logonID = null;
	Cookies cookies = new Cookies(request);
	if(cookies.exists(cname)){
		logonID = cookies.getValue(cname);
	}
%>
 --%>
<%
   // 쿠키 삭제 : 만기시점   0  설정
   Cookie c = Cookies.createCookie("auth", "", "/" , 0);
   response.addCookie( c );

   // ex02_default.jsp 이동
%>

<script>
   alert("[<%= logonID%>]님 로그아웃 하셨습니다.")
   location.href = "ex02_default.jsp";
</script>