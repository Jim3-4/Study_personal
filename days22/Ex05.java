package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 3:08:47
 * @subject  p 531 예제 10-2
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 오늘    -  2022.3.21(월)
		// 개강일 - 2022.2.15(화)
		// 수료일  - 2022.7.29(금)
		
		// 문제1)  두 날짜 사이의 간격(일수) 얼마인가 ? 
		//           개강~오늘까지 몇 일 지났는가? 
		Calendar today = Calendar.getInstance();
		Calendar openday = new GregorianCalendar(2022, 2-1, 15, 0, 0, 0); 
		
		 long difference = Math.abs( today.getTimeInMillis() - openday.getTimeInMillis() );
		 
		 /*
		 long 초 =  difference/ 1000;
		 long 분 =  초 / 60;
		 long 시간 =  분/ 60;
		 long 일수 =  시간/24;
		*/
		 long 일수 = difference/( 60*60* 24 *1000 );
		 
		 
		 // "23일 12시간 5분 15초 1230밀세"
		 /*
		 System.out.println( Math.abs( d1_ms - d2_ms ) +"ms" );
	 		System.out.println( Math.abs( d1_ms - d2_ms )/1000 +"s" );
	 		System.out.println( Math.abs( d1_ms - d2_ms )/1000/60 +"m" );
	 		System.out.println( Math.abs( d1_ms - d2_ms )/1000/60/60 +"h" );
	 		System.out.println( Math.abs( d1_ms - d2_ms )/1000/60/60/24 +" days" );
		 */
		 
		// 문제2) 두 날짜 사이의 간격(일수) 얼마인가 ?
		//           오늘부터 수료일까지 몇 일 남았는가? 

		System.out.println( Calendar.AUGUST ); // 8-1=7
	}  // main

} // class






