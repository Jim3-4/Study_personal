<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 17. - 오전 11:39:26</title>
<link rel="shortcut icon "type = "image/x-icon" href = "../images/SiSt.ico">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#accordion" ).accordion();
  } );
  </script>
  <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
</head>
<body>


<h3>ex02_ok_jstl.jsp</h3>
<!-- JSTL -->

<div id="accordion">
<c:forEach items="${ map }" var="entry">

<h3>${ entry.key }</h3>

<div>
   <p>
      <c:set value="${ entry.value }" var="list"></c:set>
      
      <c:if test="${ empty list }">
      <li>employee does not exist.</li>
      </c:if>
      <c:if test="${ not empty list }">
         <c:forEach items="${ list }" var="dto">
            <li>${ dto.empno } / ${ dto.ename } / ${ dto.sal }</li>
         </c:forEach>
      </c:if>
      
   </p>
</div>
</c:forEach>
</div>

<!-- 
  <h3>Section 1</h3>
  <div>
    <p>
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
    ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
    amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
    odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </p>
  </div>
-->  
<hr>
<hr>
<div id="tabs">
  <ul>
     <!-- 
    <li><a href="#tabs-1">Nunc tincidunt</a></li>
    <li><a href="#tabs-2">Proin dolor</a></li>
    <li><a href="#tabs-3">Aenean lacinia</a></li>
    -->
    <c:forEach items="${map }" var="entry" varStatus="status">
       <li><a href="#tabs-${ status.count }">${ entry.key }</a></li>
    </c:forEach>
  </ul>
  
    <c:forEach items="${map }" var="entry" varStatus="status">
    <div id="tabs-${status.count} ">
    <p>
    <c:set value="${entry.value }" var="list"> </c:set>
    <c:forEach items="${list }"  var="dto">
    <li>${dto.empno }/%{dto.ename}/${dto.sal }</li>
    </c:forEach>
    </p>
    </div>
    </c:forEach>
<!-- 
  <div id="tabs-1">
    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
  </div>
-->
</div>


</body>
</html>