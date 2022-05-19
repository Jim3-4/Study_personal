package days04.board.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.util.DBconn;

import days04.board.BoardDAO;
import days04.board.BoardDAOImpl;
import days04.board.BoardDTO;
import days04.board.BoardService;

class BoardServiceTest {
	

	@Test
	void insertService_test() {
		// 12:40 풀이
		Connection conn = DBconn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao);
		
		BoardDTO dto = new BoardDTO();
		// writer, pwd, email, title, tag, content
		dto.setWriter("홍길동");
		dto.setPwd("1234");
		dto.setEmail("hong@naver.com");
		dto.setTitle("두 번째 게시글");
		dto.setTag(0);  //  0 텍스트모드,  1 html 모드
		dto.setContent( "두 번째 게시글 내용..."  );
		
		int rowCount = service.insertService(dto);
		
		if( rowCount == 1 ) {
			System.out.println("> 새 게시글 작성 성공~~~");
		}else {
			System.out.println("> 새 게시글 작성 실패~~~");
		}
		
		DBconn.close();
		
	}
	
	/*
	@Test
	void selectService_test() {
		
		Connection conn = DBconn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao);
		
		ArrayList<BoardDTO> list =  service.selectService();
		
		if ( list == null) {
			System.out.println("> 게시글이 존재 X");
		} else {
			Iterator<BoardDTO> ir = list.iterator();
			while (ir.hasNext()) {
				BoardDTO dto =  ir.next();
				System.out.println(  dto );
			}
		} // if
		
		DBconn.close();
		
	}
	*/

} // class








