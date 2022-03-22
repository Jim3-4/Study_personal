package days23;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 10:23:14
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println( toString( d ));
		
		
		Calendar c = Calendar.getInstance(); // toString() 메서드  days22.Ex06.java
		System.out.println( toString(c) );
		
		// 날짜,시간을 클래스 객체 (d, c) -> 내가 원하는 형식의 날짜,시간 정보로 출력.
		// d, c        2022년 3월 22일 00:00:00 (화요일)

		
		
	} // main

	public static String toString( Date d ) {
		return String.format("%d년 %d월 %d일 %02d:%02d:%02d (%s)"
				, d.getYear()+1900
				, d.getMonth()+1
				, d.getDate()
				, d.getHours()
				, d.getMinutes()
				, d.getSeconds()
				, "일월화수목금토".charAt( d.getDay() ) + "요일" 
				);
	}
	
	public static String toString( Calendar c ) {
		return String.format("%d년 %d월 %d일 %02d:%02d:%02d (%s)"
				, c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1 , c.get( Calendar.DATE) 
				, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)
				, " 일월화수목금토".charAt(c.get(Calendar.DAY_OF_WEEK))+"요일");
	}
	
} // class









