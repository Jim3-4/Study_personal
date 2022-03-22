package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 4:29:53
 * @subject  p 565  TemporalAdjuster[s] 클래스
 * @content          다음 주 금요일 휴강입니다. - 몇일? 
 *                              다가 3째주 금요일 만나요 ?  - 몇일
 *                              등등
 *                              자주 사용되는  날짜 계산 메서드를 구현해 놓은 클래스 
 *                             
 *                               [예제 10-24] 
 */


// 이틀 후 ~~
class DayAfterTomorrow implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {		
		return temporal.plus(2, ChronoUnit.DAYS);
	}
	
}

public class Ex11 {

	public static void main(String[] args) {
		/*
		 LocalDate now = LocalDate.now();
		 System.out.println( now );  // 2022-03-22(화)
		 // 다가오는  주 금요일 휴강?? 
		 LocalDate result = now.with( TemporalAdjusters.next( DayOfWeek.FRIDAY )  );
		 System.out.println( result );
		 // 지난 주 금요일 
		 result = now.with(  TemporalAdjusters.previous( DayOfWeek.FRIDAY) );
		 System.out.println( result );
		 */

		LocalDate today = LocalDate.now();  // 2022.3.22
		LocalDate date = today.with(new DayAfterTomorrow());
		System.out.println( date );  // 이틀 후 ~ 
		
		
	} // main

} // class







