package days23;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 3:24:57
 * @subject 
 * @content 
 */
public class Ex07_02 {

	public static void main(String[] args) {
		// 개강일(2022.2.15)로부터 100일 기념일 출력 ?
		// LocalDate 클래스 + 시스템   now() , [of()]  객체 생성
        // 날짜 수정 메서드 ?  with() / [ plus() ] /  minus() 
		// 불변 X
		LocalDate openDay = LocalDate.of(2022, 2 , 15);
		// openDay.plus(TemporalAmount 인터페이스 구현한 클래스  Period 클래스)
		// 1.  예) openDay.plus(Period.ofDays(100));
		// 2. plusDays()
		//      result = openDay.plusDays(100);  // 2022-02-15
		// 3. 
		//LocalDate result = openDay.plus(100,   ChronoUnit.DAYS );
		// 날짜만  새로운 날짜 값 :  20일로 수정 - with() 
		// LocalDate result =  openDay.withDayOfMonth(20);
		
		// LocalDate result =  openDay.withYear(2020);
		LocalDate result =  openDay.with( ChronoField.YEAR , 2020); 
		
		 System.out.println( result  );      // 2022-05-26
		
		// minus() 메서드 
		
		


	} // main

} // class














