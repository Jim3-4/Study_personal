package days18;

//public abstract class Singleton {
public class Singleton {
	
	// 필드
	// 인스턴스 변수 -> 클래스 변수 선언
	// Singleton.singleton
	private static Singleton singleton; // 자기 자신의 인스턴스(생성된 객체)를 참조할 참조변수( 필드 ) 선언
	
	// 필드
	// private 생성자
	private Singleton() {
		
	}
   
	// 클래스 메서드 
	// Singleton = Singleton.getInstance();
	public static  Singleton getInstance() {
		
		if( singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
	/*
    public Singleton() {
		
	}
	 public Singleton(int n) {
		
	}
	*/
	// 메서드

} // class
