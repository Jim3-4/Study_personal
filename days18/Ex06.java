package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오전 11:26:42
 * @subject        p 352  private 생성자
 * @content       public 
 *                         default
 *                         private 접근지정자를 사용하는 이유 ?  싱글톤 사용하기 위해
 */
public class Ex06 {

	public static void main(String[] args) {
		// 싱글톤( Singleton.java )
		// - new Singleton(); 코딩에 의해서 디폴트 생성자를 자동 호출한다. 
		// - 컴파일러가 디폴트 생성자를 추가X                                           생성자 오버로딩
		// Singleton s1 = new Singleton(); // 자동으로 디폴트 생성자 호출
		
		// - private생성자를 선언하면   new 클래스명() 객체(인스턴스) 생성을 못하게 하겠다.. 
		//  [왜] ? 클래스 선언해 두고 왜 객체 생성 못하게 막는냐? 
		//        추상클래스라면 미완성된클래스기 때문에 객체 생성을 막는 것은 이해가 됩니다.
		//           객체를 1개만 생성하겠다. (의도)
		//  예)  반 - (반장) 야간자율학습( 30명)  조퇴
		//        자바 애플리케이션        --  데이터베이스 연동      CRUD 작업         DBconn.java 싱글톤
		
		//int hashCode = s1.hashCode();
		//System.out.println(  hashCode );  // 366712642
		
		// - 추상메서드가 1개도 없는 데 추상 클래스로 선언이 가능할까요 ? 가능하다. 
		// - 왜 ? 객체(인스턴스) 생성해서 사용하지 마세요.. 
 
		Singleton s1 =  Singleton.getInstance();
		System.out.println(   s1.hashCode()   );  // 366712642           같은 인스턴스 (객체 )
		
		Singleton s2  =  Singleton.getInstance();
		System.out.println(   s2.hashCode()   ); // 366712642
	
		Singleton s3  =  Singleton.getInstance();
		System.out.println(   s3.hashCode()   ); // 366712642
		
		/*
		Regular r1  = new Regular();
		System.out.println(r1.hashCode());  // 1829164700
		Regular r2 = new Regular();
		System.out.println(r2.hashCode());  // 2018699554
		Regular r3  = new Regular();
		System.out.println(r3.hashCode());  // 1311053135
		*/
		
		// 1. 객체 생성할 필요가 없어서     private Math(){} 선언
		// 2. 모든 멤버가 static 이기 때문에 클래스명.멤버 접근(사용)
		// Math m = new Math();
		//Math.random();
		//Math.PI;
		
		
		// Calendar c = new Calendar();        X   prvate 생성자 선언
		// Calendar c = Calendar.getInstance();
		
		
		
	}

}
