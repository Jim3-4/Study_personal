package days04;

import java.sql.Connection;

import com.util.DBconn;

import days04.board.BoardController;
import days04.board.BoardDAO;
import days04.board.BoardDAOImpl;
import days04.board.BoardService;

/**
 * @author k≡n¡k
 * @date 2022. 5. 9. - 오전 8:29:00
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:35 분 까지 제출.. 1문제.. 
		// 모델2방식의 [MVC 패턴]으로 개발
		// 1. tbl_cstvsboard 게시판 테이블 생성
		
		// 2. days04.board.BoardDTO
		// 3. days04.board.BoardDAO    인터페이스 선언
		//  - DAO( Data Access Object )
		//  - 편리성, 보안성
		// 4. days04.board.BoardDAOImpl - select() , insert()
		// 5. BoardDAOImpl.select() 메서드를 구현 -> DAO 객체의 select() 메서드  [단위 테스트]  11:03 ~ 수업 시작
		//    - days04.board.test 패키지 추가
		//    - BoardDAOImplTest
		//   12:03 수업 시작~ 
		// 6. days04.board.BoardService 클래스 추가
		// 7. days04.board.test.BoardServiceTest.java
		
		// 8. BoardController  요청->처리->응답
		//                                메뉴선택-> 처리-> boardService-> boardDao -> 콘솔 출력
	 

		Connection conn  = DBconn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn );
		BoardService service = new BoardService(dao );
		BoardController controller = new BoardController(service );
		
		controller.start();
		
		// [게시물 목록]
		//       글쓰기 버튼 클릭   ->  새 정보 입력  
		//                                     [저장]
		
		// [ 게시글 상세 보기 ]
		// [게시물 목록]에서 보고자 하는 게시글 제목을 클릭하면 -> 글번호 -> 상세 게시글 정보 출력
		//   글번호 의 조회수(readed) 컬럼을 1증가
		//   글번호의 게시글 정보를 BoardDTO 담아서 반환 
		
		// [ 게시글 수정 ]		// [ 게시글 삭제 ]
		
		// 9. 삭제    3:37 + 15  + 10  수업시작~  
		//                4:05. 풀이~ 
		//     1) 삭제할 게시글 번호를 입력 ? 2
		//     2) 코딩 모두 해 보자...
		
		//  게시글 상세보기 -> 삭제 -> 게시글 목록 
		
	} // main

} // class















