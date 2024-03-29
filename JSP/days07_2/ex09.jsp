<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22.-오후 3:19:22</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex09.jsp</h3>

<pre>
[EL 자료형/리터럴] p253
1.boolean    - true,false
2.정수 -     -10
3.실수 - 	 3.14				=>java.lang.Double
4.문자열  -   " "   ' '


</pre>

${ true }<br>
${ -10 }<br>
${ 3.14 }<br>
${ "홍\"길동"}<br>
${ '홍\'길동'}<br>
${null }<br>


<pre>
	[EL 연산자]
	1.수치 연산자 + - * / %
						div mod
						
</pre>
${3 + 5}<br>
${3 - 5}<br>
${3 * 5}<br>
${3 / 5} ==  ${ 3 div 5 }<br>
${3 % 5} == ${ 3 mod 5  }<br>



<pre>
	[EL 연산자]
	2. 비교 연산자
	 == eq
	 != ne
	 < lt
	 > gt
	 <= le
	 >= ge
	 
</pre>

${ 5==3  } == ${ 5 eq 3    }<br>
${ 5!= 3 } == ${ 5 ne 3    }<br>
${ 5 < 3 } == ${ 5 lt 3    }<br>
${ 5 > 3 } == ${ 5 gt 3    }<br>
${ 5<=3 } == ${  5 le 3   }<br>
${ 5>=3 } == ${  5 ge 3   }<br>


<pre>
	[EL 연산자]
	3. 논리 연산자
	  &&   and
	  ||   or
	  !    not

</pre>

${true && true } == ${ true and true }<br>
${true || true } == ${ true or true }<br>
${!true } == ${ not true }<br>

<pre>
	***empty 연산자 **
	값 null         true
	값 "" 			true
	배열길이 0      true
	빈 Map          true
	빈 Collection    true

	위의 경우 외에 empty 연산자의 결과는 false 리턴한다.

</pre>

${empty "" }<br>
${empty null }<br>
X ${empty 0 }<br>

<pre>
삼항연산자

</pre>


</body>
</html>