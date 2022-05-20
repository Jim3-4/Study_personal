package days04.board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDAO {
	
	// 1. 모든 게시글 목록 반환하는 메서드 선언
	public abstract ArrayList<BoardDTO> select( ) throws SQLException;
	
	// 9. 현재 페이지 에 해당되는  게시글 목록 반환하는 메서드 선언
	public abstract ArrayList<BoardDTO> select( int currentPage, int numberPerPage ) throws SQLException;
	
	// 2. 새로운 게시글 추가하는 메서드 선언
	public abstract int insert( BoardDTO dto ) throws SQLException;

	// 3:05 수업시작~
	// 3-1. 조회수 증가 메서드                   int seq                void
	void increaseReaded(int seq) throws SQLException;
	// 3-2. 게시글 정보 반환 메서드           int seq                BoardDTO dto
	BoardDTO view(int seq) throws SQLException;

	// 4. 게시글 삭제 메서드
	int delete(int seq) throws SQLException;

	// 5. 게시글 수정 메서드 
	int update(BoardDTO dto) throws SQLException;

	// 오버로딩( overload )
	// 6. 검색 메서드
	ArrayList<BoardDTO> search(int searchCondition, String searchWord) throws SQLException;
	// 10. 검색 메서드  + 페이징 처리 추가
	ArrayList<BoardDTO> search(int currentPage, int numberPerPage, int searchCondition,
				String searchWord) throws SQLException;
	
	// 7. 총 레코드수 반환하는 메서드
	int getTotalRecords() throws SQLException;
	
	// 8. 총 페이지수 반환하는 메서드
	int getTotalPages( int numberPerPage ) throws SQLException;

	int getTotalPages(int numberPerPage, int searchCondition, String searchWord) throws SQLException;

	
	
} // interface









