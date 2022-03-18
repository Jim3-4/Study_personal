package days21;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import days20.MyPoint;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 2:22:05
 * @subject   p 496 java.util 패키지 안에 클래스
 * @content           - 유용한( 자주 사용되는 ) 클래스
 *                          1) Objects 클래스
 *                          2) Arrays 클래스
 */
public class Ex07 {

	public static void main(String[] args) {
	

		/*
		//Integer [] m = { 3, 5, 2, 4, 1 };
		int [] m = { 3, 5, 2, 4, 1 };
		
		// 배열을 다루는 기능이 구현된 클래스 : Arrays 클래스
		// 1. 배열 출력 - 확인
		System.out.println( Arrays.toString(m) );  // [3, 5, 2, 4, 1]
		// 2. 배열의 모든 요소를 -1로 초기화
		//Arrays.fill(m, -1);
		//System.out.println( Arrays.toString(m) );  // [-1, -1, -1, -1, -1]
		// 3. 배열 검색
		// System.out.println( Arrays.binarySearch(m, 4)  );  // 3
		// 4.
		// Arrays.sort(m);
		//System.out.println( Arrays.toString(m) );  //[1, 2, 3, 4, 5]    오름차순
		
		// [문제] int [] m -> 내림차순(desc) 으로 정렬하세요.. 
		//Arrays.sort(m , Collections.reverseOrder() );
		//System.out.println( Arrays.toString(m) );
		*/
		 
		// 1) Objects 클래스
		MyPoint p1 = null;
		MyPoint p2 = null;   // new MyPoint(1,2) ;
		
		test( p1  , p2 );
		
	} // main

	private static void test(MyPoint p1, MyPoint p2) { 
		
		// p1객체와 p2 객체가 같냐? 
		// if (   p1 != null   &&   p1.equals(p2) ) {
		if (    Objects.equals(p1, p2) ) {
			
		}
		
	}

	private static void test(MyPoint p) { 
		/*
		// p 가 null 체크를 한 후에
		//if (  p != null) {               ****
		// if( !Objects.isNull(p) ) {  널이니?  널 체크하는 코딩
		if( Objects.nonNull(p))  {   // 널이 아니니 ? 
			System.out.println(   p.getX()  );  // java.lang.NullPointerException  예외 발생
		}
		*/ 
	}

} // class













