package days19;

// 자동차 클래스
public class Car {
	
	// 필드
	String name;
	String gearType; // 수동, 자동
	int door;
	
    // IEngine 인터페이스 선언 -> 구현  S_ , K_, H_Engine 클래스 선언
	// 추상클래스 업캐스팅
	// 인터페이스 업캐스팅
	private IEngine engine = null; 
	
	public IEngine getEngine() {
		return engine;
	}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	
	// 디폴트 생성자   - 생성자 초기화
    Car(){
	   this.engine = new S_Engine();
   }
    // 엔진 객체 생성자 주입( DI )   -  의존성 주입
    // 매개변수 다형성
    // 인터페이스 [매개변수] 다형성
    // 매개변수 IEngine engine  =   S_ , K_, H_Engine 클래스 선언
    Car(IEngine engine){
 	   this.engine = engine;
    }
	
	// 메서드
	void speedUp(int fuel) {
		this.engine.moreFuel(fuel); // 에러 라인 :  객체 생서이 안됨.  NullPointerException
	}
	
	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}
	
	void stop() {
		this.engine.stop();
	}

} // Car
