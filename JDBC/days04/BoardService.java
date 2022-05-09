package days04.board;

import java.sql.SQLException;
import java.util.ArrayList;

// BoardController  -> BoardService -> BoardDAOImpl-> 오라클서버
// 
public class BoardService {
	
	private BoardDAO dao = null;
	
	// 1. 생성자 DI
	public BoardService( BoardDAO dao ) {
		this.dao = dao;
	}
	// 2. Setter DI 
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	// 1. 게시글 목록 서비스 메서드 
	public ArrayList<BoardDTO> selectService(){
		ArrayList<BoardDTO> list = null;
		
		try {
			// 1. 로그 기록 서비스
			System.out.println("> 게시글 목록 조회 -> 로그 기록 작업...");
			// 2. 게시글 목록
			list = this.dao.select();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 2. 게시글 추가 서비스 메서드 
	public int insertService( BoardDTO dto) {
		int rowCount = 0;
		try {
// 트랜잭션 처리 시작			
			// 1. 로그 기록 서비스
			System.out.println("> 게시글 추가 -> 로그 기록 작업...");
			// 2. 게시글 추가
			rowCount = this.dao.insert(dto);
			// 3. 작성자 포인터 1증가
			// this.dao.updatePoint(작성자)
// 트랜잭션 처리 종료
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return rowCount;
	}

	// 3 해당 게시글 상세보기 서비스 메서드
	//   - 해당 게시글  조회수 증가
	//   - 해당 게시글 dto
	public BoardDTO  viewService( int seq ){
		BoardDTO dto = null;
		try {
// 트랜잭션 시작			
			// 1.
			this.dao.increaseReaded(seq);
			// 2. 
			 dto =  this.dao.view(seq);
			 // 3. 
			 System.out.println("> 게시글 상세보기 -> 로그 기록 작업...");
// 트랜잭션 종료			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int deleteService(int seq) {
		int rowCount = 0;
		 
		try {
// 트랜잭션 시작			
			rowCount = dao.delete(seq);		 
			 System.out.println("> 게시글 삭제 -> 로그 기록 작업...");
// 트랜잭션 종료			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int updateService(BoardDTO dto) {
		int rowCount = 0;
		 
		try {
// 트랜잭션 시작			
			rowCount = dao.update( dto );		 
			 System.out.println("> 게시글 수정 -> 로그 기록 작업...");
// 트랜잭션 종료			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public ArrayList<BoardDTO> searchService(int searchCondition, String searchWord) {
		
		// selectService() 메서드의 모든 코딩 복사 + 붙이기
		ArrayList<BoardDTO> list = null;
		
		try {
			// 1. 로그 기록 서비스
			System.out.println("> 게시글 검색 목록 조회 -> 로그 기록 작업...");
			// 2. 게시글 목록
			list = this.dao.search(searchCondition, searchWord);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return list;
		
	}
} // class



