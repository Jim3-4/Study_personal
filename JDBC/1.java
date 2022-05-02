package days01;

/**
 * @author k≡n¡k
 * @date 2022. 5. 2. - 오후 2:23:47
 * @subject JDBC 수업 1일차 
 * @content   jdbcPro 자바프로젝트 생성  및 환경 설정.
 */
public class Ex01 {

	public static void main(String[] args) {
		System.out.println("이창익");
		
		/*
		 * 1. JDBC
		 *     ㄱ. [J]ava [D]ata[B]ase [C]onnectivity
		 *     ㄴ. 자바 표준 인터페이스 - DBMS 연동 + 작업(CRUD)
		 *     ㄷ. DataBase 연동 기술
		 *     
		 * 2.     Java 응용 프로그램            +             오라클 DBMS 연동
		 *                                           JDBC
		 *       ㄱ.                                오라클사에서     JDBC을 구현한 드라이버(driver) 가      OracleDriver 다운 받아야 된다.
		 *        ㄴ.            ojdbc6.jar 파일이                  OracleDriver  이다.  
		 * 3. JDBC Driver ?
		 *    MySQL
		 *    MS SQL
		 *    Oracle    
		 *    
		 *  4. JDBC Driver 종류
		 *    ㄱ.  Type1 - ODBC Drirver 브릿지 사용 연동
		 *    ㄴ.  Type2 - Native Library  C, C++로 만든 라이브러리로 DB 연동.
		 *    ㄷ.  Type3 - 미들웨어 서버 
		 *    ㄹ.  Type4 - Thin 드라이버, 순수 자바 만들어짐, DBMS 직접 연결, 가장 많이 사용된다. ***** 
		 *    
		 * 5.  3:05 수업 시작  
		 * 
		 *  6. DBMS 연결(Connection)하는 순서 *** (암기)   Ex02.java
		 *     1) Class.forName() 드라이브(JDBC Drvier) 로딩
		 *     2) DriverManager 클래스의 getConnection() 메서드를 사용해서  Connection객체를 얻어온다. 
		 *         어떤 DB서버 연결
		 *         어떤 계정
		 *         계정 비밀번호
		 *         포트
		 *         등등
		 *     3) 필요한(질의응답) 작업 - CRUD
		 *     4) 연결종료 ( Connection 객체 close )
		 * */

	} // main

} // class






