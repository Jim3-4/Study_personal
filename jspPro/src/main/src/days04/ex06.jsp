<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 17.-오후 4:27:43</title>
</head>
<body>
<h3></h3>
<pre>
웹 어플리케이션의 4가지의 영역(scope)

1. page scope - 하나의 JSP 페이지에서만 사용할 수 있는 영역             (pageContext 기본 객체)
2. request scope - 하나의 요청[request]에서만 사용할 수 있는 영역      (request 기본 객체)
3. session scope - 하나의 웹 브라우저에서 사용할 수 있는 영역            (session 기본 객체)
4. application scope - 웹 어플리케이션(웹사이트) 영역                     (application 기본 객체)

setAttribute()
getAttribute()
removeAttribute()
getAttributenames() - 모든 속성 목록 얻어오기 (pageContext 제공x)
</pre>
</body>
</html>