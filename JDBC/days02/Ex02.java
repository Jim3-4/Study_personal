package days02;

import java.sql.Connection;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오전 10:54:43
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// 11:05 수업 시작~
		// 클래스 라이브러리 생성 :  com.util.DBconn.java
		// hr , lion 
		
		// com.util 패키지 안에  파일 추가 : ConnectionString.properties
		
		
		/*
		Connection conn =  DBconn.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "lion") ;		
		System.out.println( conn ); 
		DBconn.close();
		*/
		
		/*
		// X DBconn dbconn= new DBConn();
		Connection conn =  DBconn.getConnection();		
		System.out.println( conn );
		// System.out.println( conn.isClosed() );		
		DBconn.close();
		
		// 한 번 더 connection 객체를 얻어와서 출력
       conn =  DBconn.getConnection();
		System.out.println( conn );
		// System.out.println( conn.isClosed() );		
		DBconn.close();
		
		System.out.println( " END ");
		*/

	} // main

} //  class














