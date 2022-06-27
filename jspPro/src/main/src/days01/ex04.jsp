<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 14. - 오후 3:31:25</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h3>ex04.jsp - 시험2</h3>
<!-- 
    1+2+3+4+5+6+7+8+9+10=55
    js
    jsp
 -->
 <%
     // HTTP 상태 500 – 내부 서버 오류  jsp 코딩 X
     // 스크립트릿 - 자바코딩
     int sum = 0;
     for(int i=1 ; i<=10 ; i++){
    	 // cmd 출력 : System.out.printf("%d+", i);
    	 // 서버 -> 클라이언트 출력 전송
    	 // JSP 제공하는 기본 객체 중에 하나 :   out 객체 - 출력
    	 // out.append( i +  "+");
    	 out.print(i);
    	 if( i  != 10 ){
  %>+<%	     		 
    	 } 
    	 sum += i;
     } // for
 %>=<%= sum %>
 
</body>
</html>










