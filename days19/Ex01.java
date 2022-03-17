package days19;
 
/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 7:57:48
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// p 390  인터페이스 장점  - 3번 부터
		// 9:23 수업 시작~
		/*
		 * 3) 서로 관계 없는 클래스들에게 관계를 맺어 줄 수 있다. 
		 *      -  서로 상속 관계 X
		 *      -  서로 관계 맺어 줄 수 있다. ( 인터페이스 )
		 *      예) has-a 관계( 포함관계) 설명
		 *           Engine
		 *           Car
		 *           - 결합력 높은 코딩은 좋지 않은 코딩
		 *           class Car{
		 *                Engine engine = new Engine(); // 명시적 초기화 X
		 *                +===============[                ]  일체형일 경우
		 *           } 
		 *           - 생성자 DI
		 *           - setter DI
		 *        - H_Engine
		 *        - S_Engine               DI                 [ Car     3개의 엔진 사용 ]
		 *        - K_Engine    
		 *        
		 *        엔진인터페이스 IEngine
		 * */
		
		
		// 인터페이스 장점 3번째
		Car myCar = new Car();
		myCar.setEngine(  new H_Engine() );  // setter 의존성 주입( DI )
		// myCar 10년 운영
		myCar.setEngine( new K_Engine() ) ; // 호환
		
		// 운영
		myCar.setEngine( new H_Engine() ) ; // 호환
		
		
		// 10:08 수업시작 4번째 장점 --
		// 4) 독립적인 프로그래밍 가능하다. 
	} // main

} // class










//>19	2022-03-16(수)<
/*
 * 1. OOP의 특징에 대해서 자세히 설명하세요 . 
 * 2. 패키지와 import문에 대해서 설명하세요 
 * 3. abstract 키워드에 대해서 설명하세요 
 * 3-2. 추상 메서드
 * 3-3. 추상 클래스
 * 4. 싱글톤을 구현하는 방법에 대해서 설명하세요. 
 * 5. 업캐스팅과 다운캐스팅에  대해서 설명하세요.
 * 6. 매개변수의 다형성에 대해서 설명하세요.
 * 7. 인터페이스의 다형성에 대해서 설명하세요.
 * 8. 멤버 앞에 붙이는 접근 지정자에 대해서 자세히 설명하세요. 
 * 9. 인터페이스 개요 
 * 9-2. 인터페이스 선언 형식
 * 9-3. 인터페이스 장점
 *    1. 
 *    2. 
 * 9-4. 인터페이스의    멤버의  제약 사항
 * 9-5. 아래 코딩에서 인터페이스 관련해서 설명할 수 있는 것에 대해서 설명하세요 
   public static void main(String[] args) { 
       // 인터페이스 업캐스팅
        Collection  list = new ArrayList(); 
		List  list = new ArrayList(); 
		disp(  list  );
		disp( new ArrayList() );
	} // main        
	private static void disp(  List list  ) {   // 인터페이스 다형성
	}
 * 
 * */
