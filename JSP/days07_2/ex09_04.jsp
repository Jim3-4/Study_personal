<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 4:27:46</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex09_04.jsp</h3>


<pre>
[JSP 기본 객체 9가지]

p254 표 1.1 [EL 기본객체]
								JSP 기본 객체
1.pageContext    				== page
2. pageScope 					==pageContext.setAttribute("deptno",10)
   requestScope					==request.setAttribute("empno",7369)
   sessionScope					==session.setAttribute("ename","SMITH")
   applictionScope

***3.param   					==requestgetParameter("age")
   param.age
4. ?name=kenik&name=hong&name=admin
	paramValues			== 		request.getParameterValues("name");
	paramValues.name
5. header    ==    requset.getHeader()
6. headerValues ==  request.getHeaderValues();
7. cookie 	   == request.getCookies()
	Map 객체 = key,value
				쿠키이름, 쿠키 객체(Cookie)
8.initParam == application.getInitParameter()
[web.xml]
<!-- 
<context-param>
  		<description>디버깅 레벨</description>
  		<param-name>debugLevel</param-name>
  		<param-value>3</param-value>
  	</context-param>
 -->
	${initParam.debugLevel}

</pre>

</body>
</html>