package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오전 6:28:15
 * @subject  문제 5번 풀이
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		// DB 연동 순서

		String className = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String password = "tiger";
		Connection conn = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("부서 번호를 입력하세요 >>");
		int vdeptno = sc.nextInt();

		
		// java.sql.SQLSyntaxErrorException: ORA-00904: "NAME": invalid identifier
		// 쿼리 문법 오류
		String sql = "SELECT * "
				          + " FROM emp "
				          + " WHERE deptno =" + vdeptno 
				          +"ORDER BY ename ASC";  

		Statement  stmt = null;

		try {
			 
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);		 
			stmt = conn.createStatement();			
			ResultSet  rs = stmt.executeQuery(sql);   
		
			// 1 empno  2 ename 3 job 4 mgr 5 hiredate 6 sal 7 comm 8 deptno
			// boolean rs.next() 리절트셋 안에 다음 레코드가 있니?  true/ false
			if( rs.next() ) {
				
				do {
					
					int empno = rs.getInt(1);  // 7499	
					String ename = rs.getString(2); // ALLEN
					String job = rs.getString(3);	 // SALESMAN
					int mgr = rs.getInt("mgr");
					// HIREDATE          DATE    
					String hiredate = rs.getString(5);
					// 에러메시지 java.sql.SQLException: 부적합한 열 유형: getInt not implemented for class oracle.jdbc.driver.T4CDateAccessor
					// int sal = rs.getInt(5);
					double sal = rs.getDouble("sal");				
					double comm = rs.getDouble(7);				
					int deptno = rs.getInt(8);
					// java.util.IllegalFormatConversionException: d != java.lang.Double
					// 3.14   %f   Conversion				
					System.out.printf("%d\t%s\t%s\t%d\t%s\t%.2f\t%.2f\t%d\n"
							, empno, ename, job, mgr, hiredate, sal, comm, deptno);
					
				} while ( rs.next());
				
				
			}else {
				System.out.println(" 해당 부서의 사원이 존재하지 않습니다. ");
			}

		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); 
				conn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			} //try			
		} // finally 

		System.out.println( " END ");
	} // main

} // class
