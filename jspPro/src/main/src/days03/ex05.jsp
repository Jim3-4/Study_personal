<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 16.-오전 10:11:59</title>
</head>
<body>
<h3></h3>
<pre>
1.리다이렉트(redirect)
2.포워딩
차이점 

ex05.jsp 에서 리다이렉트(Redirect)클릭하면, 
ex05_redirect.jsp로 이동
ex05_finish.jsp 요청 (name, age를 출력)
</pre>
<%
String name = "admin";
int age = 20;
%>

<a href="ex05_redirect.jsp">리다이렉트(Redirect)</a> <br />
<a href="ex05_forward.jsp">포워딩(Forward)</a> <br />

<script>
//name이랑 age를 가지고 넘어간다 .
    $("a").on("click", function(event) {
        $(this).attr("href", function(i, val) {
            return val + "?name=<%=name%>&age=<%=age%>";
        });
    });
</script>
</body>
</html>