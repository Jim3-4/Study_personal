<%@page import="java.text.DecimalFormat"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 23.-오전 3:55:55</title>
</head>
<body>
<h3></h3>
<%
long price=22345;
request.setAttribute("price",price);
%>
price=<%=price %><br>
price=${price }
단가를 세 자리마다 콤마를 찍어서 출력...
price=<%=String.format("%,d",price) %><br>
<%
DecimalFormat df=new DecimalFormat("###,###");
String str=df.format(price);
%>


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
price=<%=str %><br>

price = <fmt:formatNumber value="${price }"pattern="#,###"></fmt:formatNumber><br>
</body>
</html>