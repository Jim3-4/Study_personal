package days08.mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days08.mvc.command.CommandHandler;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super(); 
    } 
    
    private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();
    
    @Override
	public void init() throws ServletException {
		 // DispatcherServlet 서블릿 객체로 생성될 때 초기화 작업 - init() 메서드
    	 // WEB-INF/commandHandler.properties 파일을 읽어서  요청URL=CommandHandler => commandHandlerMap 추가.
    	String path = this.getInitParameter("path");
    	String realPath = this.getServletContext().getRealPath(path);  // *****
    	
    	Properties prop  = new Properties();
    	try ( FileReader fr = new FileReader( realPath ) ) {
			prop.load(fr);
		} catch (Exception e) {
			throw new ServletException();
		}
    	//  key = /board/list.do
    	//  value = "days08.mvc.command.ListHandler"  객체 생성
    	// commandHandlerMap 추가
    	
    	Iterator<Object> ir =  prop.keySet().iterator();
    	while (ir.hasNext()) {
			String url = (String) ir.next();   // 요청 url
			String commandHandlerFullName  = prop.getProperty(url);
			
			try {
				Class<?> handlerClass =  Class.forName(commandHandlerFullName);
				CommandHandler commandHandler = (CommandHandler) handlerClass.newInstance();  // 인스턴스 == 생성된 객체				
				
				this.commandHandlerMap.put(url, commandHandler);
				
			} catch (ClassNotFoundException e) { 
				e.printStackTrace();
			} catch (InstantiationException e) { 
				e.printStackTrace();
			} catch (IllegalAccessException e) { 
				e.printStackTrace();
			}
			
		}
    	
	} 

	// 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 1. 요청 URL 분석   list.do, write.do, edit.do
	     String requestURI = request.getRequestURI();  //          "/jspPro/board/list.do"
	     // request.getRequestURL(); //          http://localhost/jspPro/board/list.do
	     
	     // requestURI   컨텍스트 패스 제거 
	     String contextPath = request.getContextPath();
	     
	     if( requestURI.indexOf( contextPath)  == 0) {
	         requestURI = requestURI.substring( contextPath.length() );  //  "/board/list.do"   key
	     }
	     
	     // key : requestURI = "/board/list.do";
	     
		 // 2. 요청 URL -> 로직 처리하는 모델객체( 커맨드핸들러) 찾아서 +  request.setAttribute()/session	
	     // value = map.get(key)
	     // 인터페이스 upcasting
	    CommandHandler modelHandler = this.commandHandlerMap.get( requestURI );
	    
		// commandHandler.properties => ListHandler => new ListHandler() 객체 생성 로직 처리
	    String viewPage = null;
	    
	    try {
	    	// list.jsp 포워딩
			viewPage = modelHandler.process(request, response);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	    
		 // 3. 응답 ( View )  리다이렉트, 포워딩.
	    if ( viewPage != null ) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} // 
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response); // 
	}

}
