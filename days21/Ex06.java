package days21;

import days20.MyPoint;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 12:38:36
 * @subject  p 494 오토박싱 & 오토언박싱 ( auto boxing & auto unboxing )
 * @content   2:00 수업 시작~~
 */
public class Ex06 {

	public static void main(String[] args) {
		/*
		String name = "홍길동";
		int age = 20; // 기본형 -> Object 타입
		//  char                       -> Object 타입
		
		// 왜 ? 오토박싱 & 오토언박싱 개념이해..
		// 가변인자 :  자료형...args
		// System.out.printf(String format, Object...args);
		System.out.printf("> name=%s, age=%d,  %c  ,  %.2f  %s \n", name, age , 'A' , 3.14 , new MyPoint(1,2));
		*/

		/*
		MyPoint p1 = new MyPoint(1, 2);
		disp(p1);
		String name = "홍길동";
	    disp( name ); 
	    
	    // int age   => 자동으로 Integer 타입 형변환            =>    Object obj
	                                   오토박싱                            업캐스팅
	    int age = 20;
	    disp( age );
	    
	    char ch = 'A';
	    disp(ch);
	    */
		
		int i = 10;  // 기본형 int
		// Integer j = new Integer(i) ;   // 래퍼클래스      Object <- Number <- Integer 래퍼 클래스       <-오토박싱 -       int
		
		//  기본형 자동으로 래퍼 클래스 타입으로 형 변환 : 오토박싱 이라고 한다. 
		Integer j = i;     // 클래스 = 기본형       자동형변환 ( 오토 박싱 )
		
		// 래퍼 클래스 객체를 기본형으로 자동 형변환     : 오토언박싱
		int k = j;
	} // main
	
	// 리턴자료형        Object  모든 타입을 리턴값으로 사용하겠다. 
	// 매개변수 자료형 Object  모든 자료형을 매개변수 받겠다. 
	public static Object disp( Object obj ) {  // 업캐스팅   Object obj = p1;
		System.out.println(  obj.toString() );
		
		return true;  // 
	}

} // class









