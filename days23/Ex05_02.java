package days23;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 11:46:40
 * @subject   p 551 
 * @content 
 */
public class Ex05_02 {

	public static void main(String[] args) throws Exception {
		//   12:04 수업시작~
		String tableName = "CUST_INFO";
		String fileName = ".\\src\\days23\\data4.txt";
		String msg = "INSERT INTO " + tableName + " VALUES ({0},{1},{2},{3});";
		
		// 키보드 -> System.in -> Scanner c;
		// Scanner s = new Scanner(System.in);
		
		//  파일 -> 스캐너 
		Scanner s = new Scanner( new File(fileName) );
		
		String pattern = "INSERT INTO CUST_INFO VALUES (''{0}'',''{1}'',{2},''{3}'');"; // 홑따옴표 2개 ''
		// String pattern = "{0},{1},{2},{3}";
		MessageFormat mf = new MessageFormat(pattern );
		
		while (  s.hasNextLine() ) {               // 파일에 읽을 라인이 있니? true / false
			String line = s.nextLine();  // INSERT INTO CUST_INFO VALUES ('김프로','032-333-1234',33,'10-27');
			// System.out.println( line );
			Object [] objs =  mf.parse(line);
			for (Object a : objs) {
				System.out.println( a );
			}
			System.out.println("====================");
		}
		
		s.close();

	} // main

}  // class

/*
이자바
02-123-1234
27
07-09
====================
김프로
032-333-1234
33
10-27
====================
*/


