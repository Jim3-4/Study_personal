package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

import oracle.jdbc.driver.DBConversion;

/**
 * @author k≡n¡k
 * @date 2022. 5. 4. - 오후 2:15:31
 * @subject
 * @content
 */
public class Ex04 {
 
	public static void main(String[] args) {
		// deptno, dname, empno, ename, hiredate, job, sal, comm, pay, grade 컬럼.. 출력
		//     dept                                    emp                                             salgrade 
		// ArrayList<DeptEmpSalgradeDTO> list
		// printEmp(list) {} 출력..		
		// PreparedStatement 사용.
		// 2:32 풀이~ 
		
		String sql =    "SELECT d.deptno, dname, empno, ename, hiredate, job, sal, comm "
							+ "     , sal + NVL(comm, 0) pay, grade  "
							+ " FROM dept d JOIN emp e ON d.deptno = e.deptno "
							+ "            JOIN salgrade s ON  sal BETWEEN losal AND hisal";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DeptEmpSalgradeDTO> list = null;
		DeptEmpSalgradeDTO dto = null;
		
		conn = DBconn.getConnection();
		try {
			pstmt =  conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				list = new ArrayList<DeptEmpSalgradeDTO>();
				do {
					String dname =  rs.getString("dname");
					String ename =  rs.getString("ename");
					int grade = rs.getInt("grade");
					
					dto = new DeptEmpSalgradeDTO();
					dto.setDname(dname);
					dto.setEname(ename);
					dto.setGrade(grade);
					
					list.add(dto);
					
				} while (rs.next());
			} // if
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		DBconn.close();
		
		printEmp( list );
		
		System.out.println( " - END - ");

	} // main

	private static void printEmp(ArrayList<DeptEmpSalgradeDTO> list) {
		
		Iterator<DeptEmpSalgradeDTO> ir =  list.iterator();
		
		while (ir.hasNext()) {
			DeptEmpSalgradeDTO dto =  ir.next();
			System.out.println( dto );
		}
		
	} // 

} // class








