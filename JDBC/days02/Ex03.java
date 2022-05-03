package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오후 12:03:11
 * @subject
 * @content  JSP/Servlet 
 *                    1. dept 테이블의 모든 부서정보를 가져와서             ArrayList 컬렉션 클래스 저장
 *                    2. 부서정보출력하는 메서드 
 *                        printDept(ArrayList  list){
 *                            // 부서 정보 출력
 *                        }
 */
public class Ex03 {

	public static void main(String[] args) {
		
		String sql = "SELECT * "
				        + " FROM dept";
		Statement stmt = null;
		ResultSet rs = null;
		 
		ArrayList<DeptDTO>  deptList = null;
		
		Connection conn =  DBconn.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // DQL문
			
			if ( rs.next() ) {						
				deptList = new ArrayList<DeptDTO>();				
				do {
					int deptno = rs.getInt(1);
					String dname =  rs.getString(2);
					String loc =  rs.getString(3);
					
					// System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);  --> ArrayList 저장
					// DTO
					// 계층(layer) 간에 데이터 저장*전송 객체
					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					deptList.add(dto);
					
				} while (  rs.next() );				
			} else {
				System.out.println(" 부서 존재 X");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();     // *****
				stmt.close(); // *****
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		} // try		
		DBconn.close();
		
		
		// ArrayList 출력
		printDept( deptList );
		
		System.out.println("- END -");
	} // main

	private static void printDept(ArrayList<DeptDTO> deptList) {
		
		Iterator<DeptDTO> ir = deptList.iterator();
		
		while (ir.hasNext()) {
			DeptDTO dto =  ir.next();
			System.out.println( dto );
		} // while
		
	} // printDept

} // class












