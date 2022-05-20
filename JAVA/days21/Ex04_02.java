package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 12:09:48
 * @subject 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		//  올림/내림/반올림   ceil(), floor(), round() 메서드 
		// [ 페이징 처리 ] 를 할 때 위의 메서드 사용한다. 
		// 한 페이지에 출력할 게시글 수 : 10
		// 총 게시글 수                         : 12
		// 총 페이지수 ?                         2페이지
		
		int 한_페이지에_출력할_게시글_수 = 10;
		int 총_게시글_수 = 342;
		int 총_페이지_수 =  (int)Math.ceil( (double)총_게시글_수 / 한_페이지에_출력할_게시글_수 );
		System.out.println( 총_페이지_수 );  // 35 페이지
		
		// p 489 StrictMath 클래스
		// Math 클래스의 메서는 VM설치된 OS(부동소수점 처리 방법 X)에 따라 다른 결과 나온다. -> 성능 향상
		// 성능 포기하더라도 OS 상관없이 동일한 결과를 얻기 위해서 새로운 math 클래스를 만들었는 데 
		//  "StrictMath" 클래스 이다.. 
		

	} // main

} // class
