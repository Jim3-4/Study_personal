package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 3:19:56
 * @subject   ******* p 381 인터페이스( interface )  *******
 * @content 
 */
public class Ex12 {

	public static void main(String[] args) {
		/*
		 * 자바 자료형
		 *    ㄴ 기본형 - 8가지
		 *    ㄴ 참조형 - 배열, 클래스(String), [인터페이스]
		 *    
		 * 1. 인터페이스 - 참조타입   
		 * 2. 일종의 추상 클래스 -
		 *       추상메서드 +  객체를 생성할 수 없는 미완성의 클래스
		 * 3.  일반 메서드 X, 필드(멤버변수) X
		 *      100%  추상메서드 ,  상수 만을 가지는 추상클래스       
		 * 4. 다른 클래스를 선언(작성)할때 도움을 줄 목적으로 사용된다. 
		 * 5.  인터페이스 선언 형식
		 *     class 키워드 대신에 interface 키워드 사용한다. 
		 *     [접근지정자] [기타제어자 X]
		 *     [접근지정자] interface 인터페이스명{
		 *                // abstract 추상메서드 선언           {} X
		 *                // final 상수 선언
		 *     }       
		 * 6. 인터페이스의    멤버의  제약 사항
		 *     ㄱ. 모든 멤버 변수 == 상수
		 *          public static final  생략 가능
		 *     ㄴ. 모든 메서드  == 추상 메서드 
		 *         public abstract   생략 가능
		 *  7. JDK 1.8 부터 변경
		 *      ㄱ. static 메서드   추가 
		 *      ㄴ. 디폴트 메서드    추가     
		 * 
		 *  8. 인터페이스의 상속        
		 *      인터페이스 끼리는 상속 가능하다.
		 *      다중 상속도 가능하다
		 *      [참고]  Object 조상 클래스 X      
		 *      
		 * 9. 인터페이스 [매개변수] 다형성
		 * 
		 * 10. 인터페이스 장점   Ex16.java
		 * */

	} // main
	
} // class

class UnitTwo{
	int currentHP ; // 유닛 체력
	int x ;  // 유닛 현재 위치(x좌표)
	int y ;  // 유닛 현재 위치(y좌표)
}

interface Movable{
	// public abstract 생략
	void move(int x, int y);
}

interface Attackable{
	void attack(UnitTwo  u);
	//void move(int x, int y);
}

// 인터페이스 상속 + 다중 상속
interface Fightable extends  Movable, Attackable{
	// void move(int x, int y);
	// void attack(Unit u);
	void stop();
}

class TankTwo extends UnitTwo implements Fightable{

	@Override
	public void move(int x, int y) { 	}

	@Override
	public void attack(UnitTwo u) { }

	@Override
	public void stop() { }
	
}

class Fighter extends UnitTwo  implements Movable , Attackable{
	
	// currentHP, x, y
	
	@Override
	public void move(int x, int y) {
		System.out.println("움직임 코딩 구현...");
	}

	@Override
	public void attack(UnitTwo u) { 
		System.out.println("공격 코딩 구현...");
	}
}














