package days20;

// import java.lang.System;
// import java.lang.*;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 3:08:07
 * @subject   
 * @content    C 9 유용한 클래스 - 자주    
 *                      C 10 날짜/시간
 *                      C 11 컬렉션 프레임워크
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크
 */
public class Ex01 {

	public static void main(String[] args) {
		// >20	2022-03-17(목)<
		// 9:25 수업 시작~ 
		// p 450  10:00 수업 시작
		java.lang.System.out.println("홍길동");
		System.out.println("홍길동");
		 
		// 모든 클래스의 최상위 부모 클래스는 Object 클래스이다. 
		// Object 클래스 멤버(필드, 메서드) 어떤 것들이 있는지 파악.. -> 오버라이딩 사용
		
		// 1. Object.hashCode() 메서드 
		/*
		Value v1 = new Value();
		int hashCode =  v1.hashCode();  // 객체 자신  [해시 코드] 반환
		System.out.println(  hashCode );  // 366712642
		
		Value v2= new Value();
		 hashCode =  v2.hashCode();  // 객체 자신  [해시 코드] 반환
		System.out.println(  hashCode );  // 1829164700
		*/
		
		// 2. Object.toString() 메서드 - 객체 자신의 [정보를 문자열]로 반환하는 메서드
		/*
		Value v1 = new Value();
		String objectInfo = v1.toString();  // "days20.Value@15db9742"
		System.out.println( objectInfo );   //
		System.out.println( v1.toString() );   //
		System.out.println( v1 );   //  v1 == v1.toString()
		*/
		
		/*
		// MyPoint 클래스 선언 :  days16.MyPoint
		MyPoint p1 = new MyPoint(10, 20);
		System.out.println( p1.toString() );  // days20.MyPoint@15db9742  =>              > x=10, y=20
		System.out.println( p1 );  // days20.MyPoint@15db9742                   =>              > x=10, y=20
		// p1.dispPoint();  // > x=10, y=20
		*/
		
		// "days20.Value@15db9742"
		//  패키지명.클래스명@16진수값hashCode
		//  fullName@16진수형태의 해시코드값
		
		// 3. Object.getClass() 메서드 - 객체의 클래스 정보를 담고 있는 Class 인스턴스를 반환하는 메서드
		/*
		Value v1 = new Value();
		// <? extends Value>  제네릭(지네릭스) 의미이해..
		// 클래스이름 == Class
		Class  cls  = v1.getClass();
		System.out.println(  v1.toString() );   // days20.Value@15db9742
		System.out.println(  v1 );   // days20.Value@15db9742
		System.out.println( cls.getName() );   // days20.Value                 fullName
		System.out.println(  Integer.toHexString( v1.hashCode() ) );  // 15db9742
		
		String info = String.format("%s@%s"
				                               , cls.getName()
				                               , Integer.toHexString( v1.hashCode() ) );
		
		System.out.println( info   );
	   */
		
		/*
		[ 스레드와 관련된 메서드 ]
		Object.notify();
		Object.notifyAll();
		Object.wait();
		Object.wait();
		Object.wait();
		*/
		
		// 4. [Object].equals() 메서드 - 같은 객체 인지를 체크해서 true/false 반환하는 메서드
		/*
		int a = 10, b = 20;
		// System.out.println(   a == b );  // false
		// System.out.println(   a.equals(b)  );  // false
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		//Value v2 = v1;  // [클래스 복사(copy) ]/ 복제(clone) 
		System.out.println(  v1  == v2   );  // 객체 비교 false        true
		//                          0x100 == 0x200   // false
		/*
		0x100
		[10]                                               [0x100] v1
		
		0x200
		[10]                                               [0x100] v2
	    * /
		
       //                             0x100 == 0x200   // false
		System.out.println(  v1.equals(v2) );  // false             true 
		// *****  재정의하지 않은 Object 의   equals() 메서드는    == 연산자 와 동일하다.   
		// Value 클래스의 equals()  메서드를 재정의해서   value 필드의 값만 같으면 동일하다라고 ...		
		System.out.println( v1.equals( new MyPoint()) ) ;
		*/
		
		
		
	} // main

} // class

