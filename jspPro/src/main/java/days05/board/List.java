package days05.board;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;


@WebServlet("/cstvsboard/list.htm")
public class List extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public List() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println(">List.doGet() 호출됨");

       int currentPage = 1;         //현재 페이지
       int numberPerPage = 10;         //한페이지에 출력할 게시글 수
       int numberOfPageBlock = 10;      //페이징 블럭 수 [1] 2 3 4 5 6 7 8 9 10 >

       ArrayList<BoardDTO> list = null;



       //페이징 처리
       int totalRecords, totalPages = 0;

       //검색
       int searchCondition = 1;//1,2,3,4
       String searchWord;
       
       
       Connection conn = DBconn.getConnection();
       BoardDAOImpl dao = new BoardDAOImpl(conn);
       try {
          //?currentPage X
          //null => 1
          try { //Integer이므로 오류나니까 null이면~이 작업 말고 try작업
             currentPage=Integer.parseInt(request.getParameter("currentpage"));//?currentpage 대소문자주의
          } catch (Exception e) {   }
          
          //검색조건, 검색어 파라미터 넘어올수 있다.
          try {
             searchCondition = Integer.parseInt(request.getParameter("searchCondition"));   } catch (Exception e) {}
          searchWord = request.getParameter("searchWord")== null ?"":request.getParameter("searchWord");
          
          if (searchWord.equals("")) {//검색 X
             list  = dao.select(currentPage, numberPerPage);             
             totalRecords = dao.getTotalRecords();
            
         } else {
            list  = dao.search(currentPage, numberPerPage, searchCondition, searchWord);             
            totalRecords = dao.getTotalPages(numberPerPage, searchCondition, searchWord);//검색된 총페이지 수

         }
          
          //페이징 처리 부분
          totalPages = dao.getTotalPages(numberPerPage);

       } catch (Exception e) {
          System.out.println("> List.doGet() Exception...");
          e.printStackTrace();
       }
       DBconn.close();

       request.setAttribute("list", list);

       //페이징 처리 부분
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

       if(startOfPageBlock != 1) pageBlock.setPrev(true);
       if(endOfPageBlock != totalPages) pageBlock.setNext(true);


       request.setAttribute("pageBlock", pageBlock);



       String path = "/days05/board/list.jsp";
       RequestDispatcher dispatcher = request.getRequestDispatcher(path);
       dispatcher.forward(request, response);
    }
   /* 페이징처리는 됐지만 다음 페이지관리가 안됨
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(">List.doGet() 호출됨");
      
      int currentPage = 1;         //현재 페이지
      int numberPerPage = 10;         //한페이지에 출력할 게시글 수
      int numberOfPageBlock = 10;      //페이징 블럭 수 [1] 2 3 4 5 6 7 8 9 10 >
      ArrayList<BoardDTO> list = null;
      
      //페이징 처리
      int totalRecords, totalPages = 0;
      
      
      Connection conn = DBconn.getConnection();
      BoardDAOImpl dao = new BoardDAOImpl(conn);
      try {
         //?currentPage X
         //null => 1
         try {
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
         } catch (Exception e) {   }
         
         
         list  = dao.select(currentPage,numberPerPage);
         
      } catch (SQLException e) {
         System.out.println("> List.doGet() Exception...");
         e.printStackTrace();
      }
      DBconn.close();
      
      request.setAttribute("list", list);
      
      String path = "/days05/board/list.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
      dispatcher.forward(request, response);
   }
   /* 페이징 처리가 안된 게시판목록
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println(">List.doGet() 호출됨");
      
      int currentPage = 1;         //현재 페이지
      int numberPerPage = 10;         //한페이지에 출력할 게시글 수
      int numberOfPageBlock = 10;      //페이징 블럭 수 [1] 2 3 4 5 6 7 8 9 10 >
      ArrayList<BoardDTO> list = null;
      
      
      Connection conn = DBconn.getConnection();
      BoardDAOImpl dao = new BoardDAOImpl(conn);
      try {
         list  = dao.select();
      } catch (SQLException e) {
         System.out.println("> List.doGet() Exception...");
         e.printStackTrace();
      }
      DBconn.close();
      
      request.setAttribute("list", list);
      
      String path = "/days05/board/list.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
      dispatcher.forward(request, response);
   }
   */

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}