package days22;

import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 12:18:44
 * @subject 
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// Date d = new Date();          // 현재 시스템의 날짜, 시간 - >  d 객체
		// [문제]
		// 달력을 그릴 때     2010년 5월 1일 무슨 요일 ?
		// 출력형식) 월요일
		
		// 생성자 10개 - 필드초기화
		/*
		Date d = new Date(2010-1900, 5-1, 1 , 0, 0, 0);
		System.out.println( d.getDay() );  // 6 토요일
		*/

		Date d = new Date(); // 시스템의 날짜, 시간
		// d.getXXX()  년,월,일,시,분,초,요일
		// d.setXXX()  setter -> 필드 설정
		d.setYear(2010 - 1900);
		d.setMonth(5-1);
		d.setDate(1);
		System.out.println( d.getDay() );  // 00:00:00 
		
		// [문제] 마지막 날짜  28, 29, 30, 31
		// 1/3/5/7/8/10/12 - 31
		// 2 - 28,29
		// 4/6/9/11 - 30		
		System.out.println( d ); // Sat May 01 12:34:37 KST 2010
		int month =  d.getMonth();  // 5월       -   4
		d.setMonth(       month  + 1           ); 
		System.out.println( d );    // Tue Jun 01 12:36:02 KST 2010
		int date = d.getDate();  // 1일
		d.setDate(   date - 1     );
		System.out.println( d );  // Mon May 31 12:36:53 KST 2010
		System.out.println(     d.getDate()  );    // 31
		
		// [문제]    주민번호 앞자리 6자리 -  "890212"
		//              오늘 생일 지났느냐?  
		String rrn =   "890212";
		// 오늘 날짜
		Date today = new Date();
		// 시간/분/초 절삭
		today.setHours(0);    // 12            ***
		today.setMinutes(0); // 50
		today.setSeconds(0);
		
		int b_month =  Integer.parseInt( rrn.substring(2, 4) ) -1;
		int b_date = Integer.parseInt( rrn.substring(4, 6) ) ;
		Date birthday = new Date( today.getYear(), b_month, b_date);
		
		System.out.println(  birthday.after(today) );   // false
		System.out.println(  birthday.before(today) );   // true
		System.out.println(  birthday.equals(today) );   // false		
		
		System.out.println( birthday.compareTo(today) );  // -1(안지남)  0(오늘이생일)   1(지남)
		
		/* [수강생]
		  Date my = new Date(1989-1900, 2-1, 12); // 생일인 사람의 날짜
	      Date today = new Date();
	      
	      if(today.getMonth() > my.getMonth()) System.out.println("생일이 지났습니다.");
	      else if(today.getMonth() == my.getMonth() && today.getDate() > my.getDate()) {
	         System.out.println("생일이 지났습니다.");
	      } else System.out.println("생일이 안지났습니다.");
	      */
	} // main

} // class



