package days19;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 12:40:08
 * @subject 
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		 
		int a , b;		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> a b 정수 입력 ? ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		// java.lang.ArithmeticException: / by zero 예외 발생
		// 0 을 입력받을 경우 개발자 예측해서 예외 처리...
		/* 
		// 입력값           예외  처리 X
		if( b == 0 ) {
			System.out.println("0 으로 나눌 수 없습니다. ");
			return ; // 프로그램 종료..
		}
		*/
		
		double c = a / b;
		
		System.out.printf("%d / %d = %.2f\n", a, b, c);
		

	} // main

} // class
