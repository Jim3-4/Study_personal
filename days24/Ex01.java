package days24;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오전 7:53:21
 * @subject   p 567 Period / Duration 클래스
 * @content               ㄴ 날짜-날짜
 *                                                       ㄴ 시간-시간
 */
public class Ex01 {

	public static void main(String[] args) {
		// >24	2022-03-23(수)<
		// 개강일-오늘날                 날짜 ?
		LocalDate today = LocalDate.now();
		// System.out.println( today );  // 2022-03-23
		LocalDate openDay = LocalDate.of(2022, 2, 15);
		
		// 메서드 3가지 ? 1) 기능 2) 매개변수 의미  3) 리턴값( 리턴자료형 )
		Period	 p= Period.between(openDay, today);
		
		// getXXX(), get()
		System.out.println(  p.getYears() );   // 0
		System.out.println(  p.get( ChronoUnit.YEARS ) );   // 0
		
		System.out.println(  p.getMonths() );  // 1
		System.out.println(  p.get( ChronoUnit.MONTHS ) );  // 1
		
		System.out.println(  p.getDays() );  // 8
		System.out.println(  p.get( ChronoUnit.DAYS) );  // 8
		
		System.out.println(  p.getUnits() );  // [Years, Months, Days]
		
		

	} // main

} // class








/*
 *                      [C 9 유용한 클래스 - 자주]    
 *                      C 10 날짜/시간 
 *                     ***** C 11 컬렉션 프레임워크 *****
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크 (수)           팀프로젝트 - 목/금/토/일       (월) 발표 오라클 수업..
 */
