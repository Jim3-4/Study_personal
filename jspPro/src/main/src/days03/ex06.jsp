<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오전 10:35:32</title>
</head>
<body>
<h3></h3>
<pre>
1.링크a태그선언
2.서블릿생성-get방식요청/doGet() 오버라이딩 
프로젝트 진행할때 모든 경로는 상대경로x 
jspPro 컨텍스트 패스 부터 경로 설정 

서블릿등록방법: 1)web.xml  or 2)@webServlet 어노테이션 
doGet(){
메소드 안에서 부서정보를 ArrayList 저장 
포워딩 
ex06_dept.jsp

}
</pre>
<%
String contextPath=request.getContextPath();
%>
<a href="<%=contextPath %>/scott/dept">scott.dept(부서정보)</a>

</body>
</html>