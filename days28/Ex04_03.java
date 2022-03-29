package days28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 10:48:28
 * @subject  p 879
 * @content            students.txt  파일을 읽어서 출력...
 */
public class Ex04_03 {

	public static void main(String[] args) {
 
		String name ;
		int kor , eng, mat  ;
		int tot;
		double avg ;
		boolean gender;
		 
		String fileName = ".\\src\\days28\\students.txt";
		
		try ( FileReader fr = new FileReader(fileName);
			     BufferedReader br = new BufferedReader(fr)  ;  // 보조스트림  8196 byte 버퍼(기본값)
				){
			String line = "";
			// 박민주,98,78,88,264,88.000000,true           , 로    split()
			while(   ( line = br.readLine() ) != null ) {
				System.out.println( line );
				// 
			} // while
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
		
		System.out.println( " END ");
		
	} // main

} // class













