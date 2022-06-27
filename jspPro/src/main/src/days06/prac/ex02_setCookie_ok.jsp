<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 쿠키만 생성할 것이니 화면에 보일 html 코딩 필요 없겠다 -->

<%			
	String cname = request.getParameter("cname");
	String cvalue = request.getParameter("cvalue");
	
	//***[주의]*** 값 저장시
	Cookie cookie = new Cookie(cname, URLEncoder.encode(cvalue,"UTF-8") );
	//cookie.setDomain(domain); 안주면 로컬호스트 잡힘
	cookie.setPath("/"); //경로 WebContent밑의 모든 요청을 쿠키값 가지고 전송하겠다는 의미
	cookie.setMaxAge(-1); //음수 값을 만료시점으로 입력할 경우 웹브라우저를 닫을 때 쿠키 자동 삭제
				//0(즉시 지워라) -1(브라우저 종료시 지워라)
											
	response.addCookie(cookie); //쿠키에 저장하라는 명령
	
	response.sendRedirect("ex02.jsp");
	
	//서버에서 쿠키를 생성하는 게 아니라 명령을 내리는 것 (알려주는 역할 뿐) 실제 저장은 안일어남
	//명령어가 들어있다고 생각
%>