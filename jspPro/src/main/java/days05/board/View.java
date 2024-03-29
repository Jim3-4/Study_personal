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

/**
 * Servlet implementation class View
 */
@WebServlet("/cstvsboard/view.htm")
public class View extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public View() {
        super();

    }

    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ///cstvsboard/view.htm?seq=364
      System.out.println(">View.doGet() 호출됨");
      
      int seq = Integer.parseInt(request.getParameter("seq"));
      
      Connection conn = DBconn.getConnection();
        BoardDAOImpl dao = new BoardDAOImpl(conn);
        BoardDTO dto = null;
        try {
           //트랜잭션 처리 + 서비스 클래스
           //ㄱ.
           dao.increaseReaded(seq);
           //ㄴ.
           dto = dao.view(seq);
           request.setAttribute("dto", dto);
   
        } catch (SQLException e) {
            System.out.println(">View.doGet() Exception");
            e.printStackTrace();
        }
        DBconn.close();
        
        //view.jsp 포워딩
        String path = "/days05/board/view.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
      dispatcher.forward(request, response);
      
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


   }

}