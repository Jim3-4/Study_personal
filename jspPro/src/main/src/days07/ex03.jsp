<%@page import="com.util.ConnectionProvider"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오전 10:54:13</title>
</head>
<body>
<h3></h3>
 <%
 Context initContext = new InitialContext();
 Context envContext  = (Context)initContext.lookup("java:/comp/env");
 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
 Connection conn = ds.getConnection();
 %>
 
 DBconn=<%=conn %>
 <%
 conn.close(); //커넥션 풀에 반환 (닫는거x)
 %>

 DBCP conn2=<%=ConnectionProvider.getConnection()%><br>
</body>
</html>