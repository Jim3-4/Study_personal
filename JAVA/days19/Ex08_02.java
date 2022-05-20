package days19;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 12:40:08
 * @subject 
 * @content 
 */
public class Ex08_02 {

	public static void main(String[] args) {
		 
		int a = 0 , b = 0;
		double c = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		
		// try~ catch 문
		// JVM 의  "예외처리기"  예외 정보를 받아서 -> ???Exception 객체 전달.
		try {
			System.out.print("> a b 정수 입력 ? ");
			try {
				a = scanner.nextInt();
				b = scanner.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
			c = a / b;
			//
			//
			//
			System.out.printf("%d / %d = %.2f\n", a, b, c);
		}catch (InputMismatchException e) {
			try {
				
			} catch (Exception e2) {
				
			}
			 System.out.println(  e.toString()  );    //  "java.util.InputMismatchException"
		}catch (ArithmeticException e) {
			 System.out.println( e.getMessage() ); //                "/ by zero"
		} catch (Exception e) {  // 업캐스팅
			e.printStackTrace();
			// java.lang.ArithmeticException: / by zero
			// at days19.Ex08_02.main(Ex08_02.java:26)
		} 
		
		// [주의할점]
		// 다중 catch {} 을 사용할 때는 부모 예외 catch문을 나중에(뒤) 코딩한다. 
		
		 
	} // main

} // class
