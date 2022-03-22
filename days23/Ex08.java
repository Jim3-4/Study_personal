package days23;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 4:05:57
 * @subject  p 558 가운데 ..   truncatedTo(매개변수) 메서드
 * @content                            절삭(제거)하다.
 */
public class Ex08 {

	public static void main(String[] args) {
		
		LocalTime t = LocalTime.of(12, 34, 56);
		System.out.println(  t  );  // 12:34:56
		
		// 시간(hour) 밑으로는 전부 절삭( 분, 초, 나노초 ) 제거
		t = t.truncatedTo( ChronoUnit.HOURS );
		System.out.println(  t );  // 12:00
		 

	} // main

} // class












