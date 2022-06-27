<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 22.-오후 3:19:09</title>
</head>
<body>
<h3>ex09.jsp</h3>
<pre>
[EL 자료형 /리터럴 ]
1.boolean -true, false 
정수: long 형으로 잡힌다.
실수: double 로 잡힌다.
문자열: 쌍따옴표 혹은 홑따옴표로 감싸야한다.
널

</pre>
<pre>
${true }
${-10 }
${3.14 }
${"홍길동" }
${null}
${"홍\"길동" }
${'홍\'길동'}

수치 
${3+5}<br> 
${3-5}<br> 
${3*5}<br> 
${3/5}==${3 div 5 }<br> 
${3%5}==${3 mod 5 }<br> 

==eq 
!= ne
< lt
> gt
<= le
>= ge

</pre>
<pre>
논리 연산자 
&& and 
|| or
! not
</pre>
<pre>
***empty 연산자 ***
</pre>
${empty "" }<br>
${empty null}<br>
</body>
</html>