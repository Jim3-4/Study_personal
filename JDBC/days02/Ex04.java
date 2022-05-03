package days02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오후 12:35:52
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		 // 문제 5) 부서번호를 입력받아서 해당 부서원의 정보 출력
		 // ArrayList<EmpDTO> list 
		 // printEmp( ArrayList ) 메서드 출력 
		
		// 풀이) 
		// 1. EmpDTO 클래스 추가
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		int pdeptno = 10;
		ArrayList<EmpDTO>  list = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 부서(deptno) 입력 ? ");
		pdeptno = scanner.nextInt();
				
		String sq = "SELECT * "
				       + " FROM emp"
				       + " WHERE deptno = " + pdeptno;
		
		conn =  DBconn.getConnection();
	
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sq);
			
			if ( rs.next()) {
				list = new ArrayList<EmpDTO>();
				do {
					int empno =  rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate =  rs.getDate("hiredate");
					double sal = rs.getDouble("sal");
					double comm = rs.getDouble("comm");
					int deptno = rs.getInt("deptno");
					
					EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					
					list.add(dto);
					
				} while ( rs.next());
				
			}  // if
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}  // try

        DBconn.close();
        
        printEmp( list );
        
        System.out.println( " - END - ");
	} // main

	private static void printEmp(ArrayList<EmpDTO> list) {
		
		if( list == null ) {
			System.out.println("사원 존재 X");
			return ;
		}
		
		Iterator<EmpDTO> ir =  list.iterator();
		while (ir.hasNext()) {
			EmpDTO dto = ir.next();
			System.out.println( dto );  // toString() 오버라이딩.
		}
	} // printEmp

} // class











