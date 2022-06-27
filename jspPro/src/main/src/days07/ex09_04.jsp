<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 4:28:45</title>
</head>
<body>
<h3></h3>
<pre>
p254 표11.1 EL 기본객체 11가지 
  8. EL에서 사용할 기본 객체                    JSP 기본 객체  
      1) pageContext                       /        pageContext
      2) key/value [Map 객체]
          pageScope
          requestScope                     /        request .setAttribute()
          sessionScope                     /        session
          applicationScope                /        application
          
      3) param                              /       request .getParameter()
      4) paramValues                     /       request .getParameterValues()
      5) cookie 								/  			request.getCookies()
      6) initParam                          /       application .getInitParameter()
      7) header                             /       request .getHeader()
      8) headerValues                    /      request .getHeaderValues()

 ${initParam.debugLevel }

 ex09_04_02.jsp
</pre>
</body>
</html>