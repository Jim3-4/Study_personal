package com.listener;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBCPinitListener implements ServletContextListener{

   @Override
   public void contextDestroyed(ServletContextEvent sce) { 
      // 웹 어플리케이션 종료 == 톰캣 서버 stop
      System.out.println("> DBCPinitListener.contextDestroyed() 호출됨.. 자원 반환");
   }

   @Override
   public void contextInitialized(ServletContextEvent sce) { 
      // 웹 어플리케이션 시작 == 톰캣 서버 start
      System.out.println("> DBCPinitListener.contextInitialized() 호출됨.. 초기화");
      // web.xml 
      // <context-param>   poolConfig 파라미터명,  DB 설정
      String poolConfig =  sce.getServletContext().getInitParameter("poolConfig");
      
      StringReader sr = new StringReader(poolConfig);
      
      Properties prop = new Properties();
      
      try {
         prop.load(sr);
      } catch (IOException e) { 
         e.printStackTrace();
      }
      
      System.out.println( prop.getProperty("type"));
      System.out.println( prop.getProperty("driverClassName"));
      System.out.println( prop.getProperty("username"));
      System.out.println( prop.getProperty("password"));
      
   }

}