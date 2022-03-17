package days19;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 4:10:18
 * @subject p 436 자동 자원 반환  try-with-resources문
 * @content    JDK1.7 ~
 *                     주로 IO(입출력)과 관련된 클래스 사용할 때 유용하다. 
 */
public class Ex17 {

	public static void main(String[] args) {
		/*
		// Resource leak: 'scanner' is never closed
		// 리소스(자원) 누출: 스캐너가 닫히지 않았다.		
		Scanner scanner = new Scanner(System.in); 
	    //
		//
		scanner.next();
		//
		//
		// 
		scanner.close(); // 자원 반환(닫기)
		*/
		
		// try-with-resources 문  자동 자원 반환
		try(  Scanner scanner = new Scanner(System.in) ){
			 //
			//
			scanner.next();
			//
			//
			//
			// X scanner.close();
		} finally {
			
		}
		
	} // main

} // class












