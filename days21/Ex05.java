package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 12:22:13
 * @subject   p 490 래퍼(Wrapper) 클래스
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 기본형 8가지 -> 클래스( 필드, 메서드 )  = 래퍼클래스
		/*
		 * 1. boolean 	-> Boolean
		 * 2. byte 			-> Byte
		 * 3. short 		-> Short
		 * 4. int 			->              Integer
		 * 5. long 			-> Long
		 * 6. float 		-> Float
		 * 7. double 		-> Double
		 * 8. char 			->             Character
		 * */

		System.out.println( Integer.MAX_VALUE );
		System.out.println( Integer.MIN_VALUE );
		
		/*
		int n =  Integer.parseInt("100");
		int n =  Integer.parseInt("100", 2);   // 4
		int n =  Integer.parseInt("12", 8);   // 10
		                                                radix
		*/
		 
		//  XXX n =    래퍼클래스.parseXXX();
		/*
		Integer.toBinaryString(n);
		Integer.toHexString(n);
		Integer.toOctalString(n);
		*/		
		// int n =  Integer.valueOf("100")
		
		// Character.isDigit('c');
		
		// p 492 Number 클래스
		// 1. 추상클래스이다.
		// 2. 숫자를 필드로 갖는 래퍼 클래스의 부모 클래스이다. 
		
		//  Number 클래스
		//         ㄴ BigInteger 클래스:  long형보다 더 큰 정수 값의 범위를 다루는 자료형
		//         ㄴ BigDecimal 클래스 :  double형보다 더 큰 실수(부동소수점) 값을 다루는 자료형.
		
		
		// 문자열 "100" -> 숫자 변환하는 방법 (3가지)
		// 1.      Integer.parseInt("100");
		// 2. 
		/*
 		Integer i =  new Integer("100");
 		int j =  i.intValue();
 		
 		int i = new Integer("100").intValue();
		*/
		// 3. int i = Integer.valueOf("100");
	} // main

} // class







