<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 22. - 오전 9:21:03</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

   <h3>ex02_05.jsp</h3>
   
   <%!
      // js getCookie(cname) > value 반환
      // 쿠키이름 > 쿠키값 반환
      public String getCookie(String cname, HttpServletRequest request) throws Exception{
         // request.getCookies()
         String cvalue = null;
         
         Cookie[] cookies = request.getCookies();
         for(Cookie c:cookies){
            if(c.getName().equals(cname)){
               cvalue = URLDecoder.decode(c.getValue(),"UTF-8");
               break; // 반복문 빠져나오기
            }
         }// foreach
         
         return cvalue;
      }
   %>
   
   <form action="ex02_05_ok.jsp">
      <!-- ex02_05.jsp?chkCookie=name&ckbCookie=age -->
      <%
         String[] edit_cnames = request.getParameterValues("ckbCookie");
         for(int i = 0; i < edit_cnames.length; i++){
            String cname = edit_cnames[i];
      %>
         <!-- 표현식에서 선언문에 선언된 메서드 getCookie()를 호출할 수 있다. -->
         <li><%= cname %>: <input type="text" name="<%= cname %>" value="<%= getCookie(cname,request) %>" /></li>
      <%
         }
      %>
      
      <input type="submit" value="쿠키수정" />
   </form>

</body>
</html>