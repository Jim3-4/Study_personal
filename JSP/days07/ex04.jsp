<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오전 11:57:43</title>
</head>
<body>
<h3></h3>
<pre>
상태관리
쿠키와 다른점은 서버상태관리
인증/권한을 대부분 세션을 사용해서 상태관리
[웹 컨테이너] 는 기본적으로 하나의 웹 브라우저마다 하나의 세션 (저장공간) 을 생성
세션생성
세션제거 (종료)
더 이상 요청이 없으면 세션 제거 (일정시간 (20분 후) 지난 후)
메서드를 통해서 강제 세션 제거
예) 홍길동 SS 수강신청 / 수료

[캐비넷] + 열쇠 (암호키 세션 ID) == 세션 (정보저장)
</pre>

<%-- <%
/* 	세션 - 인증/권한/장바구니 데이터 저장 
	jsp 9가지 기본 객체 중에 HttpSession session
	session.setAttribute("" , );
	String logonID=(String)session.getAttribute("auth"); */

	String sid = session.getId();
    long ms = session.getCreationTime(); // 1970.1.1 ~ 
    long lastms = session.getLastAccessedTime();
    
%> --%>
<%
    String sid = session.getId();
    long ms = session.getCreationTime(); // 1970.1.1 ~ 
    long lastms = session.getLastAccessedTime();
%>
    session id = <%=sid%> <br />
    session CreationTime = <%=ms %>ms <br />

<%
    String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
    Date d = new Date();
    d.setTime(ms);

%>    
    session CreationTime = <%=sdf.format(d) %> <br />
<%
    d.setTime(lastms);
%>    
    session LastAccessedTime = <%=sdf.format(d) %> <br />
</body>
</html>