package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.N_NewsDTO;

public interface N_NewsDAO {
	//검색 (제목만)
	ArrayList<N_NewsDTO> searchList(Connection con, String searchWord)throws SQLException;
	//목록가져오기 
	List<N_NewsDTO> selectList(Connection con)throws SQLException;
	//공지가져오기 
	List<N_NewsDTO> noticeList(Connection con)throws SQLException;
}
