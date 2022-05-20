package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 3:32:13
 * @subject   p 532 예제 10-3 꼭 해 보기.
 * @content   p 533 예제 10-4
 *                      c  2022.1.31
 *                      c.add(  Calendar.DATE, 1)            2022.2.1
 *                      c.roll(Calendar.DATE, 1)차이점     2022.1.1     다른 필드에는 영향을 주지 않는 다 ( 차이점 )
 */
public class Ex06 {

	public static void main(String[] args) {
		// 개강일로 부터 100일 기념으로 그 날은 휴강합니다. 
		Calendar  openday = new GregorianCalendar(2022, 2-1, 15);
		// 1년 전
		openday.add(   Calendar.YEAR       , -1);
		// 1년 후
		openday.add(   Calendar.YEAR       , 1);
		
		// 1달 전
		openday.add(   Calendar.MONTH       , -1);
		System.out.println(  toString( openday ) );   // 2022년 1월 15일
		
		
		// 일만 새로 2일로 수정
		// openday.set(Calendar.DATE, 2);
		
		// add()     100     백일  후
		// add()     -100    백일 전
		openday.add(Calendar.DATE, 100);
		
		System.out.println(  toString( openday ) );  // 2022년 5월 26일

	}  // main
	
	public static String toString( Calendar c ) {
		return String.format("%d년 %d월 %d일"
				, c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1 , c.get( Calendar.DATE) );
	}

} // class











