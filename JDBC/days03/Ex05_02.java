package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 4. - 오후 2:54:29
 * @subject   
 * @content
 */
public class Ex05_02 {

	public static void main(String[] args) { 
		String sql =   "SELECT  grade ,    losal ,   hisal  , COUNT(*) cnt "
				+ "FROM salgrade s JOIN emp e ON  sal BETWEEN losal AND hisal "
				+ "GROUP BY grade ,    losal ,   hisal "
				+ "ORDER BY grade ASC";
		
		String empSql = "SELECT   d.deptno, dname,  empno, ename,  sal "
				+ "        , grade "
				+ "FROM dept d RIGHT JOIN emp e ON d.deptno = e.deptno "
				+ "            JOIN salgrade s ON sal BETWEEN losal AND hisal "
				+ "WHERE grade = ? ";
		
		PreparedStatement pstmt = null, empPstmt = null;
		ResultSet rs = null, empRs = null;
		Connection conn = null;
		ArrayList<SalgradeDTO> list = null;
		SalgradeDTO dto = null;
		DeptEmpSalgradeDTO empDto = null;
		
		conn = DBconn.getConnection();
		try {
			pstmt =  conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();

			if( rs.next() ) {
				list = new ArrayList<>();
				do { 
					int grade = rs.getInt("grade");
					int losal = rs.getInt("losal");
					int hisal = rs.getInt("hisal");
					int cnt = rs.getInt("cnt");

					dto =  new SalgradeDTO(grade, losal, hisal, cnt);

					list.add(dto);
					
					System.out.println( dto );  //  1 등급	(     700~1200 ) - 2명

					// [START]
				   	//20	RESEARCH	7369	SMITH	800
				   	//30	SALES			7900	JAMES	950
					empPstmt = conn.prepareStatement(empSql);
					// ?
					empPstmt.setInt(1, grade);
					empRs =  empPstmt.executeQuery();
					
					if ( empRs.next() ) {
						do {
							// d.deptno, dname,  empno, ename,  sal
							int deptno = empRs.getInt(1);
							String dname = empRs.getString(2);
							int empno = empRs.getInt(3);
							String ename = empRs.getString(4);
							double sal = empRs.getDouble(5);
							
							System.out.printf("\t\t%d\t%s\t%d\t%s\t%.2f\n"
									, deptno, dname, empno, ename, sal);
							
						} while (empRs.next());
					} else {
						System.out.println("\t\t 사원 존재 X ");
					}
					
					empPstmt.close();
					empRs.close();
					
					// [END]
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

		// printSalgrade( list );

		System.out.println( " - END - ");

	} // main

	private static void printSalgrade(ArrayList<SalgradeDTO> list) {

		Iterator<SalgradeDTO> ir =  list.iterator();

		while (ir.hasNext()) {
			SalgradeDTO dto =  ir.next();
			System.out.println( dto );
		}

	} // 

} // class

/*
[실행결과]
1등급	(     700~1200 ) - 2명 
      SELECT   d.deptno, dname,  empno, ename,  sal
        , grade
	 FROM dept d JOIN emp e ON d.deptno = e.deptno
	            JOIN salgrade s ON sal BETWEEN losal AND hisal
	WHERE grade =1     ;
2등급	(	1201~1400 ) - 2명 
	SELECT   d.deptno, dname,  empno, ename,  sal
	        , grade
	FROM dept d JOIN emp e ON d.deptno = e.deptno
	            JOIN salgrade s ON sal BETWEEN losal AND hisal
	WHERE grade = 2     ;

3등급	(	1401~2000 ) - 2명 
4등급	(	2001~3000 ) - 4명 
5등급	(	3001~9999 ) - 1명    
 */

/*
[실행결과]
1등급	(     700~1200 ) - 2명
   	20	RESEARCH	7369	SMITH	800
   	30	SALES			7900	JAMES	950
2등급	(	1201~1400 ) - 2명
	30	SALES	7654	MARTIN	2650
	30	SALES	7521	WARD		1750	
3등급	(	1401~2000 ) - 2명
	30	SALES	7499	ALLEN		1900
	30	SALES	7844	TURNER	1500
4등급	(	2001~3000 ) - 4명
    10	ACCOUNTING	7782	CLARK	2450
	20	RESEARCH	7902	FORD	3000
	20	RESEARCH	7566	JONES	2975
	30	SALES	7698	BLAKE	2850
5등급	(	3001~9999 ) - 1명   
	10	ACCOUNTING	7839	KING	5000
 */