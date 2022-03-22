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
public class Ex03_03 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		 // [ Calendar -> Date 변환 방법( 암기 ) ]
		// 1.
		// Date d =   new Date(  c.getTimeInMillis() );
		// 2. 
		Date d = c.getTime();  
		
		// SimpleDateFormat  클래스을 사용해서 
	   //  2022년 03월 22일 오전 10:50:42:739 (화요일)  출력하세요.
		
		// 11:02 쉬는 시간 + 5분
		// 11:07 수업 시작~ 
		
		String pattern = "yyyy년 MM월 dd일 a hh:mm:ss:S (E요일)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern );
		String sd = sdf.format(d);
		System.out.println( sd );
		
	} // main

	 
	
} // class









