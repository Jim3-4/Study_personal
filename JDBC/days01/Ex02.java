package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author k≡n¡k
 * @date 2022. 5. 2. - 오후 3:13:27
 * @subject   Connection 객체를 사용해서 DBMS(오라클)  연결/닫기
 * @content  DBMS 연결(Connection)하는 순서 *** (암기)
 */
public class Ex02 {

	public static void main(String[] args) {
		// 연결문자열
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String password = "tiger";  // 비밀번호는 대소문자 구분한다. 
		
		try {
			// 1. Class.forName()  JDBC드라이버 로딩
	        //    jdbcPro 자바 프로젝트 안에 ojdbc6.jar 참조 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			// 2. DriverManager.getConnection() 로 Connection 객체를 얻어온다.
			Connection conn = DriverManager.getConnection(url, user, password);
			
			// 3.  필요한 작업 ( CRUD ) X
			System.out.println(  conn );
			System.out.println(  conn.isClosed() );  // boolean    [false]/true
			
			// 4. 연결종료 ( Connection 객체 close )
			conn.close();  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(" END ");
		
	} // 

} // 


// 1. 에러 메시지 : java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver
// 2. 에러 메시지 : java.sql.SQLException: No suitable driver found for jdbc.oracle.thin:@localhost:1521:xe
