package days22;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 2:47:25
 * @subject  p 529 왜 변환? 
 *                             Date -> Calendar 변환  ***(암기)
 *                             Calendar -> Date 변환  ***(암기)
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// 3:00 수업 시작~
		// 1970.1.1   00:00:00 ~ ms
		/*
		Date d = new Date();
		System.out.println(    d.getTime()   ); // long        1647842564463		
		Calendar c= Calendar.getInstance();
		System.out.println(  c.getTimeInMillis()  );  // long  1647842564483
		*/
		
		// 1. Date -> Calendar 변환   -  c.setTime( Date d )
		/*
		Date d = new Date();
		// d.getTime()  long 
		Calendar c= Calendar.getInstance();
		c.setTime(d);
		*/
		
		// 2. Calendar -> Date 변환  - Date   c.getTime();
		Calendar c= Calendar.getInstance();
		//             1)  Date  d = c.getTime();
		//             2) Date d = new Date ( c.getTimeInMillis() );
	} // main

} // class














