package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*@WebFilter("/days09/board/*")*/
public class LoginCheckFilter implements Filter {


    public LoginCheckFilter() {
        
    }


   public void destroy() {
      
   }


   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      System.out.println(">LoginCheckFilter.doFilter() 호출됨");
      //session - member:logonID
      //서블릿(필터)에서 세션을 사용하는 방법    request객체 사용
      HttpServletRequest httpRequest = (HttpServletRequest)request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      
      /*우리가 쓰던 request(HttpServletRequest)가 아니라 ServletRequest 라서 다운 캐스팅 해줘야한다.*/
      
      
      String logonID = null;
      boolean isLogon = false;
      
      HttpSession session = httpRequest.getSession(false);
      if (session!=null) {
         logonID = (String)session.getAttribute("member");
         if (logonID!=null) {
            isLogon=  true;
         }
      }//if
      
      
       // board/* 요청
         // isLogon  true( 로그인 O )  false ( 로그인 X )
         if( isLogon ) {  // ( 로그인 O )
            chain.doFilter(request, response);
         }else {  // false ( 로그인 X )
           //원래 요청 URI 확인/저장
          String referer =   httpRequest.getRequestURI();     //jspPro/days09/board/ex03_write.jsp
          session.setAttribute("referer" , referer);
          //페이지가 이동되어도 주소가 저장되어야 한다.
          //그러려면 pageX,requestX, session,application,DB저장,쿠키
            
           
            
            
            
            // 로그인 페이지 이동
            String location = "/jspPro/days09/member/ex03_logon.jsp";
            httpResponse.sendRedirect(location);
         }

      
      
      /*chain.doFilter(request, response);*/
      
   }


   public void init(FilterConfig fConfig) throws ServletException {

   }

}