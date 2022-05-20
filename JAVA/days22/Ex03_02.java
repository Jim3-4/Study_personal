package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 2:21:03
 * @subject 
 * @content 
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// [문제]
		// Calendar 클래스를 사용해서
		// 2010,5,1  무슨 요일 ? 

		/*
		Calendar c = new GregorianCalendar(2010, 5-1, 1);
		// 1(일) ~ 7(토)
		System.out.println( c.get(  Calendar.DAY_OF_WEEK ) );  // 7
		*/
		
		Calendar c = Calendar.getInstance();
		// c.get( int field )  년,월,일,시,분,초,밀세,요일 등등
		/*
		c.set(Calendar.YEAR, 2010);  // 년도 설정
		c.set(Calendar.MONTH , 5-1); // 월 설정
		c.set(Calendar.DATE, 1);   // 일 설정
		*/
		c.set(2010, 5-1, 1); // 년,월,일 설정
		System.out.println( c.get(Calendar.DAY_OF_WEEK ));  // 7
		
		
		// p530 예제 10-1
		// [문제] Calendar 클래스 사용해서 
		// 2010.5.1  마지막 날짜 ? 
		
		int lastDay = c.getActualMaximum( Calendar.DATE );
		System.out.println(lastDay);
		
		
	} // main

} // class









