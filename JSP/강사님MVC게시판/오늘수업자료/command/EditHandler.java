package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;

public class EditHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(  request.getMethod().equals("GET") ) {   
			
			int seq = Integer.parseInt(request.getParameter( "seq"));			
			Connection conn = DBconn.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			BoardDTO dto = null;
			try { 
				 dto = dao.view(seq);			 
				 request.setAttribute("dto", dto);			  
			} catch (SQLException e) { 
				System.out.println("> Edit.doGet() Exception...");
				e.printStackTrace();
			}
			DBconn.close();
			return "/days08/board/edit.jsp";
			
		}else if( request.getMethod().equals("POST") ){  // post 방식요청
			
			request.setCharacterEncoding("UTF-8");
			
			//System.out.println("> Edit.doPost() 호출됨.");
			// /cstvsboard/edit.htm?seq=364
			int seq = Integer.parseInt(request.getParameter( "seq"));
			
			// 1. 파라미터 -> BoardDTO dto 생성
			// String writer = request.getParameter("writer");  
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int tag = Integer.parseInt( request.getParameter("tag") );
			
			BoardDTO dto = new BoardDTO();
			//dto.setWriter(writer);
			dto.setPwd(pwd);
			dto.setEmail(email);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setTag(tag);		
			dto.setSeq(seq);  // 수정할 글번호
			
			// 2. insert( dto )
			Connection conn = DBconn.getConnection();
			BoardDAOImpl dao = new BoardDAOImpl(conn);
			int rowCount = 0;
			try {
				rowCount = dao.update(dto);
			} catch (SQLException e) { 
				System.out.println("> View.doPost() Exception...");
				e.printStackTrace();
			}
			DBconn.close();
			
			// 3.  list.htm 리다이렉트 요청   ->   List.java 서블릿 호출 ->   list.jsp 포워딩
			String location = "/jspPro/board/view.do?seq="+seq;
			if( rowCount == 1)    location +="&edit=success";
			else                           location +="&edit=fail";
			response.sendRedirect(location); 
			
		}else {  // PUT, DELETE, UPDATE 등등
			response.sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED  );
		}
		
		return null;
	}

}
