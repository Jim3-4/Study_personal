package days08.mvc.controller;

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

import days08.mvc.command.CommandHandler;

/**
 * Servlet implementation class Dispatcherservlet
 */
/* @WebServlet("/Dispatcherservlet") */
public class Dispatcherservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Dispatcherservlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Map<String , CommandHandler> commandHandlerMap=new HashMap<String, CommandHandler>();
    
	@Override
	public void init() throws ServletException {
	//Dispatcherservlet 서블릿 객체로 생성될때 초기화 작업 -init()메소드 
	// /WEB-INF/commandHandler.properties 파일을 읽어서 요청URL=CommandHandler->commandHandlerMap추가 
	String path=this.getInitParameter("path");
	String realPath=this.getServletContext().getRealPath(path);
	Properties prop=new Properties();
	try (FileReader fr=new FileReader(realPath)){
		prop.load(fr);
	} catch (Exception e) {
		throw new ServletException();
	}
	
	Iterator<Object> ir=prop.keySet().iterator();
	while (ir.hasNext()) {
		String  url = (String ) ir.next();
		String commandHandlerFullName=prop.getProperty(url);

		try {
			//물리적인 클래스 파일명을 인자로 넣어주면 해당하는 클래스를 반환
			Class<?> handlerClass = Class.forName(commandHandlerFullName); 
			CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance();
			
			this.commandHandlerMap.put(url, handlerInstance);
			//요청이 들어오면 맵을 뒤져 어떤 요청인지 확인 가능하게 됐다
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} 

	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 url 분석
		//어떤 요청이 들어왔는지 확인 
		String requestURI=request.getRequestURI(); //결과물이 /jspPro/board/list.do
		//request.getRequestURL(); //http://localhost/jspPro/board/list.do
		
		//map안에서 체크하기위해서는  requestURI 변수안에서 컨텍스트 패스 제거 
		String contextPath = request.getContextPath(); // "/jspPro" 이부분이 잡히는데 이것을 없애자 
		
		//앞에 contextPath 가 붙어있다면 제거하겠다. 
		if(requestURI.indexOf(contextPath)==0) {
		requestURI = requestURI.substring(contextPath.length());		 //앞에 /jspPro 잘림
		}
		//요청한 url에 해당하는 로직을 처리하는 모델 객체( = 커맨드 핸들러 )를 찾아서 처리해라 
		//commandHandler.properties=>;ListHandler=>new ListHandler() 객체 생성 로직처리 
		//이 객체를 가져오면, 인터페이스 안에  로직을 처리하는 모델 - 모델핸들러라는 이름으로 로직을 처리하는 객체를 얻어옴 
		CommandHandler modelHandler =this.commandHandlerMap.get(requestURI);
		String viewPage = null;
		try {
			viewPage =modelHandler.process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//응답(view) 리다이랙트 or 포워딩
		if(viewPage!=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	
		
		//응답(view) 리다이렉트, 포워드
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
