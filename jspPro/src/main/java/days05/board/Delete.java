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
 * Servlet implementation class Delete
 */
@WebServlet("/cstvsboard/delete.htm")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String path = "/days05/board/delete.jsp";
	      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	      dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");

	        int seq = Integer.parseInt(request.getParameter("seq"));
	        String pwd = request.getParameter("pwd"); // 입력받은 비밀번호


	        Connection conn = DBconn.getConnection();
	        BoardDAOImpl dao = new BoardDAOImpl(conn);
	        int rowCount=0;

	        try {
	            // 해당 게시글 번호의 정보를 dto 로 가져오면... view()
	            BoardDTO dto = dao.view(seq);
	            String originalPwd = dto.getPwd();

	            if (!pwd.equals(originalPwd)) {
	                request.setAttribute("error", "비밀번호가 틀립니다.");
	                doGet(request, response);
	                return;
	            } 

	            // 삭제 -> 페이지이동
	            rowCount = dao.delete(seq);
	        } catch (SQLException e) {
	            System.out.println("> Delete.java doPost() Exception...");
//	            conn.rollback();
	            e.printStackTrace();
	        }
	        DBconn.close();

	        String location = "/jspPro/cstvsboard/list.htm";
	        if (rowCount == 1) location += "?delete=success";
	        response.sendRedirect(location);

	}
}
