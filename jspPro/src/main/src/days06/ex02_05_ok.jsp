<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 실제 수정할 쿠키이름, 쿠키값 파라미터 전송 -->
<!-- <h3>ex02_05_ok.jsp</h3> -->
<%
    // ?name=aaa&age=12
    Enumeration<String> en = request.getParameterNames();
   while( en.hasMoreElements() ){ 
      String cname = en.nextElement();
      String cvalue = request.getParameter(cname);
      // 쿠키 생성 + 응답 포함
      Cookie c = new Cookie( cname,   URLEncoder.encode(cvalue, "UTF-8") );
      c.setMaxAge( -1 ) ; // 브라우저 종료할때 쿠키  자동 삭제
      response.addCookie( c );
   } // while
      
      String location = "ex02_03.jsp";
      response.sendRedirect(location);
%>