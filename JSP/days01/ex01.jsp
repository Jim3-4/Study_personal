<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
     // 웹서버 + WAS( 톰캣 ) - jsp 페이지 안에 있는 자바 코딩-> 컴,실     
     //  JAVA_HOME   javac.exe , java.exe
     //  서버 실행
     
      // [스크립트릿]
      // 자바 코딩
      Date now = new Date();

      String pattern = "yyyy-MM-dd hh:mm:ss";
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
      String strNow=  sdf.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 14. - 오후 12:26:32</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h3>ex01.jsp - 동적 자원</h3>

<!-- 표현식 -->
<h3><%= strNow %></h3>

<%--   JSP 주석처리
[ p52  JSP 페이지의 구성 요소 ]   (문제 1)
1. 디렉티브( Directive )  == 지시자
    - JSP 페이지에 대한 설정 정보를 지정할 때 사용한다. 
    
    ㄱ. <%@ page %>   page 지시자     ***
    ㄴ. <%@ taglib %> taglib 지시자
    ㄷ. <%@ include %> include 지시자

2. 스크립트
    ㄱ.  스크립트릿(Scriptlet)   <%     %>   *** 자바코딩    - 변수 선언
    ㄴ.  표현식( Expression)    <%=  %>    ***           출력
    ㄷ. 선언문( Declaration )   <%!   %>    변수, 메서드 선언 영역
    
 3. 표현 언어( Expression Language ) == EL     출력
 
 4. 기본 객체 ( Implicit Object ) - 9가지
      ㄱ. request
      ㄴ. response
      ㄷ. session
      ㄹ. application
      ㅁ. page
      등
   5. 정적인 데이터
   6. 표준 액션 태그( Action Tag )     <jsp:태그명>
   7. 커스텀 태그( Custom Tag)        <logon></logon>
       표준 태그 라이브러리 ( JSTL )
 --%>
 
 
</body>
</html>





