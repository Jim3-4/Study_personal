package days02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 3. - 오전 11:39:45
 * @subject
 * @content
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// ConnectionString.properties 파일을 읽어서 url, user, password 가져와서
		// Connection 객체를  DBConn 클래스를 사용해서 얻어오는 코딩...
		// Properties 컬렉션 클래스  
		//  ㄴ Map 인터페이스를 구현한 클래스
		//  ㄴ key + value 한쌍  entry 
		//  ㄴ String/String
		//  ㄴ 파일 저장/읽기 메서드 
		
		// [복습] JavaClass - days26.Ex06.java부터 있습니다!
		Properties p = new Properties();
		
		String fileName = ".\\src\\com\\util\\ConnectionString.properties";
		Reader reader;
		try {
			reader = new FileReader(fileName);
			p.load(reader);
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			Connection conn = DBconn.getConnection(url, user, password);
			
			System.out.println( conn );
			
			DBconn.close();
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}

		System.out.println(" END ");

	} // main

} // class









