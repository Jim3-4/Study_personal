package days03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

import days02.DeptDTO;

/**
 * @author k≡n¡k
 * @date 2022. 5. 4. - 오전 10:49:03
 * @subject   [PreparedStatement] 설명.
 * @content   - 하나의 PreparedStatement 객체로 쿼리를 여러 번 처리할 수 있다. ( 재사용 )
 *                       망치                                   망치
 *                       망치
 *                       망치
 *                       
 *                       객체생성 X 
 */
public class Ex02 {

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

		conn = DBconn.getConnection(); // DB Open(연결성공)

		while(true) {  // 무한루프
			메뉴출력();
			메뉴선택();
			메뉴처리();
		} // while


	} // main

	private static void 메뉴출력() { 
		System.out.println("\n\n\n\n\n\n");
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

		switch ( selectedNumber ) {
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
				+ " FROM dept ";

		// REGEXP_LIKE() 코딩이 쉬워진다. 
		if ( searchCondition == 1 ) {  // 부서명
			sql += " WHERE dname LIKE ? " ;
		} else if ( searchCondition == 2 ) {  // 지역명
			sql += " WHERE loc LIKE ? " ;
			// sql += " WHERE  REGEXP_LIKE( loc , ? , 'i'  ) " ;
		}else if ( searchCondition == 3 ) {  // 부서명 + 지역명
			sql += " WHERE dname LIKE ? OR loc  LIKE ? ";
		}		
		sql  += " ORDER BY deptno ASC";

		//			System.out.println( sql );

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<DeptDTO>  deptList = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 1, 2 =>  ? 파라미터 설정
			// 3   =>   ? , ?  파라미터 설정
			searchWord = "%" + searchWord +"%"; 
			if( searchCondition == 3 ) {   // ? ? 
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
			}else {   //  ? 
				pstmt.setString(1, searchWord);
			}
			
			rs = pstmt.executeQuery(); // DQL문   rs null java.lang.NullPointerException

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
				pstmt.close(); // *****
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

		String sql =  "DELETE FROM dept " 
						  + " WHERE deptno = ? ";
		// System.out.println( sql );

		PreparedStatement pstmt = null;		
		try {
			pstmt =  conn.prepareStatement(sql);
			// ? 파라미터 설정
			pstmt.setInt(1, pdeptno);
			int  rowCount = pstmt.executeUpdate();
			
			// (기억) AutoCommit 된다. 			
			if( rowCount == 1 ) {
				System.out.printf("> %d번 부서 삭제 완료!!!\n", pdeptno);
			}		 
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			} // try
		} // try

		일시정지();
	}

	// 12:02 + 5 수업시작
	private static void updateDept() {
		System.out.print("> 수정할 부서번호(deptno) 입력 ? ");
		int pdeptno = scanner.nextInt();
		System.out.print("> 수정할 부서명 지역명을 입력 ? ");
		String pdname = scanner.next();
		String ploc = scanner.next();

		
		String sql =  "UPDATE dept "
						+ " SET dname = ?, loc = ? "
						+ " WHERE deptno = ? " ;
		// System.out.println( sql );

		PreparedStatement pstmt = null;
		
		try {
			pstmt =  conn.prepareStatement(sql);
			// dname ?   loc  ?   deptno ? 파라미터 설정
			pstmt.setString(1, pdname);
			pstmt.setString(2, ploc);
			pstmt.setInt(3, pdeptno);
			
			int  rowCount = pstmt.executeUpdate();			
			// (기억) AutoCommit 된다. 			
			if( rowCount == 1 ) {
				System.out.printf("> %d번 부서 수정 완료!!!\n", pdeptno);
			}		 
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
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
			//String sql =  String.format("INSERT INTO dept (deptno, dname, loc ) VALUES (   seq_dept.NEXTVAL  ,  '%s', '%s')"
			//		, pdname, ploc);
			
			//  PreparedStatement :    ?  바인딩 변수를 사용한다. 
			// '?' 날짜, 문자열  X
			String sql = "INSERT INTO dept (deptno, dname, loc ) VALUES (   seq_dept.NEXTVAL  , ? , ? )";
			
			//System.out.println( sql );		
			// Statement stmt = null;		
			PreparedStatement pstmt = null;
			
			try {
				// stmt =  conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				// 에러메시지 : java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
				// int  rowCount = stmt.executeUpdate(sql); // DML문( insert, update, delete )
				
				// ? , ?  입력용, 출력용 파라미터(매개변수)값을  설정하고 나서  executeUpdate()
				pstmt.setString(1,  pdname);
				pstmt.setString(2,  ploc);
				
				int rowCount = pstmt.executeUpdate();  // 영향받은 레코드 수  int rowCount
				
				// (기억) AutoCommit 된다. 			
				if( rowCount == 1 ) {
					System.out.println("> 1개 부서 추가 완료!!!");
				}		 
			} catch (SQLException e) { 
				e.printStackTrace();
				// seq_dept 새로 동적으로 50번 시작할 수 있도록 생성 - 동적 쿼리
			} finally {
				try {
					pstmt.close();
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

		// Statement stmt = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;

		ArrayList<DeptDTO>  deptList = null;

		try {
			// stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);  // 주의 sql
			
			//rs = stmt.executeQuery(sql); // DQL문   rs null java.lang.NullPointerException
			rs = pstmt.executeQuery();

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
				// stmt.close(); // *****
				pstmt.close();
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

