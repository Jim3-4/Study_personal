<%@page import="com.util.ConnectionProvider"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오전 11:08:24</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex03.jsp</h3>

<pre>
	***1.커넥션 풀(pool)  p415***
	
	JSP 요청 + DB 연동 처리 + Connection 객체 생성, 닫기 + 동시 접속자 많다면
										성능 떨어진다.
	응답이 늦어진다.
	
	=>커넥션 풀 사용
	
	역삼역 + 자차 (술) + 대리기사
				[대리기사, 대리기사, 대리기사, 대리기사, 대리기사, 대리기사] 기법 ==커넥션 풀 기법
					
	
	ㄱ.DBCP를 이용한 커넥션 풀 사용하는 방법
		http://commons.apache.org/
		
	***ㄴ. 톰캣(WAS)를 이용한 커넥션 풀 사용하는 방법***
		1)tomcat-dbcp.jar 파일을 찾아서 WEB-INF/lib 폴더 복사 붙이기
		2)커넥션 풀 초기화 설정
	
<!-- 	p423 참조
	<?xml version="1.0" encoding="UTF-8"?>
 <Context>
 <Resource 
 	name="jdbc/myoracle" 
 	auth="Container"
    type="javax.sql.DataSource" 
    driverClassName="oracle.jdbc.OracleDriver"
    url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
    username="scott" 
    password="tiger" 
    maxTotal="20" 			커넥션 풀 안에 최대 생성할 수 있는 커넥션 객체의 수
    maxIdle="10"			커넥션 풀이 보관할 수 있는 최대 유휴 객체 수
    						(==대기하고 있는 커넥션 객체수)
    						(요청안해도 일안하는 커넥션 객체 10개는 만들어 놓겠다.)
    						(동시 10명이 접속해도 대응할 수 있게)
    						
	maxWaitMillis="-1"/>
</Context>
	 -->
	 
	 ㄷ. web.xml 추가
<!-- 	 <resource-ref>
		 <description>Oracle Datasource example</description>
		 <res-ref-name>jdbc/myoracle</res-ref-name>
		 <res-type>javax.sql.DataSource</res-type>
		 <res-auth>Container</res-auth>
	 </resource-ref> -->
	 
	 ㄹ.com.util.클래스.java - DBCP 커넥션객체 반환하는 메서드
	
	2.세션(Session) p232 Chapter10 클라이언트와의 대화 : 세션
	3.JSTL
	4.EL
	5.MVC

</pre>

<%
/* 커넥션 객체를 가져오는 부분 */
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
Connection conn = ds.getConnection();

%>

DBCP conn = <%= conn %><br>

<%
	conn.close();  //자동으로 커넥션 풀 반환
%>

DBCP conn2 = <%= ConnectionProvider.getConnection() %><br>

</body>
</html>