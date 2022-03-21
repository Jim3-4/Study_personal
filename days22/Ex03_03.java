package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 2:36:48
 * @subject 
 * @content 
 */
public class Ex03_03 {

	public static void main(String[] args) {
		 
		int year = 2005;
		// 1월~ 12월
		// 각각 1월 31일
		//        2월 28/29일
		//            :
		//       12월 31일
		
		// [문제] Calendar 클래스를 사용해서 코딩하세요. 
		/*
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		*/
		
		Calendar c = new GregorianCalendar(year, 1-1, 1); // 2005, 1, 1
		for (int month = 0; month < 12; month++) {
			c.set(Calendar.MONTH, month);
			int lastDay  =  c.getActualMaximum( Calendar.DATE );
			System.out.printf("%d년 %d월  - %d 일\n", year, month+1, lastDay);
		}

	} // main

} // class

/*
1월 : 31일
2월 : 28일
3월 : 31일
4월 : 30일
5월 : 31일
6월 : 30일
7월 : 31일
8월 : 31일
9월 : 30일
10월 : 31일
11월 : 30일
12월 : 31일
*/





