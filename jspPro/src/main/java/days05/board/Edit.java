package days05.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;


@WebServlet("/cstvsboard/edit.htm")
public class Edit extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public Edit() {
        super();

    }

    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ///cstvsboard/edit.htm?seq=364
      System.out.println(">Edit.doGet() 호출됨");
      
      int seq = Integer.parseInt(request.getParameter("seq"));
      
      Connection conn = DBconn.getConnection();
        BoardDAOImpl dao = new BoardDAOImpl(conn);
        BoardDTO dto = null;
        try {
    
           dto = dao.view(seq);
           request.setAttribute("dto", dto);
   
        } catch (SQLException e) {
            System.out.println(">Edit.doGet() Exception");
            e.printStackTrace();
        }
        DBconn.close();
        
        //view.jsp 포워딩
        String path = "/days05/board/edit.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
      dispatcher.forward(request, response);
      
   }//doGet

   
   //Write.java 서블릿의 doPost()메서드 동일하다.(복사,붙이기)
   //"작성 완료"버튼클릭
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //톰캣 8 post 요청 ISO 8859-1 인코딩X
      request.setCharacterEncoding("UTF-8");

      
      System.out.println(">Edit.doPost() 호출됨");
      
      int seq = Integer.parseInt(request.getParameter("seq"));
      
      
      //1.파라미터 -> BoardDTO dto 생성
        //String writer = request.getParameter("writer");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int tag = Integer.parseInt(request.getParameter("tag"));
        
        BoardDTO dto = new BoardDTO();
        //dto.setWriter(writer);
        dto.setPwd(pwd);
        dto.setEmail(email);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setTag(tag);
        dto.setSeq(seq);   //수정할 글번호
      
      
      
      //2. insert(dto)
       Connection conn = DBconn.getConnection();
       BoardDAOImpl dao = new BoardDAOImpl(conn);
       int rowCount=0;
       try {
         rowCount = dao.update(dto);    //dao에 insert가 성공하면 +1이 된다.
      } catch (Exception e) {
         System.out.println(">Edit.java doPost() Exception..");
         e.printStackTrace();
      }
       DBconn.close();
        
        
        
      //3. list.htm 리다이렉트 요청 -> List.java 서블릿 호출 -> list.java 포워딩
      String location = "/jspPro/cstvsboard/view.htm?seq="+seq;
      if(rowCount ==1 ) location += "&edit=success";
      else              location +="&edit=fail";
      response.sendRedirect(location);

   }

}