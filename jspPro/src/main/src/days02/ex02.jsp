<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 15.-오전 9:57:24</title>
</head>
<body>
<h3></h3>
<pre>
p498
서블릿(servlet) java언어를 사용하는 웹기술 (서블릿 jsp)
서블릿 구현 방법(과정 )
1. 서블릿 규약을 따르는 자바 클래스 선언
ㄱ. 자바 클래스의 접근 지정자: public 
ㄴ. javax.servlet.http.http.Servlet 클래스 상속 
ㄷ.  service() get() post() 오버라이딩해야 한다. 
2.  자바코드를 컴파일해서 클래스를 생성한다. 
3. 클래스파일(.class)을 [WEB-INF/classes] 폴더 넣어둬야한다. 
	-이클립스를 사용하면 자동으로 classes 폴더에 넣어둔다.
4.web.xml (DD파일) 에 서블릿 등록
5.톰캣(웹서버)실행
6 요청 URL->서블릿 응답 

3. 예제 



</pre>

<a href="http://localhost/jspPro/days01/now">days01</a>
<a href="http://localhost/jspPro/test/now">/test/now</a>
<a href="http://localhost/jspPro/test/now">/test/today</a>
<a href="http://localhost/jspPro/now.html">/now.html</a>
</body>
</html>