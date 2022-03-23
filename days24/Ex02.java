package days24;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오전 9:35:43
 * @subject  p 572 파싱( parse )과 포맷( format )
 * @content    java.time.format 패키지  - DateTimeFormatter클래스
 */
public class Ex02 {

	public static void main(String[] args) {
		
		// [기억]
		// Date , Calendar -> 포맷, 파싱 -> SimpleDateFormat 클래스 사용
		// JDK 1.8  LocalDate, LocalTime, LocalDateTime -> 포맷, 파싱 -> DateTimeFormatter 클래스 사용
		
		LocalDate today = LocalDate.now();
		System.out.println(  today ); // 2022-03-23
		
		//  "2022년 3월 23일"
		// p 573 원하는 출력형식으로 직접 설정해서 사용하기 - ofPattern() 메서드 사용해서... 
		String pattern = "yyyy년 M월 dd일";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String stoday =  formatter.format(today);  
		System.out.println( stoday );
		
		
		/*
		//DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate( FormatStyle.LONG );
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT );
		String stoday =  formatter.format(today);  
		System.out.println( stoday ); // 2022년 3월 23일 (수), 2022년 3월 23일 수요일, 22. 3. 23
		*/
		
		/*
		//  날짜 정보 
		LocalDate d = LocalDate.of(2022,2,15);
		System.out.println(  d ); // 2022-02-15
		
		//String  s = DateTimeFormatter.ISO_DATE_TIME.format( d );
		String  s = DateTimeFormatter.ISO_DATE.format( d );
		System.out.println( s );
		
		DateTimeFormatter formatter =  DateTimeFormatter.ISO_DATE; 
		s = d.format(  formatter );
		System.out.println( s );
		*/
		

	}  // main

} // class
