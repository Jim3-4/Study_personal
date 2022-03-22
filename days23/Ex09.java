package days23;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 4:10:16
 * @subject   p 559    날짜,시간의 비교 -     isAfter(), isBefore(), isEquals(), compareTo() 메서드 
 * @content               예제 10-22 코딩해 보기 
 *                                  오늘날짜가 생일 지났는 지여부 체크 ? 
 */
public class Ex09 {

	public static void main(String[] args) {
		/*
		Date d = new Date();
		d.after(when);
		d.before(when);
		d.equals(d);
		d.compareTo(when)
		*/ 
		// LocalDate + LocalTime
		LocalDateTime dt1 = LocalDateTime.now();
		// System.out.println( dt1 );  // 2022-03-22T16:12:39.507
		
		dt1 =  dt1.truncatedTo( ChronoUnit.DAYS );
		
		System.out.println( dt1 ) ;  //  2022-03-22T00:00
		
		LocalDateTime dt2 = LocalDateTime.of(2022, 3, 22, 0, 0, 0);

		// 이유 ? 날짜 동일하지만 시간 달라서.. 
		System.out.println(   dt1.isEqual(dt2)  );  // false
		System.out.println(   dt1.compareTo(dt2)  );  //0       1  -1
		
		// 설문조사 기간 : 2022.3.15 ~ 2022.3.22T00:00:00   
		// 오늘날짜               2022.3.22T16:12:39.507
		// [ 설문조사  X ]

	}

}





