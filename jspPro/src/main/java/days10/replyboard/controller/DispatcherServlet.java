package days10.replyboard.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days10.replyboard.command.CommandHandler;




public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();

    }
    
    //여기서 왜 map선언하는거임?
    private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();
    //MVC 컨트롤러의 역할?
    //			init()  때문에 서블릿이 생성될때 안에 과정들을 진행하는 것이다.
    //			doGet()
    //	모든 요청-> 각각 요청 -> 각각의 모델을 찾아서 -> 로직을 처리 시키기 위해서 - > 저장 -> list.jsp  뷰페이지 ->포워딩
    //     /board.list.do
    //
    //					commandHandlerMap          객체 엔트리 추가
    //				  init(){
    //						
    //				commandHandler.properties       요청을 처리할 목록을 적어두는 곳이다.
    //				URL=풀네임	
    //
    //
    //              key             value
    //				list.do        Lsithandler
    //				write.do       CommandHandler
    // 				edit.do     	EditHandler
    //				view.do			Viewhandler
    //				요청
    //
    //				}
    //
    //
    //
    //
    
    //실제 페이지가 처음에 로딩 될때 키 값에 해당되는게 
    @Override
	public void init() throws ServletException {
		// DispatcherServlet 서블릿이 객체로 생성될때(서버 시작하고 맵핑에 의해 서블릿이 실행될때) 호출됨 (초기화 작업 시켜줌) - init()메서드
		// 초기화 역할
    	//WEB-INF/commandHandler.properties 파일을 읽어서 요청 URL= CommandHandler =>  commandHandlerMap 추가
    	String path = this.getInitParameter("path");
    	String realPath = this.getServletContext().getRealPath(path);   //*******
    	
    	
    	Properties prop = new Properties();
    	try (FileReader fr = new FileReader(realPath)){ 
			prop.load(fr);
		} catch (Exception e) {
			throw new ServletException();
		}
    	
    	//key = /board/list.do
    	//value = days08.mvc.command.ListHandler 객체 생성
    	//commandHandlerMap 추가
    	
    	Iterator<Object> ir = prop.keySet().iterator();
    	while(ir.hasNext()) {
    		String url = (String)ir.next();    //요청 url
    		String commandHandlerFullName = prop.getProperty(url);
    		
    		try {
				Class<?>handlerClass = Class.forName(commandHandlerFullName);
				CommandHandler commandHandler = (CommandHandler) handlerClass.newInstance();
				
				
				this.commandHandlerMap.put(url,commandHandler);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    	
	}

	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 URL 분석 list.dp, write.do , edit.do 
		String requestURI = request.getRequestURI();	//				/jspPro/board/list.do
		//request.getRequestURL();  //    http://localhost/jspPro/board/list.do
		
		
		
		//requestURI 컨택스트 패스 제거
		String contextPath = request.getContextPath();
		
	   if (  requestURI.indexOf(  contextPath  )  == 0  ) {
	         requestURI = requestURI.substring(  contextPath.length()   );   //   "/board/list.do"  key
	      }

		
		//이 과정을 통해 contextPath를 앞에서 제거해 준다.
		//왜냐하면 키값으로   /board/list.do 가    Map에서 지금 키값으로 잇다.       commandHandler.propertirs에 키값으로 되어있기 때문이다.
		
		
		
		//2. 요청 URL -> 로직 처리하는 모델(커맨드핸들러) 찾아서 + request.setAttribute() 로 여기에 저장하던 session에 저장하던
		//value = map.get(key)
	   //인터페이스 upcasting
	   
	   CommandHandler modelHandler = this.commandHandlerMap.get(requestURI);
		
		
		
		//commandHandler.properties => ListHandler => new ListHandler() 객체 생성 로직 처리
		String viewPage = null;
		
		try {
			viewPage = modelHandler.process(request, response);
			
			//modelHandler( 여기에는 listHandler or edirHandler  )  을  process(modelHandler의 안에 내용 코딩을 진행하겠ㄷ.)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//3. 응답(View) 페이지 찾아서 그곳으로 리다이렉트 또는 포워딩
		if (viewPage!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
