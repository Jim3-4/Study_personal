package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.JdbcUtil;

import domain.N_NewsDTO;

public class N_NewsDAOImpl implements N_NewsDAO {
	private N_NewsDAOImpl() {}
	 private static N_NewsDAOImpl instance = new N_NewsDAOImpl();
	public static N_NewsDAOImpl getInstance() {
		return instance;
	}
	@Override
	public ArrayList<N_NewsDTO> searchList(Connection con, String searchWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<N_NewsDTO> selectList(Connection con) throws SQLException {
		System.out.println(" 일반글 lmpl시작");
		//일단 일반글만 불러오는거 먼저하고
		 String sql = "SELECT	N_CODE, N_TITLE, N_CONT, N_DATE, N_HITS, N_NOTI"
		      		+ " FROM  N_NEWS"
		      		+ " WHERE N_NOTI=0"
		      		+" ORDER BY N_DATE DESC";
			/*
			 * select row_number() over (order by n_date desc) num, n_news.* 
			 * from n_news
			 * where n_noti=0
			 * 
			 * 2번
			 		   String sql = "SELECT	N_CODE, N_TITLE, N_CONT, N_DATE, N_HITS, N_NOTI"
		      		+ " FROM  N_NEWS"
		      		+ " WHERE N_NOTI=0"
		      		+" ORDER BY N_DATE DESC";
			 */
	      List< N_NewsDTO> list = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if ( rs.next() ) {
	            list = new ArrayList< N_NewsDTO>();
	            N_NewsDTO dto = null;
	            do {
	                dto =  new  N_NewsDTO();
	                
					dto.setN_CODE(rs.getInt("N_CODE"));
					dto.setN_TITLE(rs.getString("N_TITLE"));
					dto.setN_CONT(rs.getString("N_CONT"));
					dto.setN_DATE(rs.getDate("N_DATE"));
					dto.setN_HITS(rs.getInt("N_HITS"));
					dto.setN_NOTI(rs.getInt("N_NOTI"));
					//System.out.println(dto.toString());
	               list.add(dto);
	            } while ( rs.next() );
	         } // 
	      } finally {
	         JdbcUtil.close(pstmt);
	         JdbcUtil.close(rs);         
	      } // finally
	      return list;
	}
	@Override
	public List<N_NewsDTO> noticeList(Connection con) throws SQLException {
		   String sql ="SELECT	N_CODE, N_TITLE, N_CONT, N_DATE, N_HITS, N_NOTI"
		      		+ " FROM  N_NEWS"
		      		+ " WHERE N_NOTI=1"
		      		+" ORDER BY N_DATE DESC";
		      
		      List< N_NewsDTO> Nlist = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;

		      try {
		         pstmt = con.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         if ( rs.next() ) {
		            Nlist = new ArrayList< N_NewsDTO>();
		            N_NewsDTO dto = null;
		            do {
		                dto =  new  N_NewsDTO();
						dto.setN_CODE(rs.getInt("N_CODE"));
						dto.setN_TITLE(rs.getString("N_TITLE"));
						dto.setN_CONT(rs.getString("N_CONT"));
						dto.setN_DATE(rs.getDate("N_DATE"));
						dto.setN_HITS(rs.getInt("N_HITS"));
						dto.setN_NOTI(rs.getInt("N_NOTI"));
						//System.out.println(dto.toString());
		               Nlist.add(dto);
		            } while ( rs.next() );
		         } // 
		      } finally {
		         JdbcUtil.close(pstmt);
		         JdbcUtil.close(rs);         
		      } // finally
		      return Nlist;
	}
	
	


}
