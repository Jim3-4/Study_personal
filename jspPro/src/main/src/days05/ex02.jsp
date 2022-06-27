<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 20.-오전 9:43:14</title>
</head>
<body>
<h3></h3>
<pre>
p155 Chapter 07 페이지 모듈화와 요청 흐름 제어 

1.jsp 접두사 jsp액션태그 
jsp: include ,액션태그 포함한다 

공통영역부분 top left footer 
중복제거하기위해서 별도의 top.jsp left.jsp footer.jsp 
jsp:include 액션태그를 사용해서 각각의 웹페이지를 추가 

모든 웹페이지에 공통적인 부분 top, bottom
webapp/layout/ top.jsp , bottom.jsp
webapp/days05/layout/left.jsp , right.jsp

ex02_template.jsp
2.지시자 
page 지시자 
taglib 지시자 
include 지시자

******jsp:include와 include 지시자의 차이점 이해=>사용  

 3.jsp:forword 액션태그 

 4.기본객체를 이용한 값 전달(개념)-스프링 

</pre>
</body>
</html>