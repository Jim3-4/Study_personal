<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 15.-오전 9:43:14</title>
</head>
<body>
<h3></h3>
<pre>
1.days01/ex05_02.jsp 문제풀이
2. <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
3. %@  page 지시자 -
contentType="text/html : jsp 페이지로  text 형식의 html문서를 생성합니다. 
charset=UTF-8 				캐릭터셋(encoding) utf-8
											기본값:ISO 8859-1 한글깨진다.  
											utf-8 또는 euc-kr 인코딩 사용 
											페이징 인코딩 사용 

pageEncoding 
3개: page , 
</pre>
스크립트릿에서와 선언문에서의 변수 선언  차이점 
<%
	 //스크립트릿 -자바 코딩 :변수, 메서드 선언
	  String pasword="java1234";
%>
<%! 
//선언문 

//변수
String id="admin";
//메소드
public int sum(int n){
	int result=0;
	for(int i=0; i<=n; i++){
		result+=i;
	}
	return result;
}
%>
표현식 

<%=sum(10) %>
</body>
</html>