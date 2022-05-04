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
 * @date 2022. 5. 4. - 오전 10:22:42
 * @subject
 * @content
 */
public class Ex01_02 {

	public static void main(String[] args) {
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
		ArrayList<Jobs> list = null;
		
		conn = DBconn.getConnection(url, user, password);
		
		// 3. DQL
		String sql = "SELECT  REPLACE( job_id , 'RE', '[RE]' ) job_id "
						+ "        , REGEXP_REPLACE( job_title , '(RE|Re|rE|re)' , '[\\1]' ) job_title "
						+ "FROM jobs "
						+ "WHERE REGEXP_LIKE(  job_id , 'RE' , 'i' ) OR REGEXP_LIKE(  job_title , 'RE' , 'i' )";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if ( rs.next() ) {
				list = new ArrayList<>();
				do {
					String job_id = rs.getString(1);
					String job_title = rs.getString(2); 
					
					Jobs dto = new Jobs(job_id, job_title, 0, 0);
					
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

	private static void printDEPARTMENTS(ArrayList<Jobs> list) {
		 
		Iterator<Jobs> ir = list.iterator();
		
		while (ir.hasNext()) {
			Jobs dto =  ir.next();
			System.out.println( dto );
		}
		
	}

} // class

/*
2. HR의 jobs 테이블에서 job_id 컬럼 또는  job_title 컬럼에 
'RE' 또는 're' 또는  'Re' 또는 'rE' ( 즉, 대소문자 구분 없이 ) 문자열을 포함하는 레코드를 
검색해서 아래와 같이 출력하세요. 
 
JOB_ID 													JOB_TITLE   
--------------------------------------------------------------                                          
AD_P[RE]S											P[re]sident
AD_VP												    Administration Vice P[re]sident
SA_[RE]P												Sales [Re]p[re]sentative
MK_[RE]P											Marketing [Re]p[re]sentative
HR_[RE]P												Human [Re]sources [Re]p[re]sentative
PR_[RE]P												Public [Re]lations [Re]p[re]sentative                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  

6개 행이 선택되었습니다.      

  */