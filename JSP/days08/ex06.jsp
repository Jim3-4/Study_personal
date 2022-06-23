<%-- <%@page import="java.text.DecimalFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <%
  int price = 10000;
  String pattern = "#,##0";
  DecimalFormat df = new DecimalFormat(pattern);
  %>
  
  
  price = <%=df.format(price) %><br>
  
  
  <c:set var="price" value="<%=price %>"></c:set>
  <fmt:formatNumber value="${price}" var="priceVar"></fmt:formatNumber>
  <!-- 숫자를 내가 원하는 출력형태로 바꾸겠다 -->
  price = ${priceVar }<br>
  <!-- 자동으로 3자리마다 ,찍음 -->
  
  

  통화: <fmt:formatNumber value="${price}" type="number"></fmt:formatNumber><br>
  <!-- 변수를 안받음 이 자체로 출력하는 작업까지도 됨 --> 
  <!-- type의 기본값 number이고, percent 등 다른 거 넣어도 됨 -->
  
  통화: <fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"></fmt:formatNumber><br>
<!-- 통화단위+3자리마다 콤마 : 바로 위처럼 쓰면 됨 -->



퍼센트 : <fmt:formatNumber value="${price }" type="percent"></fmt:formatNumber> <br>
퍼센트 : <fmt:formatNumber value="${price }" type="percent" groupingUsed="false" ></fmt:formatNumber> <br>
<!-- groupingUsed="false" : 3자리마다 , 안찍음(콤마 단위 기호 표시 여부를 나타내는 속성, 기본은 true) -->



패턴 지정 : <fmt:formatNumber value="${price}" pattern="0000000.00"></fmt:formatNumber>


<fmt:parseNumber var="d_price" pattern="0,000.00"><%=price %></fmt:parseNumber>
<c:set var="qty"><%=qty %></c:set>
총판매금액: ${d_price * qty }
 --%>