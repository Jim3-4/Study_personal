package newlecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import newlecture.vo.Notice;

// @Component
@Repository           // noticeDao
public class NoticeDao {
   
   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   // 검색한 결과의 총레코드 수 를 반환하는 메서드 
   public int getCount(String field, String query) throws ClassNotFoundException, SQLException
   {
      String sql = "SELECT COUNT(*) CNT "
                     + " FROM NOTICES "
                     + " WHERE "+field+" LIKE ?";    // 
      
       //return  this.jdbcTemplate.queryForInt(sql, "%"+query+"%");
      return  this.jdbcTemplate.queryForInt(
                                                                    sql
                                                                   , new Object[] { "%"+query+"%" }    
                                                                      );
   }
   
   // 페이징 처리 + 공지사항 목록
   public List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
   {               
      
      int srow = 1 + (page-1)*15;  
      int erow = 15 + (page-1)*15;  
      
      String sql = " SELECT * "
                     + "  FROM ( "
                     + "                 SELECT ROWNUM NUM, N.* "
                     + "                 FROM ("
                     + "                          SELECT * "
                     + "                          FROM NOTICES "
                     + "                          WHERE "+field+" LIKE ? "
                           + "                   ORDER BY REGDATE DESC"
                           + "                    ) N"
                           + "      ) "
                     +  " WHERE NUM BETWEEN ? AND ? ";
       
      // 테이블 컬러명 == Notice DTO의 필드명 반드시 일치해야 된다. 
      List<Notice> list = this.jdbcTemplate.query(sql
                                          ,   new Object[] { "%"+query+"%", srow, erow }     // ? , ? , ?
                                            ,  new BeanPropertyRowMapper<Notice>(Notice.class)
                                         );
      return list;
      
   } // getNotices
   
   // 공지사항 삭제
   public int delete(String seq) throws ClassNotFoundException, SQLException
   {
       
      String sql = " DELETE  FROM NOTICES "
                       + " WHERE SEQ=?"; 
      
      return this.jdbcTemplate.update(sql, seq);  // mybatis
      
   }
   
   // 공지사항 수정
   public int update( Notice notice ) throws ClassNotFoundException, SQLException{ 
       
      String sql = "UPDATE NOTICES "
                      + " SET TITLE=?, CONTENT=?, FILESRC=? "
                      + " WHERE SEQ=?";
      
      return  this.jdbcTemplate.update(sql, notice.getTitle(), notice.getContent(), notice.getFilesrc(), notice.getSeq());
       
   }
   
   // 해당 공지사항 상세보기. 
   public Notice getNotice(String seq) throws ClassNotFoundException, SQLException
   {
      String sql = " SELECT * "
                     + " FROM NOTICES "
                     + " WHERE SEQ= ? ";
      
      Notice notice =  this.jdbcTemplate.queryForObject(
                               sql
                               , new Object[] { seq }
                               , ParameterizedBeanPropertyRowMapper.newInstance(Notice.class) 
                               ); 
     
      return notice;
   }

   // 공지사항 글쓰기
   public int insert(Notice notice) throws ClassNotFoundException, SQLException {
	   String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
		        + " VALUES( "
		        + "        (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), ?, ?, 'tae', SYSDATE, 0, ?) ";
	   return jdbcTemplate.update(sql, notice.getTitle(), notice.getContent(), notice.getFilesrc());
   }

} // class










