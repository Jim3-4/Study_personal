package days18;

import days17.Regular;
import days17.SalesMan;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 12:00:40
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		// 12:15 수업 시작..
		// p 356 클래스간의(참조변수의) 형변환
		//     Employee  / Regular ( 상속 관계 )
		//  - 업캐스팅 부모  obj = new 자식객체();     자동
		//  - 다운캐스팅 (  cast 연산자를 사용해서 강제 형변환 )
		
		// [문제] 왜 형변환(다운캐스팅)이 안되는 이유 ? 업캐스팅을 한 객체를 다운캐스팅 가능
		//                        부모 -> 자식   형변환
		//                        강제형변환
		
//		Regular r = new   Regular();       // 부모		
		// 업캐스팅이 된 후 다운캐스팅 가능하다. 
		Regular r = new   SalesMan();       // 부모
		// 에러메시지 : java.lang.ClassCastException: days17.Regular cannot be cast to days17.SalesMan
		SalesMan  s =  (SalesMan) r;

		System.out.println("END.");
	} // main
	
	// 1. public [static abstract] void disp() ;
	// 2. public [final abstract] void disp() {}
	// 3. [private abstract] void disp();
	// 4. 

} // class
