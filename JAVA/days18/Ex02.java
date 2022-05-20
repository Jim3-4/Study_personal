


package days18;

//import java.util.Random;
//import java.util.Scanner;  //
// import java.util.*;  // 편리하지만 사용하지 않는 클래스도 import 하기에 좋은 코딩 X

// (주의) import java.*;  // 하위 패키지는 포함 X  , 단지 클래스만 포함

// import java.lang.*;  컴파일할 때 자동 추가
//import java.lang.System;

// "static import 문"
//import static java.lang.Math.random;
import static java.lang.Math.*;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오전 9:37:21
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		// p 336
		// A 개발자 :  고유패키지.DBconn 클래스       도메인  패키지명
		// B 개발자 :  고유패키지.DBconn 클래스          
		
		// C 개발자 : A, B DBConn클래스를 사용한다면 충돌 발생 방지 목적
		// 패키지( package ) ? 서로 관련된 클래스, 인터페이스들의  묶음,   클래스 효율적으로 관리(사용, 유지보수)
		//[기억] 풀네임( full name )을 적으세요 ?   패키지명.패키지명...클래스명 
		//          예)  days17.Employee
		//                 java.util.Date  
		
		// 클래스 -> 물리적         XXX.class 클래스 파일
		// 패키지 -> 물리적        폴더 
		
		// 패키지명 :  소문자 사용 권장(원칙)
		// 자바에서는 대문자 : 클래스명
		
		
		// 10:02 수업시작
		// p 340 import 문 설명~
		// 다른 패키지 안의 클래스를 사용하려면   패키지명.클래스명 으로 사용해야 된다. \
		// 사용할 때 마다 매번 패키지명을 명시하면 .. 불편 ->  import 문
		//java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// import java.util.Scanner;
		//Scanner scanner = new Scanner(System.in);
		/*
		java.lang.System.out.println("홍길동");
		java.lang.System.out.println("홍길동");
		java.lang.System.out.println("홍길동");
		*/
		System.out.println("홍길동");
		
		//Random rnd;
		
		// [static import 문 ]
		
		// Math 클래스 안의 모든 메서드는  static 메서드 이다. 
		//                                 클래스명.메서드명()
		System.out.println(     random()       );
		System.out.println(     random()       );
		System.out.println(     random()       );

	} // main

} // class










