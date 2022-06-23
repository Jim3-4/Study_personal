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


/*@WebServlet("/DispatcherServlet")*/
public class DispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();

    }
    
//    여기서 왜 map선언하는거임?
   //DispatcherServlet의 역할이 컨트롤러 역할이다 . model 이 handler 
    //모든 요청->각각요청->로직처리모델 찾아서 ->로직처리 ->저장- >뷰페이지(list.jsp)->포워딩 
   //board/list/do->모델(커맨드핸들러) 
    					//		ListHandler 가져오기 
    //요청이들어오면 어떤 CommnadHandler가 필요한지 알기위해  
    						//list.do   ListHandler
						  //edit.do 	EditHandler
						  //write.do  WriteHandler
						  //view.do
    //init() 함수존재이유 => commandHandler.properties에서 url 풀네임을 가져와서 
    //commandHandlerMap 객체에 넣는다. 
    private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();
    
    
    //실제 페이지가 처음에 로딩 될때 키 값에 해당되는게 
 //init()- 웹 컨테이너 안에서 생성자처럼 서블릿 객체가  생성될때 호출되는 메소드, 초기화역할 
   //<load-on-startup>1</load-on-startup> 
    ///톰캣서버 시작될때 DispatcherServlet 서블릿 객ㄱ체 생성되고 init()
    // DispatcherServlet 역할은 모든 요청 ->handler.process()->포워딩 
    //list.do->어떤 핸들러가 필요한지 알기위해,  map 객체를 만들려고 init()에서 처리 
    @Override
   public void init() throws ServletException {
      // DispatcherServlet 서블릿이 객체로 생성될때(서버 시작하고 맵핑에 의해 서블릿이 실행될때) 호출됨 (초기화 작업 시켜줌) - init()메서드
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
      String requestURI = request.getRequestURI();   //            /jspPro/board/list.do
      //request.getRequestURL();  //    http://localhost/jspPro/board/list.do
      
      
      
      //requestURI 컨택스트 패스 제거-> key값에는 jspPro가 없기 때문에 . 
      //path=path.replaceAll("/jspPro","");
      String contextPath = request.getContextPath();
      
      if (  requestURI.indexOf(  contextPath  )  == 0  ) {
            requestURI = requestURI.substring(  contextPath.length()   );   //   "/board/list.do"  key
         }

      
      //이 과정을 통해 contextPath를 앞에서 제거해 준다.
      //왜냐하면 키값으로   /board/list.do 가    Map에서 지금 키값으로 잇다.       commandHandler.propertirs에 키값으로 되어있기 때문이다.
      
      
      
      //2. 요청 URL -> 로직 처리하는 모델(커맨드핸들러) 찾아서 + request.setAttribute() 로 여기에 저장하던 session에 저장하던
      //인터페이스 upcasting
      CommandHandler modelHandler = this.commandHandlerMap.get(requestURI);
      
      
      
      //commandHandler.properties => ListHandler => new ListHandler() 객체 생성 로직 처리
      String viewPage = null;
      
    //ListHandler의 process() list.jsp 2:13분에 설명 
    //M[View]C == JSP 페이지를 돌려줌
      try {
         viewPage = modelHandler.process(request, response);
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
   doGet(request,response);
   }

}