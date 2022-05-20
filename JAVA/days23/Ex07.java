package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 2:44:57
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		// [ 객체 생성 - now() , of()  static 메서드] 
		// LocalDate d = new X
		// LocalDate d  = LocalDate.getInstance() X

		LocalDate d = LocalDate.now();  // 현재 시스템의 날짜 객체 생성
		System.out.println(  d );   // 2022-03-22
		
		// 년도 -  get() , getXXX()
		int year =  d.getYear();  // getXXX();
		System.out.println( year );  // 2022
		
		 // ChronoField.YEAR  
		year = d.get(  ChronoField.YEAR  );
		System.out.println( year ); 
	
		/*
		Calendar c = Calendar.getInstance();
		System.out.println( c.get(1) );// 2022
		System.out.println( c.get( Calendar.YEAR ) );// 2022
		*/
		
		// 3:05 수업 시작~ 
		
		// 월   getXXX()
		int month = d.getMonthValue(); // 3
		System.out.println( month ); 
		Month   m =  d.getMonth();  // MARCH
		System.out.println( m );   
		
		month =  d.get(  ChronoField.MONTH_OF_YEAR );  // 3
		System.out.println( month);
		
		// 일  - getXXX(), get( TemporalField field )
		int date = d.getDayOfMonth();
		System.out.println( date );
		
		date = d.get(  ChronoField.DAY_OF_MONTH );
		System.out.println( date );
		
		// 요일         1(월) 2(화) 3(수) 4(목) 5(금) 6(토) 7(일)
		// [열거형( enum )] 설명할 때 - 상수
		// DayOfWeek dow = d.getDayOfWeek();  // TUESDAY
		int dayOfWeek  =  d.getDayOfWeek().getValue();  // 2(화)
		System.out.println(  dayOfWeek );
		
	  dayOfWeek =  d.get( ChronoField.DAY_OF_WEEK );
		System.out.println( dayOfWeek  );  // 2(화)
		
		// 2022.3.27   일요일
		// Date  dt = new Date(2022-1900, 3-1, 27);
		// LocalDate dt = LocalDate.of( 2022, 3, 27);
		LocalDate dt = LocalDate.of( 2022, Month.MARCH , 27);
		System.out.println( dt.getDayOfWeek().getValue() );  // 7(일)
	} // main

} // class







