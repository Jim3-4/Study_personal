package days22;

import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오전 11:29:04
 * @subject   교재 2권  - Chapter 10 날짜(date)와 시간(time) & 형식화(formatting)
 * @content   p 528
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 1. JDK 1.0 , 1.1
		 *   1) Date 클래스  - deprecated 메서드 
		 *   2) [ Calendar 추상클래스 ]이다
		 *     -  new 객체 생성을 못하고
		 *         getInstance()메서드를 통해서 객체( 인스턴스 )를 얻어와서 사용한다.
		 *           ㄴ  태국  BuddhistCalendar 객체를 반환
		 *           ㄴ  그 외 GregorianCalendar 객체를 반환 
		 * 
		 *         나라마다 달력(Calendar) 음력 X
		 *            - KoreaCalendar 
		 * 2. JDK 1.8
		 *    java.time 패키지 안에  여러 하위 패키지 및 다양한 클래스 추가   
		 * */
		Date  d = new Date();
		// 만나이
		// is deprecated   앞으로는  폐기되는 메서드
		int year =  d.getYear() + 1900;
		// System.out.println( year );  // 2022
		

		 // [KST]  한국표준시
		 System.out.println(  d.toString()  );  // Mon Mar 21 11:43:31 [KST] 2022
		 System.out.println(  d  );  // Mon Mar 21 11:43:31 KST 2022
		 // Greenwich Mean Time == GMT ==  그리니치 평균 시간 == 세계 표준 시간
		 System.out.println(  d.toGMTString()  );  // 21 Mar 2022 02:44:18 GMT
		 
		 // 12:00 수업 시작~
		 // 만나이 계산할 때 생일 지났는 여부 -1
		 // boolean d.after(Date when)
		 // boolean d.before(when)
		 
		 // d.getXXX() / d.setXXX()
		 // 월
		 System.out.println( d.getMonth() +1  );  // 1월(0) ~ 12월(11)              +1
		 // 일
		 System.out.println( d.getDate() );   // 21               1~31
		 // 시간
		 System.out.println( d.getHours() );  // 12
		 // 분
		 System.out.println( d.getMinutes()  );  // 7         0~59
		 // 초
		 System.out.println(  d.getSeconds() );  // 26
		 
		 // 1970.1.1  00:00:00 (GMT)  밀리세컨드 값을 반환하는 메서드 : getTime()
		 System.out.println( d.getTime() );  // 1647832148319       long
		 
		 // 오늘날짜가 무슨 요일 ? 
		 // 1.1.1(월)               총날짜수 % 7       0(일) 1(월) ~ 6(토) 요일
		 System.out.println(  d.getDay() );  //      1          0-6
		 System.out.println(  "일월화수목금토".charAt( d.getDay() ) + "요일"  );
		
		 
		 System.out.println(  getLocalDate(d) );
		 
	} // main
	
	
	// Date d => 2022년 3월 21일 12:17:25(월요일)  반환하는 메서드 구현( 선언 )
	public static String getLocalDate(Date d) {
		int year =  d.getYear() + 1900;  
		int month = d.getMonth() +1 ; 
		int date =  d.getDate() ; 
		int hour = d.getHours() ;
		int minute = d.getMinutes() ;
		int second = d.getSeconds() ;
		int dayOfWeek = d.getDay();  
		//  System.out.println(  "일월화수목금토".charAt( d.getDay() ) + "요일"  );
		
		return String.format(
				"%d년 %d월 %d일 %02d:%02d:%02d(%c요일)"
				, year, month, date, hour, minute, second
				,  "일월화수목금토".charAt(  dayOfWeek  ));
		
	}

} // class











