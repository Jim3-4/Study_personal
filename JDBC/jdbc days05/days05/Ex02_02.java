package days05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 10. - 오후 3:20:27
 * @subject    트랜잭션 처리 한 상태.
 * @content
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// [ 트랜잭션 처리 - 자바 JDBC ]
		// 하나의 논리적인 작업 단위  모두 완료(성공) - 커밋
		//                                        모두 완료 X      - 롤백
		// 예) [ 계좌 이체 ]  1) + 2)
		//        1) A 돈을 인출
		//        2) B 인출된 돈을 입금


		// 2) dept 부서테이블 90/XX/YY   추가 - 실패

		Connection conn = null;
		conn = DBconn.getConnection();

		PreparedStatement pstmt = null;
		int rowCount = 0;

		String sql = "INSERT INTO dept VALUES ( ? , ? , ? )";

		try {
			
conn.setAutoCommit(false); //  ㄱ.
			
			// 1) dept 부서테이블 90/QC/SEOUL 추가 - 성공 -> 추가취소
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "QC");
			pstmt.setString(3, "SEOUL");
			rowCount = pstmt.executeUpdate();
			if( rowCount == 1 ) {
				System.out.println(" 1) dept 부서테이블 90/QC/SEOUL 추가 - 성공  !!! ");
			}

			// 2) dept 부서테이블 90/XX/YY   추가 - 실패
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "XX");
			pstmt.setString(3, "YY");
			rowCount = pstmt.executeUpdate();
			if( rowCount == 1 ) {
				System.out.println(" 2) dept 부서테이블 90/XX/YY 추가 - 성공  !!! ");
			}

conn.commit();  // ㄴ
		} catch (SQLException e) { 
			e.printStackTrace();
try {                // ㄷ
	conn.rollback();
} catch (SQLException e1) { 
	e1.printStackTrace();
}
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}	
		} 


		DBconn.close();

		System.out.println(" - END - ");
	} // main

} // class










