<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오전 11:57:53</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex04.jsp</h3>
<pre>
1.세션(Session) p232 Chapter10 클라이언트와의 대화 : 세션

	-상태 유지(관리)
	-쿠키와 다른 점 : 서버에 저장
	-클라이언트(웹브라우저) -> 요청 하나의 세션 저장 공간을 생성
		A
		B
		C
		예) 교육원 -> 수강 신청/결제
		홍길동				[저장공간 캐비넷] == 세션
		전우치				[저장공간 캐비넷]
		우투리				[저장공간 캐비넷]
		등등
					강제 탈락
					강제 세션 종료
	2.세션 언제 생성? 하나의 웹 브라우저 -> 처음 요청[세션 == 캐비넷]
														비밀번호/열쇠
													  J[SESSION]ID
					FF4C55DAE28CF6CDE22F958853755EA2
					
	//브라우저에서 요청하면 캐비넷(세션)이 하나 생성된다.												  
	
</pre>

<%
	//세션(session) 인증/권한/장바구니 데이타 저장
	//JSP 9가지 기본 객체 중에
	//ssession.setAttribute("auth","admin");
	//String logonID = (String)session.getAttribute("auth");
	
	String sid = session.getId();
	long ms = session.getCreationTime();		//1970.1.1 00:00:00~
	long lastms = session.getLastAccessedTime();

%>

JSESSIONID(session id) = <%= sid %><br>
session creation Time = <%= ms %>ms<br>
session last Accessed Time = <%=lastms %>ms<br>

<%
	String pattern ="yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	Date d = new Date();
	d.setTime(ms);
%>

session creation Time = <%= d %>ms<br>

</body>
</html>