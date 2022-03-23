package days24;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오전 9:14:26
 * @subject   시간-시간 차 = Duration 클래스
 * @content   between() / until() / of() / plus() / with() / minus()
 */
public class Ex01_02 {

	public static void main(String[] args) {
		LocalTime t1 = LocalTime.now();
		// System.out.println( t1 );  // 09:15:32.285
		LocalTime t2 = LocalTime.of(12, 34, 56);
		
		// between() 메서드 - static 메서드 
		// until() 메서드        - 인스턴스메서드
		Duration d =  Duration.between(t1, t2);
		//t1.until(t2, null)
		
		// System.out.println(  d.getUnits());  // [Seconds, Nanos]  초, 나노시간
		// 시간/분/밀리세컨드        - 계산
		
		System.out.println(  d.getSeconds()  );  // 11775
		System.out.println(  d.getNano()  );       // 60000000
		
		// 60초 == 1분
		// 1시간 == 60분 == 60 * 60 초
		// 1하루 == 24시간 == 24 * 60분 == 24 * 60 * 60 초 == 24 * 60 * 60 * 1000 ms
		long hour = d.getSeconds() / 60 * 60 ;   //  초 -> 시간
		long minute = ( d.getSeconds() - hour * 3600) / 60;
		long second =  ( d.getSeconds() - hour * 3600 - minute*60) %60;
		int nano = d.getNano();

		
		// of()                       설정
		Period p = Period.of(1, 12, 31); //  1년 12개월 31일 
		p.withYears(2); // 2년 12개월 31일
		p.plusYears(3);//  5년 12개월 31일
		p.minusYears(3);//  2년 12개월 31일
		
		// 2년 12개월 31일
		// 1) 31일   무시 X
		// 2년 12개월 ==  2*12 + 12 == 36 개월
		p.toTotalMonths();  
		
		// with()                   수정
		// plus()                    +수정
		// minus()                -수정
	} // main

} // class










