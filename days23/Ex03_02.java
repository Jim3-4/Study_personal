package days23;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 10:23:14
 * @subject  p 544 SimpleDateFormat 클래스
 * @content 
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// Date -> Calendar 변환(암기)
		// Calendar -> Date 변환(암기)
				
		Date d = new Date();
		
		/*
		System.out.println(  d );  // Tue Mar 22 10:39:29 [KST] 2022  한국표준시
		System.out.println(  d.toGMTString() );  // 22 Mar 2022 01:39:57 [GMT]  그리니치 평균 시간
		System.out.println(  d.toLocaleString() );  // 2022. 3. 22 오전 10:40:47
		 */
		
		// *****		
		//  2022년 03월 22일 오전 10:50:42:739 (화요일)
		String pattern = "yyyy년 MM월 dd일 a hh:mm:ss:S (E요일)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern );
		String sd = sdf.format(d);
		System.out.println( sd );
		
		
	} // main

	 
	
} // class









