package days03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.util.DBconn;

/**
 * @author k≡n¡k
 * @date 2022. 5. 4. - 오전 6:23:52
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:50 제출
		// 10:00 수업 시작~
		/*
		1. ConnectionString.properties 파일을 Properties 컬렉션을 사용해서 
		   hostname, sid, user, password 속성값을 읽어서  DB 연동해서 
		   HR의 departments 테이블의 부서 정보를 출력하는 코딩을 하세요.
		   ㄱ. Statement 사용.
		   ㄴ. ArrayList<DepartmentsDTO> list  사용.
		   ㄷ. manager_id 가 NULL 인  부서 정보만 출력.
		 */ 
		String fileName = ".\\src\\com\\util\\ConnectionString.properties";
		String url, user, password;
		
		//C:\SS16Class5\JDBCClass\jdbcPro
		//System.out.println( System.getProperty("user.dir") );
		
		Properties p = new Properties();
		FileReader reader;
		try {
			reader = new FileReader( fileName );
			p.load(reader);
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} 
		
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
		
		// 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<DepartmentsDTO> list = null;
		
		conn = DBconn.getConnection(url, user, password);
		
		// 3. DQL
		String sql = "SELECT *  "
						 + " FROM DEPARTMENTS "
						 + " WHERE manager_id IS NULL";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if ( rs.next() ) {
				list = new ArrayList<DepartmentsDTO>();
				do {
					int department_id = rs.getInt(1);
					String department_name = rs.getString(2);
					int manager_id = rs.getInt(3);
					int location_id = rs.getInt(4);
					
					DepartmentsDTO dto = new DepartmentsDTO(department_id, department_name, manager_id, location_id);
					
					list.add(dto);
				} while (rs.next());
			}  
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		} 
		DBconn.close();
		
		// 출력
		printDEPARTMENTS( list );
		
		System.out.println(" - END - ");
	} // main

	private static void printDEPARTMENTS(ArrayList<DepartmentsDTO> list) {
		 
		Iterator<DepartmentsDTO> ir = list.iterator();
		
		while (ir.hasNext()) {
			DepartmentsDTO dto =  ir.next();
			System.out.println( dto );
		}
		
	}

} // class











