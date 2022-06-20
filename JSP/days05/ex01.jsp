<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 17. - 오후 4:48:49</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/include.jspf" %>

<h3>days05/ex01.jsp</h3>

<pre>
    p 140 chapter 06 에러처리 
    1교시  쉬는 시간 (    9:55 ~ 10:15   )
    
    1. 자바에서 처럼 JSP 예외처리                              ex01_02.jsp
       try{       }catch(){}
       
    2. 웹 -> 클(응답) :     에러 페이지 응답                  ex01_03.jsp
    
    3. 상태코드(404, 500) 예외처리,   예외타입별로 예외처리..     
        ex01_04.jsp                              ex01_05.jsp
       
    
    
    [에러 페이지의 우선 순위]
    1. page 지시자 erroPage= "/error/???.jsp"
    2. 예외 타입 
    3. 에러 코드
    4. 웹 컨테이너가 제공하는 기본 에러 페이지. 
    
</pre>

</body>
</html>