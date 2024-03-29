<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 17.-오후 2:45:15</title>
</head>
<body>
<h3></h3>
<pre>
JSP제공하는 기본 객체 
1: request: javax, servlet, http.[HttpServetRequest]
클라이언트의 요청 정보 저장하는 객체 
2: response:   HttpServetResponse 응답 정보를 저장하는 객체 
3.out: JspWriter jsp페이지가 생성하는 결과를 출력할때 사용하는 출력 스트림 
4.session: HttpSession HTTP 세션 정보를 저장(인증, 권한 정보 저장)
5.pageContent : PageContext JSP페이지에 대한 정보를 저장하는 객체 
6.application : ServletContext 웹사이트  전체에 대한 정보를 저장하는 객체 
​ 6. out javax.servlet.jsp.[JspWriter] : 출력 스트림 - > 버퍼
​ 7. config javax.servlet.ServletConfig : JSP페이지에 대한 설정 정보를 저장
​ 8. page java.lang.Object : JSP페이지를 구현한 자바 클래스 인스턴스
​ 9. exception java.lang.Throwable : 예외 객체 , 에러 페이지에서만 사용할 수 있다.
</pre>
</body>
</html>