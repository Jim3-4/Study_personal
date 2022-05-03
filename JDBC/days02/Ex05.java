package days02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오후 2:33:12
 * @subject
 * @content // DQL문
 *					 // DML문 
 *					 // dept 테이블에 DQL문, DML문  사용하는 예제.
 */
public class Ex05 {

	private static Connection conn = null;
	private static String [] menus = { 
			"부서 조회",
			"부서 추가",
			"부서 수정",
			"부서 삭제",
			"부서 검색",
			"종료"
	};
	private static int selectedNumber ;
	private static Scanner scanner = new Scanner(System.in);
	private static char _continue = 'Y';

	public static void main(String[] args) {

		conn = DBconn.getConnection();

		while(true) {
			메뉴출력();
			메뉴선택();
			메뉴처리();
		} // while


	} // main

	private static void 메뉴출력() { 
		System.out.println("> 메뉴 출력 < ");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s\n", (i+1), menus[i]);
		} // for
	} // 메뉴 출력

	private static void 메뉴선택() {		
		System.out.print("> 메뉴 선택하세요 ? ");
		selectedNumber = scanner.nextInt();
	}

	private static void 메뉴처리() { 

		switch ( selectedNumber) {
		case 1 : // 조회
			selectAllDept();  // rs = stmt.executeQuery();
			break;
		case 2 : // 추가
			insertDept();   // int  stmt.executeUpdate();
			break;
		case 3 : // 수정    4:08 수업시작
			updateDept(); // stmt.executeUpdate();
			break;
		case 4: // 삭제
			deleteDept();  // stmt.executeUpdate(); 
			break;
		case 5 : // 검색
			searchDept();
			break;
		case 6 : // 종료
			exit();
			break;
		default:
			break;
		}


	} // 메뉴 처리

	private static void searchDept() {
		// 문제)  4:50 풀이
		// 검색 조건   1) 부서명  2)지역명  3) 부서명 또는 지역명 
		// 검색어   :  "O"
		// SELECT  조회
		System.out.println("[검색 조건 ]");
		System.out.println("1. 부서명");
		System.out.println("2. 지역명");
		System.out.println("3. 부서명 + 지역명"); 
		
		System.out.print("> 검색 조건 선택하세요 ? ");
		int searchCondition = scanner.nextInt();
		
		System.out.print("> 검색어 입력  ? ");
		String searchWord  = scanner.next();
		
		
		// selectAllDept 복사 + 붙이기
		String sql = "SELECT * "
				+ " FROM dept";
       
		 // REGEXP_LIKE() 코딩이 쉬워진다. 
		 if ( searchCondition == 1 ) {  // 부서명
			sql += String.format( " WHERE dname LIKE '%s' " , "%"+ searchWord +"%");
		} else if ( searchCondition == 2 ) {  // 지역명
			sql += String.format( " WHERE loc LIKE '%%%s%%'" , searchWord );
		}else if ( searchCondition == 3 ) {  // 부서명 + 지역명
			sql += String.format( " WHERE dname LIKE '%%%1$s%%' OR loc  LIKE '%%%1$s%%'" , searchWord );
		}		
				sql  += " ORDER BY deptno ASC";
		
	 //			System.out.println( sql );
	 
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<DeptDTO>  deptList = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // DQL문   rs null java.lang.NullPointerException

			if ( rs.next() ) {						
				deptList = new ArrayList<DeptDTO>();				
				do {
					int deptno = rs.getInt(1);
					String dname =  rs.getString(2);
					String loc =  rs.getString(3);

					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					
					deptList.add(dto);

				} while (  rs.next() );				
			}  // if
			
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
		
		// DBconn.close(); 접속 종료

		// ArrayList 출력
		printDept( deptList );

 
		일시정지();
		
	} // 

	private static void deleteDept() {
		// 문제) 삭제할 부서번호를 입력받아서 삭제하는 코딩을 작성하세요.
		System.out.print("> 삭제할 부서번호(deptno) 입력 ? ");
		int pdeptno = scanner.nextInt();
		
		String sql = String.format(
				   "DELETE FROM dept " 
				+ " WHERE deptno = %d"
				,  pdeptno);
		// System.out.println( sql );
		
		Statement stmt = null;		
		try {
			stmt =  conn.createStatement();			 
			int  rowCount = stmt.executeUpdate(sql); // DML문( insert, update, delete )			
			// (기억) AutoCommit 된다. 			
			if( rowCount == 1 ) {
				System.out.printf("> %d번 부서 삭제 완료!!!\n", pdeptno);
			}		 
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			 try {
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			} // try
		} // try
		
		일시정지();
	}

	private static void updateDept() {
		System.out.print("> 수정할 부서번호(deptno) 입력 ? ");
		int pdeptno = scanner.nextInt();
		System.out.print("> 수정할 부서명 지역명을 입력 ? ");
		String pdname = scanner.next();
		String ploc = scanner.next();
		
		String sql = String.format(
				   "UPDATE dept "
				+ " SET dname = '%s', loc = '%s' "
				+ " WHERE deptno = %d"
				, pdname, ploc, pdeptno);
		// System.out.println( sql );
		
		Statement stmt = null;		
		try {
			stmt =  conn.createStatement();			 
			int  rowCount = stmt.executeUpdate(sql); // DML문( insert, update, delete )			
			// (기억) AutoCommit 된다. 			
			if( rowCount == 1 ) {
				System.out.printf("> %d번 부서 수정 완료!!!\n", pdeptno);
			}		 
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			 try {
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			} // try
		} // try
		
		일시정지();
	} // updateDept

	// 부서 추가
	private static void insertDept() {
		
		do {
			// deptno, dname, loc
			System.out.println("[부서 정보 입력]");
			System.out.print("1. 부서명 입력 ? ");
			String pdname = scanner.next();
			System.out.print("2. 지역명 입력 ? ");
			String ploc = scanner.next();
			
			//String sql = "INSERT INTO dept (deptno, dname, loc ) VALUES (   seq_dept.NEXTVAL  ,  '" + pdname +"', '" + ploc +"')";
			String sql =  String.format("INSERT INTO dept (deptno, dname, loc ) VALUES (   seq_dept.NEXTVAL  ,  '%s', '%s')"
					, pdname, ploc);		
			//System.out.println( sql );		
			Statement stmt = null;		
			try {
				stmt =  conn.createStatement();			 
				int  rowCount = stmt.executeUpdate(sql); // DML문( insert, update, delete )			
				// (기억) AutoCommit 된다. 			
				if( rowCount == 1 ) {
					System.out.println("> 1개 부서 추가 완료!!!");
				}		 
			} catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				 try {
					stmt.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				} // try
			} // try
			
			계속여부확인();
		} while (  Character.toUpperCase(_continue) == 'Y'); 
		
		일시정지();
	} // insertDept

	
	
	private static void 계속여부확인() {
	     System.out.println("> 계속 할거냐 ? ");
	     try {
			_continue =  (char) System.in.read();
			System.in.skip(System.in.available()) ; // 13 , 10
		} catch (IOException e) { 
			e.printStackTrace();
		}
	} // 계속 여부 확인

	// 모든 부서 정보 조회
	private static void selectAllDept() {
		String sql = "SELECT * "
				+ " FROM dept"
				+ " ORDER BY deptno ASC";
		
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<DeptDTO>  deptList = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // DQL문   rs null java.lang.NullPointerException

			if ( rs.next() ) {						
				deptList = new ArrayList<DeptDTO>();				
				do {
					int deptno = rs.getInt(1);
					String dname =  rs.getString(2);
					String loc =  rs.getString(3);

					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					
					deptList.add(dto);

				} while (  rs.next() );				
			}  // if
			
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
		
		// DBconn.close(); 접속 종료

		// ArrayList 출력
		printDept( deptList );

		일시정지();
	} // selectAllDept

	private static void 일시정지() {
		 System.out.println("\t\t 엔터치면 계속합니다.");
		 try {
			System.in.read();
			System.in.skip(  System.in.available() );  // 13, 10
		} catch (IOException e) { 
			e.printStackTrace();
		}
	} // 일시정지

	private static void printDept(ArrayList<DeptDTO> deptList) {
		
		System.out.println("---------------------------");
		System.out.printf("%s\t%s\t%s\n", "DEPTNO", "DNAME", "LOC");
		System.out.println("---------------------------");

		if( deptList == null ) {
			System.out.println("\t부서 존재 X");			
			return ;
		}
		
		Iterator<DeptDTO> ir = deptList.iterator();

		while (ir.hasNext()) {
			DeptDTO dto =  ir.next();
			System.out.println( dto );			
		} // while
		System.out.println("---------------------------");

	} // printDept

	private static void exit() {

		System.out.println("\t\t 프로그램 종료됩니다.");
		DBconn.close(); // DB 닫기
		System.exit(-1);

	} // exit  

} // class


// java.sql.SQLRecoverableException: 접속 종료


