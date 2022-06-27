package days05.board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDAO {
	// 1. 모든 게시글 목록 반환하는 메서드 선언
	public abstract ArrayList<BoardDTO> select( ) throws SQLException;

	// 2. 새로운 게시글 추가하는 메서드 선언
		public abstract int insert( BoardDTO dto ) throws SQLException;
		
		//9.  현재페이지에 해당되는 게시글 목록 반환 하는 메소드 선언 중복선언 오버로딩 
		//한페이지에 몇개, 몇번페이지를 볼껀지 
		public abstract ArrayList<BoardDTO> select(int currentPage,int numberPerPage) throws SQLException;

		// 7. 총 레코드수 반환하는 메서드
		   int getTotalRecords() throws SQLException;
		   
		   // 8. 총 페이지수 반환하는 메서드
		   int getTotalPages( int numberPerPage ) throws SQLException;

		   // 8. 총 페이지수 반환하는 메서드(검색된 것 )
		   int getTotalPages(int numberPerPage, int searchCondition, String searchWord) throws SQLException;

		 //3-1 조회수 증가 메서드	 여기서 매개변수 int seq(보고자 하는 글번호)    void
			void increaseReaded(int seq) throws SQLException;
			//앞에 public abstract 생략되어 있음
			
			//3-2 게시글 정보 반환 메서드  여기서 매개변수 int seq(보고자 하는 글번호)  BoardDTO dto
			BoardDTO view(int seq) throws SQLException;

			// 5. 게시글 수정 메서드 
			int update(BoardDTO dto) throws SQLException;
			

			//4. 게시글 삭제 메서드
			int delete(int seq) throws SQLException;
			
			//10.검색메서드 + 페이징 처리추가
			ArrayList<BoardDTO> search(int currentPage, int numberPerPage, int searchCondition,
					String searchWord) throws SQLException;
						
}
