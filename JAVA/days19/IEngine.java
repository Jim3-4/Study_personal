package days19;

public interface IEngine {
	// 상수  (public static final 생략)
	int MAX_SPEED = 300;
	
	// 추상메서드  ( public abstract 생략 )
	void moreFuel(int fuel);
	void lessFuel(int fuel);
	void stop();
	
	// void print(); // 인터페이스 추가할 메서드
	
	// JDK 1.8 새로 추가된 개념
	// 디폴트 메서드       왜 필요했을까? 
	default void print() {
		// 코딩..
		// 코딩..
	}
	
	// static 메서드
	static void  test() {
		System.out.println("> IEngine.test() ...");
	}
}
