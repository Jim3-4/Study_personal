package days09.guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days09.guestbook.domain.Message;
import days09.guestbook.service.GetMessageListService;
import days09.guestbook.service.UpdateMessageService;

//       updateMessage.do?messageId=3
public class UpdateMessageHandler  implements CommandHandler{

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // request.setCharacterEncoding("UTF-8");   필터 
      
      System.out.println("> updateMessage.do 요청 : UpdateMessageHandler.process() GET 호출됨...");
      
      if( request.getMethod().equalsIgnoreCase("GET") ) {
         GetMessageListService messageService =
               GetMessageListService.getInstance();
         int messageId = Integer.parseInt(request.getParameter("messageId") );
         Message msg = messageService.getMessage(messageId );
         request.setAttribute("msg", msg);
         return "/days09/guestbook/update.jsp";
         
      }else if(request.getMethod().equalsIgnoreCase("POST")) {         
         // request.setCharacterEncoding("UTF-8");
         
         System.out.println("> updateMessage.do 요청 : UpdateMessageHandler.process() POST 호출됨...");
         
         Message message = new Message();
           message.setMessage_id( Integer.parseInt( request.getParameter("h_id") ));
           message.setGuest_name(request.getParameter("guest_name"));  
           message.setPassword(request.getParameter("password"));  
           message.setMessage(request.getParameter("message"));
       
         // 서비스클래스 -> DAO -> insert~
         UpdateMessageService messageService =
               UpdateMessageService.getInstance();
         //
         messageService.update(message);
         return "list.do";   
      } 
      return null;
   }

}