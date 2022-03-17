package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 11:23:46
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		// p 410 익명(무명 anonymous) 클래스
		// 1. 클래스 선언 + 생성
		// 2. 일회성 클래스 - 오직 한개의 객체 생성이 된다. 
		// 3. 익명 클래스 선언 형식
		/*
		
		new 부모클래스(){
		          // 필드 X
		          // 부모클래스의 메서드만 오버라이딩(재정의)할 수 있다.		
		}
		
		new 인터페이스(){
		          // 인터페이스의 추상메서드만 오버라이딩 할 수 있다. 
		}
		
		 * */
		
		// class K_Engine implements IEngine {}  // 클래스 선언
		// Car myCar = new Car(new K_Engine());// 객체 생성
		

		Car myCar = new Car( new IEngine() {       // 익명클래스
													@Override
													public void stop() { } 
													@Override
													public void moreFuel(int fuel) { } 
													@Override
													public void lessFuel(int fuel) { }
												}    
		                               );
		myCar.speedUp(10);

	}

}
