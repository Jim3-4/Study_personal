<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/sample/">p127/sample/*</a>
<a href="/sample/basic">p127/sample/basic->basicGet()</a>
<a href="/sample/ex01?name=admin&age=30">p130/sample/ex01-></a>

<form action="/sample/ex02List" method="get">
  <input type="checkbox" name="ids" value="111" checked="checked">111<br>
  <input type="checkbox" name="ids" value="222" checked="checked">222<br>
  <input type="checkbox" name="ids" value="333">333<br>
  <input type="checkbox" name="ids" value="444" checked="checked">444<br>
  <input type="submit">
</form>
<br>

<form action="/sample/ex02Bean" method="get">
  <input type="text" name="list[0].name" value="hong" ><br>
  <input type="text" name="list[0].age" value="20" ><br>
  <input type="text" name="list[1].name" value="admin"><br>
  <input type="text" name="list[1].age" value="40""><br>
  <input type="submit">
</form>
<br>

<!-- 제목, 날짜 전송 -->
<form action="/sample/ex03" method="get">
  <input type="text" name="title" value="title" ><br>
  <input type="date" name="dueDate" value="20" ><br> 
  <input type="submit">
</form>
<br> 

<a href="/sample/ex04?name=hong&age=20&page=15">p.140/sample/ex04?name=hong&age=20&page=15</a>
<br> 
<a href="/sample/ex06">p.147 /sample/ex06</a><br>
<br>

<a href="/sample/ex07">p.148 /sample/ex07</a><br>
<br>

<a href="/sample/exUpload">p.150 /sample/exUpload</a><br>
<br>

<a href="/sample/ex04?name=hong&age=test&page=15">p.157/sample/ex04?name=hong&age=20&page=15</a>
<br> 

<a href="/sample/ex404">p.159/sample/ex404</a>
<br>   
</body>
</html>
