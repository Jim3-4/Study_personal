package days04.board.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.util.DBconn;

import days04.board.BoardDAOImpl;
import days04.board.BoardDTO;

class BoardDAOImplTest {
 
   /*
	@Test
	public void insert_test() {
		Connection conn = DBconn.getConnection();
		BoardDAOImpl  dao = new BoardDAOImpl( conn );
		try {
			
			BoardDTO dto = new BoardDTO();
			// writer, pwd, email, title, tag, content
			dto.setWriter("홍길동");
			dto.setPwd("1234");
			dto.setEmail("hong@naver.com");
			dto.setTitle("첫 번째 게시글");
			dto.setTag(0);  //  0 텍스트모드,  1 html 모드
			dto.setContent( "첫 번째 게시글 내용..."  );
			
			int rowCount =  dao.insert(dto);
			
			if( rowCount == 1 ) {
				System.out.println("> 새 게시글 작성 성공~~~");
			}else {
				System.out.println("> 새 게시글 작성 실패~~~");
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			DBconn.close();
		}		
	}
*/
	
	@Test
	public void select_test() {
		Connection conn = DBconn.getConnection();
		
		// 1. 생성자 DI
		//BoardDAOImpl  dao = new BoardDAOImpl( conn );
		
		// 2. Setter DI
		BoardDAOImpl  dao = new BoardDAOImpl(  );
		dao.setConn(conn);
		
		ArrayList<BoardDTO> list = null;
		try {
			list = dao.select();
			if ( list == null) {
				System.out.println("> 게시글이 존재 X");
			} else {
				Iterator<BoardDTO> ir = list.iterator();
				while (ir.hasNext()) {
					BoardDTO dto =  ir.next();
					System.out.println(  dto );
				}
			} // if
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			DBconn.close();
		}		
		
	} //
	 

}










