package days23;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 7:56:19
 * @subject   p 540 형식화 클래스
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// >23	2022-03-22(화)<
		// [문제]
		// [Date 클래스]사용해서 달력 출력 코딩.
		int year = 2010;
		int month = 5;

		Date sDay = new Date(year-1900, month-1, 1);
		int dayOfWeek =  sDay.getDay();
		sDay.setDate( sDay.getDate() - dayOfWeek  );
		// System.out.println( sDay.toLocaleString());

		// 달력 출력
		System.out.printf("\t\t\t%d년 %d월\n", year, month);
		System.out.printf("\t일\t월\t화\t수\t목\t금\t토\n");

		for (int i = 1; i <=42; i++) {			
			int date = sDay.getDate();
			System.out.printf(  month == sDay.getMonth() +1   ?  "\t(%d)"  : "\t%d", date);
			sDay.setDate(sDay.getDate()+1); // 다음 날짜
			if( i % 7 ==0 ) System.out.println();
		}

	} // main

} // class


/*
				2010년 5월
일		월		화		수		목		금		토
25	26	27	28	29	30	(1)
(2)	(3)	(4)	(5)	(6)	(7)	(8)
(9)	(10)	(11)	(12)	(13)	(14)	(15)
(16)	(17)	(18)	(19)	(20)	(21)	(22)
(23)	(24)	(25)	(26)	(27)	(28)	(29)
(30)	(31)	1	2	3	4	5
*/





/*
 *                      [C 9 유용한 클래스 - 자주]    
 *                     *** C 10 날짜/시간 ***
 *                     ***** C 11 컬렉션 프레임워크 *****
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크
 */

