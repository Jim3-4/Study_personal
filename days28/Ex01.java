package days28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

// 510차이
/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 7:27:02
 * @subject  
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// >28	2022-03-29(화)<
		// p 915~930  File 클래스 수업 완료. 
		// p 931~
		// p 868~
		
		// 실행 파일 ( exe ) 복사 		
		String pathname = "C:\\Program Files (x86)\\EditPlus 3\\editplus.exe";
		String copyPathname = "C:\\Users\\redke\\OneDrive\\문서\\editplus.exe";
		
		// > 처리 시간 : 7374200 ns  -  파일(2941 bytes) 복사 완료!!
		fileCopy_byteStream(pathname, copyPathname);
		

	} // main

	private static void fileCopy_byteStream(String pathname, String copyPathname) {
       long start =  System.nanoTime();		
		File f1 = new File(pathname);  
		PrintStream ps = System.out;  // 화면에 출력하는 스트림 객체  , 바이트스트림
		try(
				FileInputStream fis = new FileInputStream(f1);
				FileOutputStream fos = new FileOutputStream(copyPathname);
				){
			int b ;
			 while( ( b = fis.read() ) != -1) {
				 //ps.write(b);
				 //ps.println(b);
				 fos.write(b);  // 파일로 복사
			 }
			
		}catch (Exception e) {
			e.printStackTrace();
		} // try
		
		long end =  System.nanoTime();
		
		// > 처리 시간 : 48901880400 ns  -  파일(2385496 bytes) 복사 완료!!
		System.out.println( "> 처리 시간 : " + (end-start) +" ns  -  파일("+ f1.length() +" bytes) 복사 완료!!");
	
		// 네트워크 - 파일전송   바이트->바이트
	}

} // class


/*
 * 1. 스트림(stream) ?
 * 2. 스트림 종류
 *    ㄱ. 방향  : 입력(Input), 출력(Output) 
 *    ㄴ. 대상  **** ( 암기 )
 *         1)
 *         2)
 *  3. 스트림 == 빨대( 연결통로 )
 *  4. 파일 ->       파일 복사               ->   파일
 *                                                       ->   화면(콘솔) 출력
 *     실행파일X
 *     텍스트파일  FileReader FileWriter
 *                        BufferedReader, BufferedWriter 보조 스트림
 *                        br.readLine()  한 라인 씩 처리..                                                          
 * */





/*
 *                      [C 9 유용한 클래스 - 자주]    
 *                      C 10 날짜/시간 
 *                     C 11 컬렉션 프레임워크 
 *                     C 12 지네릭스,열거형, 어노테이션 @override
 *                     
 *                       ***** 월/화 C 15 입출력(I/O)  ***** 
 *                      C 13 스레드
 *                      C 16 네트워크 (수)           팀프로젝트 - 목/금/토/일       (월) 발표 오라클 수업..
 */

