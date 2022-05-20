package days23;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 3:45:51
 * @subject 
 * @content    LocalDate   날짜 클래스 - now(), of(), plusXXX(), plus()
 *                                                                                      , withXXX(), with()
 *                                                                                      , minusXXX(), minus()
 *                                                                                       getXXX() , get()
 */
public class Ex07_03 {

	public static void main(String[] args) {
		 LocalTime t = LocalTime.now();
		 System.out.println( t );   //  15:47:52.162
		 
		 // 시간, [분], 초, ms , ns
		 int minute =   t.getMinute();
		 System.out.println(  minute );
		 
		 minute =    t.get( ChronoField.MINUTE_OF_HOUR  );
		  System.out.println(  minute );

		  // 10분 후 ? 
		  LocalTime result =  t.plus(10, ChronoUnit.MINUTES);
		  System.out.println( result );
		  result =  t.plusMinutes(10);
		  System.out.println( result );
		  
		  // 4:05 수업 시작.. 
	} // main

} // class








