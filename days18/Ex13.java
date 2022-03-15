package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 3:55:10
 * @subject  p 387 [인터페이스를 이용한 다형성] 
 * @content 
 */
public class Ex13 {

	public static void main(String[] args) {
		// 4:05 수업 시작~

		// E obj = new E();
		
		// 추상클래스 업캐스팅 가능
		// D obj = new E();                // AbstractList
		
		// 인터페이스 업캐스팅 가능
//		IC obj = new E();                   // List
//		obj.a();
//		obj.b();
//		obj.c();
		
		// IC 인터페이스의 부모 인터페이스  업캐스팅 가능
		//IA  obj = new E();              // Collection
		// 단점
		//obj.a();

		disp( new E() );
	} // main
	
	//                          매개변수 다형성
	//                          인터페이스 매개변수 다형성
	static void disp( IC  obj )  {
		// 출력 메서드 
		// 
	}
	
	/*
	static void disp(E obj) {
		// 출력 메서드 
	}
	*/

} // class

interface IA{
	void a();
}

interface IB{
	void b();
}

// 인터페이스 상속 - 다중 상속
interface IC extends IA, IB{
	void c();
}

abstract class D implements IC{

	@Override
	public void a() { }

	@Override
	public void b() { }
	
	// void a(); 
}

class E extends D{

	@Override
	public void c() { 	}
	
}






