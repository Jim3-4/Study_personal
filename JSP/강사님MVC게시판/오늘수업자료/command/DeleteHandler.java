package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;

public class DeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		if(  request.getMethod().equals("GET") ) {    			
			return "/days08/board/delete.jsp";			
		}else if( request.getMethod().equals("POST") ){  // post 방식요청
			
			request.setCharacterEncoding("UTF-8");
			// System.out.println("> Delete.doPost() 호출됨.");
			int seq = Integer.parseInt( request.getParameter("seq") );  // delete.htm?seq=641
			String pwd = request.getParameter("pwd");  // 입력받은 비밀번호
			 
			
			// 2. insert( dto )
			Connection conn = DBconn.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			int rowCount = 0;
			try {
				BoardDTO dto = dao.view(seq);
				String originalPwd =  dto.getPwd(); // null 반환 X   pwd 반환
				if( pwd.equals(originalPwd) ) {
					// 삭제
					rowCount = dao.delete(seq);
				}else {
					// 비밀번호 잘못되었다 경고. 
					// 삭제 delete.jsp 
					request.setAttribute("error", "비밀번호가 틀립니다.");
					return "/days08/board/delete.jsp";
				}
			} catch (SQLException e) { 
				System.out.println("> Delete.doPost() Exception...");
				e.printStackTrace();
			}
			DBconn.close();
			
			// 3.  list.htm 리다이렉트 요청   ->   List.java 서블릿 호출 ->   list.jsp 포워딩
			String location = "/jspPro/board/list.do";
			if( rowCount == 1)    location +="?delete=success";
			response.sendRedirect(location); 
			
		}else {  // PUT, DELETE, UPDATE 등등
			response.sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED  );
		}
		
		return null;
		
	}

}
