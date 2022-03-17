package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 10:58:00
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// p 403 내부 클래스 ( inner class )
		/*
		 * 1. 내부 클래스는         주로     GUI어플리케이션(  AWT, Swing ) 의   이벤트 처리 사용
		 * 2. 사용 빈도 낮다.
		 * 3. 클래스 내부(안)에 클래스를 멤버처럼 선언
		 * 4. 클래스 + 긴밀관계 + 내부클래스
		 * 5. 장점 2가지
		 *    ㄱ. 접근성 - 클래스 멤버 + 내부클래스 호출 
		 *    ㄴ. 보안성
		 *    class A{  // 외부클래스
		 *      필드
		 *      int x;
		 *      static int y;
		 *      B obj = new B();  // 멤버 변수
		 *    
		 *     // 내부 클래스
		 *      private [static] class B {
		 *          // 외부 클래스 의 필드   접근 
		 *          //    "                메서드
		 *      }
		 *      
		 *    }
		 *    
		 * 6. 내부 클래스의 종류 및 특징 - 선언 위치
		 *   1) 인스턴스(instance) 클래스 - 외부 클래스 필드 선언 위치,  외부클래스의 인스턴스 멤버 처럼 사용.  
		 *   2) 스태틱(static) 클래스 - 외부 클래스 필드 선언 위치,   외부클래스의 static 멤버 처럼 사용.  
		 *   3) 지역(local) 클래스  - 메서드, 초기화 블럭 안 선언,사용 
		 *   *****  4) 익명(anonymous ) 클래스   -  클래스 선언 + 생성, 클래스 이름 X , 일회성 클래스  ******
		 * 
		 * *** p  405 ~ 409  정독 + 코딩. *** 
		 * */

	} // main

} // class








