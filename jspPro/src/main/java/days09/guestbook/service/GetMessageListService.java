package days09.guestbook.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import days09.guestbook.dao.MessageDao;
import days09.guestbook.domain.Message;

//싱글톤
public class GetMessageListService {

	private GetMessageListService() {}
	private static GetMessageListService instance = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return instance;
	}
	
	//한 페이지에 방명록 출력 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	//매개변수: 현재 페이지 pageNumber
	//리턴타입: MessageListView
	public MessageListView getMessageList(int pageNumber) {
		
	   	 Connection conn = null;
		
	      int currentPageNumber = pageNumber;
	      
	      try {
	         //         DBConn.getConnectionn();
	         conn = ConnectionProvider.getConnection();
	         // dao 객체 생성
	         Message messageDao = MessageDao.getInstance();
	         // 총 방명록 수
	         int messageTotalCount = messageDao.selectCount(conn);

	         List<Message> messageList = null;
	         int firstRow = 0;
	         int endRow = 0;
	         if (messageTotalCount > 0) {
	            firstRow =
	                  (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
	            endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
	            //      dao.selectList()     해당 페이지의 방명록을 select
	            messageList =
	                  messageDao.selectList(conn, firstRow, endRow);
	         } else {
	            currentPageNumber = 0;
	            messageList = Collections.emptyList(); //null주는거랑 똑같다
	         }
	         
	         
	         return new MessageListView(
					               messageList,
					               messageTotalCount
					               , currentPageNumber,
					               MESSAGE_COUNT_PER_PAGE
					               , firstRow, endRow);
	      } catch (SQLException | NamingException e) {
	         throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
	      } finally {
	         JdbcUtil.close(conn);
	      }
	}

	public Message getMessage(int messageId) {
		
		 Connection con = null;
 
		 Message message = null;
	      try {
	        
	         con = ConnectionProvider.getConnection();
	         MessageDao messageDao = MessageDao.getInstance();
	  
	         message = messageDao.select(con, messageId);      
	      }catch (Exception e) {
	    	  throw new ServiceException("메시지 구하기 실패: " + e.getMessage(), e);
	      } finally {
	         JdbcUtil.close(con);
	      }
	      return message;  
	     
	}//
	
	
	
}//class