class Value {   // extends Object 생략
	// 멤버 X
	// 생성자가 중복선언되지 않은 경우에는 컴파일러가 디폴트 생성자를 자동으로 추가.
	int value;
	
	Value(int value){
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {   // 인터페이스 다형성
		Value v = null;
		if (  obj instanceof Value ) {
			//v = (Value)obj;  // 다운캐스팅
            //if( this.value == v.value ) return true;
			return this.value == ((Value)obj).value;
		}
		return false;
	}
	
	
}













/*  // [암기]  생성자 10가지 적으세요..            ==> 취업 면접
 * 1.  인터페이스 장점 4가지를 적고 설명하세요.
 *    ㄱ.
 *    ㄴ.
 *    ㄷ.
 *    ㄹ. 
 * 2. 인터페이스의 멤버 4가지 설명하세요.
 *    ㄱ.  상수
 *    ㄴ.  추상메서드
 *    ㄷ. JDK 1.8   디폴트 메서드  ?  왜 ? 
 *    ㄹ.                static 메서드  ?
 *  3. 익명 클래스 설명
 *      내부 클래스 4가지 중 1개
 *      이름X -> 일회성
 *      new 부모클래스(){  오버라이딩 메서드 }
 *      new 인터페이스(){ 오버라이딩 메서드 }
 *  4. Frame을 상속받아서 MyFrorm 클래스를 만들고
 *      닫기 버튼을 클릭시 익명 클래스(어댑터)를 사용하여 프로그램 종료 기능 구현하고,
 *      버튼을 추가해서 버튼을 클릭할 때 "클릭됨" 메시지를 출력하도록 구현하세요.
 *  5. 자바에서 오류 / 에러 / 예외 에 대해서 설명하세요
 *      오류 - 컴
 *            - 실행
 *                   ㄴ에러 - 메/ 하
 *                   ㄴ[예외 - 미리] 처리
 *                             1) try ~ catch문
 *                             2) throws 문
 *            - 논
 *  6. checked 예외와 unchecked 예외에 대해서 설명하세요.
 *  7. 예외 처리 2가지 방법 설명하세요
 *    ㄱ. 
 *    ㄴ. 
 *  8. try-with-resources 문에 대해서 설명하세요.
 *      try(){
 *      }catch(){
 *      }
 *  
 *  9. 예외 강제 발생에 대해서 설명하세요 
 *  10. 다중 catch 문과 멀티 catch 문에 대해서 설명하세요 . 
 *     try{
 *     }catch( A예  e){
 *     }catch( B예  e){ NullPointException
 *     }catch( E예  e){  // 부모 Exception
 *     }
 *     주의할점
 *     try{
 *     }catch( A예 | B예  e){
 *     }catch( E예  e){  // 부모 Exception
 *     }
 *     주의할점
 *     
 *  11. finally 블럭에 대해서 설명하세요 
 *      try{
 *      
 *      
 *          return 1;  // 
 *      }catch(){
 *          
 *         //  return -1;  //
 *         throw 예외객체생성();
 *      } finally{
 *             // 예외 발생 유무 상관없이 반드시 처리할 코딩.
 *      }
 *      
 *  12. try-with-resource 문을 사용해서 파일을 읽어서 라인번호를 붙여서 출력하는 코딩을 하세요  .
 *       입출력 클래스 닫기 유용사용
 *       try(FileReader ; BufferedReader ;Scanner ;){
 *       } 
 *  13. 임의의  사용자 정의 예외 클래스를 구현하세요 .    
 *       왜 ? 
 *       국어 점수 0~100 아니라면           getScore() 예외 발생
 *       class ScoreOutOfBoundException extends RE 또는 [ Exception ]{
 *           private final int ERROR_CODE;
 *           getter
 *           
 *           ScoreOutOfBoundException(){}
 *           ScoreOutOfBoundException(String message){}
 *           ScoreOutOfBoundException(){}
 *           
 *       }     
 *       
 * */











