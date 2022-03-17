package days19;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 3:08:07
 * @subject   p 427 메서드에 예외 선언하기 
 * @content   throw 강제 예외 발생 문
 *                      throws 메서드에  예외 선언하기 ***
 *                      
 *                      4시 쉬는 시간 : p 426    
 *                      컴파일러가 예외 처리를 확인하지 않는 RuntimeException " unchecked 예외 "
 *                                                              하는           Exception             "checked 예외"
 *                      
 *                      [ 자바 예외 처리 방법 ]
 *                      1.  try~ catch 문 
 *                      2. throws 문 사용
 */
public class Ex13 {

	public static void main(String[] args) throws IOException{
		
		// IOException 처리
	    try {
			int one = System.in.read();
		} catch (IOException e1) { 
			e1.printStackTrace();
		}   
		
		// 
		try {
		  int kor = getScore();
		
		System.out.println(kor );
		}catch(InputMismatchException e) {
			System.out.println("점수 입력 잘못!!!");
		}catch(Exception e) {
			
		}

	}
	
	// 0~100 점수를 입력 반환하는 메서드
	public static int getScore() throws InputMismatchException{
		Scanner scanner = new Scanner(System.in);
		int score;
		
		System.out.print("점수 입력 ? ");
		// scanner.nextInt()
		String data =  scanner.next();
		
		if( data.matches("[1-9]?\\d|100" ) ) {   // 0~100
			score = Integer.parseInt(data) ;
			return score;
		}else {
		     // 강제로 예외 발생 시키겠다.	
			 //               "입력불일치예외"
			throw new InputMismatchException("점수 범위( 0 ~ 100 ) 벗어났다.");
		}
	}
	
	// 메서드 선언 부분
	/*
	void method() throws NullPointerException, ArithmeticException, IOException{
		
	}
	*/

}
