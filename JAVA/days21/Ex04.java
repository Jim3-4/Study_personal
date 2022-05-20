package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 11:45:24
 * @subject  p 483  Math 클래스
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// Math 클래스
		// 1. static 멤버(필드, 메서드) - 자주 사용, 객체 생성 X
		// 2. 수학 계산과 관련된 메서드
		// 3 필드 2개
		System.out.println(  Math.PI   );  // 3.141592653589793               s-static   f-final
		System.out.println(  Math.E   );  //  2.718281828459045
		
		// 메서드
		System.out.println(  Math.random() );
		System.out.println( Math.abs(-10) );  // 절대값   pow() 재귀 함수
		System.out.println( Math.pow(2, 3) );  // 누승
		System.out.println( Math.max(2, 5) );
		System.out.println( Math.min(2, 5) );
		
		// 12:02 수업 시작
		System.out.println( Math.sqrt(4) );  // 2.0 double
		
		// *** 올림(절상), 버림(절삭), 반올림
		//                                                      소수점 첫 번째 자리 절상
		System.out.println(  Math.ceil(  45.179  ) );  // 46.0
		System.out.println(  Math.ceil(  45.779  ) ); // 46.0
		System.out.println(  Math.ceil(  45.579  ) ); // 46.0
		//                                                      소수점 첫 번째 자리 절삭		
		System.out.println(  Math.floor(  45.179  ) );  // 45.0
		System.out.println(  Math.floor(  45.779  ) ); // 45.0
		System.out.println(  Math.floor(  45.579  ) ); // 45.0
		//      													소수점 첫 번째 자리 반올림
		System.out.println(  Math.round(  45.179  ) );  // 45   int
		System.out.println(  Math.round(  45.779  ) ); // 46
		System.out.println(  Math.round(  45.579  ) ); // 46

		// [질문] math.ceil이나 math.floor을 사용해서 
		//  올림/내림하기 원하는 자리를 바꿀 수는 없는건가요?  내가 원하는 소숫점에서 반/내/올 ->   소수점 첫번째 자리로 변경
	} // main

} // class
