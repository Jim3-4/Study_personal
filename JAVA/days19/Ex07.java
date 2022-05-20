package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 11:51:49
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		// 12:05 수업 시작~
		// [ 자바 + AWT + 계산기 구현. ] 검색 ..
		// p 414 [ Chapter 08 예외 처리 ]
		/*
		 1. 프로그램 오류 ? 프로그램 오작동 또는 비정상 종료된 원인
		 2. 발생시점   1) + 2) = 빌드 오류(오류)
		     1) 컴파일 오류
		          예) int x = 10  
		     2) 런타임(실행) 오류
		         예) int [] m = new int[3];
		              m[100] = 10;          // ArrayIndexOutOfBounds[Exception]
		          자바 언어에서 실행 에러를 2가지 구분
		          ㄱ) 에러( error ) - 메모리 부족, 스택오버플로워 에러 , 복구할 수 없는 심각한 오류
		                       Error  클래스 
		                       자식 클래스 ....
		          ㄴ) 예외( excetion )  - 수습될 수 있는 비교적 덜 심각한 실행 오류
		                       Exception 클래스
		                       자식 클래스 ...   
		              
		     (3) 논리적 오류      -- 가장 어렵다.. --
		     예)  int a = Integer.MAX_VALUE;
		           long b = a + 100;
		           System.out.println(b); // -2147483549 ( 음수 )
		 
           3. 예외 클래스의 계층 구조( 상속 관계 )  p 415 그림 8-1
                Exception 클래스 2 그룹 
                   ㄱ) RuntimeException + 그 하위 예외 클래스
                   ㄴ) Exception + 그 하위 클래스 (   ㄱ) RuntimeException 제외 )
                   
           4.  예외 처리  -  에러 X, 예외 O   Ex08.java
		 */
		
		
		

	} // main

} // class











