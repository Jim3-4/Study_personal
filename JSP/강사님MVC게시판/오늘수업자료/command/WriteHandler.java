package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;

public class WriteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//System.out.println("> WriteHandler.process() 호출됨...");
		
		if(  request.getMethod().equals("GET") ) {    // get방식요청   새 게시글 작성 write.jsp 포워딩.
			return "/days08/board/write.jsp";
		}else if( request.getMethod().equals("POST") ){  // post 방식요청
			
			// 새 게시글 정보를 DB 저장
			// list.do 리다이렉트 
			request.setCharacterEncoding("UTF-8");
			
			// 1. 파라미터 -> BoardDTO dto 생성
			String writer = request.getParameter("writer");  
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int tag = Integer.parseInt( request.getParameter("tag") );
			
			BoardDTO dto = new BoardDTO();
			dto.setWriter(writer);
			dto.setPwd(pwd);
			dto.setEmail(email);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setTag(tag);		
			
			// 2. insert( dto )
			Connection conn = DBconn.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			int rowCount = 0;
			try {
				rowCount = dao.insert(dto);
			} catch (SQLException e) { 
				System.out.println("> Write.java doPost() Exception...");
				e.printStackTrace();
			}
			DBconn.close();
			
			// 3.  list.htm 리다이렉트 요청   ->   List.java 서블릿 호출 ->   list.jsp 포워딩
			String location = "/jspPro/board/list.do";
			if( rowCount == 1)    location +="?write=success";
			response.sendRedirect(location); 
			
		}else {  // PUT, DELETE, UPDATE 등등
			response.sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED  );
		}
		
		return null;
	}

}
