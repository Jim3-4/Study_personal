package days19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 3:37:40
 * @subject   p431 예제
 * @content 
 */
public class Ex15 {

	public static void main(String[] args)  {
		// 파일 읽어서 화면 출력..
		String fileName = "C:\\temp\\.log";
		// File f = createFile( filePath );
		
		//BufferedReader  br = new BufferedReader(new InputStreamReader(System.in))
		
		String line = "";
		//BufferedReader br = null;
		int lineNumber = 1;
		
		try (FileReader  fr = new FileReader(fileName);
				BufferedReader  br = new BufferedReader(new FileReader(fileName)); 
				Scanner scanner = new Scanner(System.in); ){
			//FileReader  fr = new FileReader(fileName);
			//br = new BufferedReader(new FileReader(fileName));  
			while(  (line = br.readLine()) != null ) {
			     System.out.printf( "%d : %s\n", lineNumber++,  line ); 
			}
		} catch (FileNotFoundException e) { 
			System.out.println("읽고자 하는 파일이 없어요..");
		} catch (IOException e) { 
			e.printStackTrace();
		}  finally {
			/*
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
		}
		

	} // main

} // class



// 복습문제 :    test.html 파일을 읽어서 라인번호를 붙여서 출력하세요( 파일읽기 )
//                  ( try-with-resources문 사용 )






