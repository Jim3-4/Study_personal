package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 10:25:57
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		// p 397
		// [인터페이스 이해  2가지 사항]
		// 클래스를 사용하는 쪽 - User, 		// 클래스를 제공하는 쪽 - Provider
		// 메서드를 호출(사용)하는 쪽 - [User],         메서드 선언부 파악 -> 구현된 내용 X   

		
		// 자바 코딩
		// BeanManager 클래스
		//    new Bean();
		//    new Bean();
		//    new Bean();
		// p 400 정독 ~ 설명/질문
	} // main

} // class


class A{   // User( 사용자 )
	
	void methodA(IE obj) {
		obj.print(); // 메서드를 호출(사용)
	}
}


interface IE{
	void print();  // 선언부 파악
}

// 
class B implements IE{

	@Override
	public void print() {
		// 구현
		// 구현
		// 구현
	}
	
}
