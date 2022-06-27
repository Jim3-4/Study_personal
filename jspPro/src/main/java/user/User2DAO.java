package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User2DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public User2DAO() {
		try {
			String className = "oracle.jdbc.driver.OracleDriver";
			String dbURL= "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID= "SCOTT";
			String dbPassword = "tiger";
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL="select userpassword from user2 where userID=?";
		try {
			pstmt=conn.prepareStatement(SQL);
			//매개변수를 ?에 넘어가도록 
			pstmt.setString(1, userID);
			//result에 실행한결과를 넣어준다. 
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//아이디가 있다. 
				if(rs.getString(1).equals(userPassword)){
					return 1;
				}else{
					return 0; //비밀번호 불일치 
				}
			}
			return -1;//아이디가없다. 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -2;
	}
}
