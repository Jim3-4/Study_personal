package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;

public class ViewHandler implements  CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("> View.doGet() 호출됨...");
	      int seq = Integer.parseInt(request.getParameter( "seq"));
	      
	      Connection conn = DBconn.getConnection();
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      BoardDTO dto = null;
	      try {
	          // 트랜잭션 처리 +  서비스 클래스 
	         // ㄱ. 
	          dao.increaseReaded(seq);
	          // ㄴ.
	          dto = dao.view(seq);          
	          request.setAttribute("dto", dto);           
	      } catch (SQLException e) { 
	         System.out.println("> View.doGet() Exception...");
	         e.printStackTrace();
	      }
	      DBconn.close();
	      
	      //포워딩부분은 dispatch에서 하기때문에 안가져왓다. 
		return "/days08/board/view.jsp";
	}

}
