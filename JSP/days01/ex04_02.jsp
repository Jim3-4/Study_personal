<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 14. - 오후 3:51:34</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h3>ex04_02.jsp</h3>

<%  // 스크립트릿  : 서버에서  실행 스크립트
       // ex04_02.jsp   Jasper 컴파일 ->  ex04_02.java -> ex04_02.class 
      int sum = 0;
      for( int i = 1 ; i <= 10 ;  i++){
    	  // out.append( i +"" );
%>
<%= i %>
<%    	  
    	  if( i != 10 ){
    	      //out.append( "+");
%>
+
<%    	      
    	  } // if
    	  sum += i;
      } // for
      //out.append("=" + sum);
%>
=<%= sum %>

<%--  1. 
<%
      int sum = 0;
      for( int i = 1 ; i <= 10 ;  i++){
    	  out.append( i +"" );
    	  if( i != 10 ){
    	      out.append( "+");
    	  } // if
    	  sum += i;
      } // for
      out.append("=" + sum);
%>
 --%>
</body>
</html>