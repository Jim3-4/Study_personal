package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 10. - 오후 3:50:20
 * @subject  
 * @content    Statement stmt = null;
 *                     PreparedStatement pstmt = null;
 *                     [ CallableStatement cstmt = null; ]   저장 프로시저 사용
 *                     
 *                     내일 : 설문조사 테이블 생성+ 데이터 있고, + 쿼리 작성 + JDBC => html5/css3/javascript/jquery/JSP+Servlet 
 */
public class Ex03 {

	public static void main(String[] args) {
		// 4:04 수업 시작
		// emp 테이블에 사원을 추가하는 up_insertemp 저장프로시저를 선언  -         UP_INSERTEMP
		// CallableStatement 를 사용해서 사원 추가 ...
		
		int empno = 9999;
		String ename = "admin";
		int mgr = 7369;
		int deptno = 20;
		Date hiredate = new Date(1981, 2, 20);
		
		String sql = "{ call UP_INSERTEMP(pempno=>?, pename=>?, pmgr=>?, pdeptno=>?, phiredate=>?) }";
		Connection conn = null;
		CallableStatement cstmt = null;
		int rowCount = 0;
		
		conn =  DBconn.getConnection();

		try {
			cstmt = conn.prepareCall(sql);
				cstmt.setInt(1, empno);
				cstmt.setString(2, ename);
				cstmt.setInt(3, mgr);
				cstmt.setInt(4, deptno);
				cstmt.setDate(5, hiredate);
			
			rowCount = cstmt.executeUpdate();	
			
			if( rowCount == 1 ) {
				System.out.println("> 사원 추가 완료!!!");
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		DBconn.close();
		
		System.out.println(" - END - ");
	} // main	

} // class










