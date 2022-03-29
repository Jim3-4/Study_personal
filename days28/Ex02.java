package days28;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 9:25:03
 * @subject  p 931 예제 15-37
 * @content   지정된 파일을 지정된 크기로 잘라서 여러 개의 파일로 저장.
 */
public class Ex02 {

	public static void main(String[] args) {
	//  	8시간 에러.. 고생.
	  // flush() : 저장, 스트림 비우는 메서드
	  // close() : 선( flush() - 저장 ) 후 닫기
		
		// (427,614 바이트)
		String pathname = "C:\\Users\\redke\\OneDrive\\문서\\자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf";
		final int VOLUME = 100000;
		File f = new File(pathname);
		System.out.println("> 파일 크기 : " +  f.length() + " bytes");
		
		FileOutputStream  fos = null;
		BufferedOutputStream bos = null;
		
		int data = 0 ;  // 1바이트 읽어서 저장하는 변수
		int i = 0 ;         // 읽은 바이트 수를 카운트 ==  VOLUME  10만 바이트   저장하고 새로운  fos, bos 생성
		int number = 0; // _.1  _.2
		
		// ??.pdf -> 읽기 스트림 ( fis/bis ) ->  while( data=   bis.read() ) --> VOLUME   bos.close 저장
		try(
				FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis);
				) {
			
			     // i = 0             파일스트림 저장 X ,   fos, bos 객체 생성    _.1
			    // i=  100000   파일스트림 저장 _.1   fos, bos 객체 생성    _.2
			// i=  200000   파일스트림 저장 _.2   fos, bos 객체 생성    _.3
			// i=  300000   파일스트림 저장 _.3   fos, bos 객체 생성    _.4
			// i=  400000   파일스트림 저장 _.4   fos, bos 객체 생성    _.5
			// i =27,614파일스트림 저장 _.5                                       fos, bos 객체 생성    _.6
		         while(   (data =	bis.read()) != -1 ) {
		        	 if( i % VOLUME == 0) {
		        		 if( i != 0 ) bos.close(); // 파일스트림 저장
		        		 fos = new FileOutputStream(   pathname+"_." +  (++number)  );
		        		 bos = new BufferedOutputStream(fos);
		        	 } // if
		        	 bos.write( data);
		        	 i++;
		         } // while
		         
		         System.out.println(" END ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		

	} // main

} // class
