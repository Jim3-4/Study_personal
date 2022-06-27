package days08.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days05.board.BoardDAOImpl;
import days05.board.BoardDTO;
import days05.board.PageBlock;

public class ListHandler   implements  CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int currentPage = 1 ;                // 현재 페이지. 
	      int numberPerPage = 10;         // 한 페이지에 출력할 게시글 수 
	      int numberOfPageBlock = 10;  // 페이징 블럭 수   [1] 2 3 4 5 6 7 8 9 10 >  >>
	      
	      ArrayList<BoardDTO> list = null;
	      
	      // 페이징 처리
	      int totalRecords, totalPages  = 0;
	      
	      // 검색 1
	      int searchCondition = 1;   // 1,[2],3,4
	      String searchWord = "";
	      
	      Connection conn = DBconn.getConnection();
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      try {
	         // ?currentPage X
	         // null  = > 1
	         try {  currentPage = Integer.parseInt( request.getParameter("currentpage") ); }catch(Exception e) {}      
	         
	         // 검색2
	         // 검색조건, 검색어 파라미터 넘어올 수 도 있다.
	         try {             searchCondition = Integer.parseInt( request.getParameter("searchCondition") );   }catch(Exception e) {         }
	         searchWord = request.getParameter("searchWord") == null ? "" : request.getParameter("searchWord");
	         
	         if (  searchWord.equals("")  ) {  // 검색 X
	            list = dao.select( currentPage, numberPerPage );
	            // 페이징 처리 위한 부분
	             totalRecords = dao.getTotalRecords();  // 총 레코드 수
	             totalPages = dao.getTotalPages(numberPerPage); // 총 페이지수 
	         } else {  // 검색 O
	                list = dao.search(currentPage, numberPerPage, searchCondition, searchWord);
	                totalPages = dao.getTotalPages(numberPerPage, searchCondition, searchWord);  // 검색된 총 페이지 수 
	         }
	           
	           
	           
	      } catch (SQLException e) { 
	         System.out.println("> List.doGet() Exception...");
	         e.printStackTrace();
	      }
	      DBconn.close();
	      
	      request.setAttribute("list", list);
	      
	      // 페이징 처리 부분
	      PageBlock pageBlock = new PageBlock();
	         pageBlock.setCurrentPage(currentPage);
	         pageBlock.setNumberPerPage(numberPerPage);
	         pageBlock.setNumberOfPageBlock(numberOfPageBlock);
	         
	         int startOfPageBlock = 1;
	         int endOfPageBlock ;
	         // ****
	         startOfPageBlock = (currentPage -1) /numberOfPageBlock * numberOfPageBlock +1 ;
	         endOfPageBlock = startOfPageBlock + numberOfPageBlock -1;
	         if(  endOfPageBlock > totalPages ) endOfPageBlock = totalPages;
	         
	         pageBlock.setStartOfPageBlock(startOfPageBlock);
	         pageBlock.setEndOfPageBlock(endOfPageBlock);
	         
	         if( startOfPageBlock != 1 ) pageBlock.setPrev( true );
	         if( endOfPageBlock != totalPages ) pageBlock.setNext(true);
	      
	      request.setAttribute("pageBlock", pageBlock);
		
	      //포워딩할 페이지
		return "/days08/board/list.jsp";
	}

}
