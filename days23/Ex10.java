package days23;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 4:20:25
 * @subject   p 560 Instant  클래스  == java.util.Date 클래스를 대체하기 위해서 만든 클래스
 * @content 
 *                             [Date] -> Instant 클래스 변환 메서드 추가 . 
 *                             from()   메서드는 Instant - >  Date 변환 메서드
 *                             toInstant()         Date -> Instant 클래스 변환 메서드 추가 . 
 */
public class Ex10 {

	public static void main(String[] args) {
		//  
		LocalDate d = LocalDate.now();  // 날짜
		LocalTime t = LocalTime.now();  // 시간
		
		// 1.  LocalDateTime dt 
		// 날짜 + 시간 = LocalDateTime
		//LocalDateTime dt = LocalDateTime.now();
		LocalDateTime dt = LocalDateTime.of( d , t );
		
		// 2. LocalDateTime dt 
		dt =  d.atTime(t);
		
		// 3. LocalDateTime dt 
		dt = t.atDate(d);
		
		//  LocalDateTime -> LocalDate,   LocalTime
		LocalDate a =  dt.toLocalDate();
		LocalTime b =  dt.toLocalTime();
		
		// p 564 예제 10-23        [ZonedDateTime 예제 코딩]
		
	}  // main

} // class





