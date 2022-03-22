package days23;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오후 12:38:12
 * @subject p 552 ~ p576 정독 [ JDK 1.8 java.time 패키지 ]
 * @content   JDK 1.0 - Date
 *                       JDK 1.1 - Calendar
 *                       형식화 클래스 4가지 - DF, SDF, CF, MF
 *                                                           ㄴ 숫자
 *                                                                    ㄴ 날짜
 *                                                                           ㄴ 범위-> 문자열 
 *                                                                                  ㄴ mf.parse()
 */
public class Ex06 {

	public static void main(String[] args) {
		// 2:00 수업 시작~ 
		/*
		 *  Date, Calendar 클래스의 단점 -  예) 두 날짜 사이의 차 ( 개발자 직접 로직 구현 )
		 *  
		 *  -- 불편 --
		 *  java.time 패키지의 4가지 하위 패키지.
		 *     ㄴ chrono 패키지 - 표준(ISO)이 아닌 [달력 시스템]을 위한 클래스들을 제공
		 *     ㄴ			 format 패키지 - [파싱, 형식화]하기 위한 클래스들을 제공
		 *     ㄴ temporal 패키지 - 날짜, 시간의  [필드(field)와 단위(unit)]를 위한 클래스들 제공
		 *     ㄴ 		zone 패키지 - [시간대(time-zone)]와 관련된 클래스들 제공
		 *     
		 *     
		 *  핵심 클래스  +  변환 
		 *  
		 *     1. java.time 패키지의 핵심 클래스 
		 *        Date, Calendar = 날짜 + 시간
		 *        
		 *        날짜 클래스 /  시간 클래스  로 분리 가 되어져 있다.
		 *        
		 *        Temporal, TemporalAccessor, [TemporalAdjuster  인터페이스 ]
		 *         1. 날짜 클래스 - LocalDate 클래스
		 *         2. 시간 클래스 - LocalTime 클래스
		 *         3. 날짜 + 시간 클래스 - LocalDateTime  클래스
		 *         4. 날짜 + 시간 + 시간대 =  LocalDateTime + 시간대 =  ZonedDateTime 클래스
		 *         
		 *         
		 *         TemporalAmout 인터페이스 구현
		 *         5. Period  클래스  /  Duration 클래스  차이점 ? 
		 *            날짜 사이의 간격 = 날짜 - 날짜 = Period 클래스
		 *            시간 사이의 간격 = 시간 - 시간 = Duration 클래스 
		 *            
		 *            between() 메서드 
		 *            until() 메서드
		 *           of()  메서드
		 *           with() 메서드
		 *         
		 *         ***  객체 생성하는 방법 :     new X , getInstance() X
		 *                       now(), of() 메서드로 객체 생성한다. 
		 *        
		 *       6.  [참고] 
		 *         시간 == time
		 *          ㄴ temporal 용어 : 시간 - 시, 분, 초  ( 시간 )
		 *          ㄴ chrono 용어    : 시간 - 년,월,일,시, 분,초    () 날짜 시간  
		 *          구분하기 위해서 어려운 용어를 사용했다.      
		 *          
		 *       7. TemporalUnit 인터페이스 - 날짜와 시간의  [단위]를 정의한 인터페이스
		 *                   ㄴ 구현 클래스  : ChronoUint 클래스( 열거형 )
		 *       
		 *           TemporalField 인터페이스 - 날짜와 시간의  [필드]를 정의한 인터페이스
		 *                   ㄴ 구현 클래스 : ChronoField 클래스 ( 열거형 )
		 *           
		 *             열거형( enumeration) ?  서로 관련된 상수를 묶어 놓은 것.
		 *                 
		 *              날짜.시간   get(), getXXX()     값 얻어올때                + ChronoUnit  열거형 클래스 사용 
		 *                                with() / plus() /  minus()  값 수정
		 *               
		 *              날짜,시간 비교  isAfter() / isBefore() / isEqual()
		 *                   
		 *       8.   Instant - 에포크 타임( 1970.1.1 00:00:00 )부터 경과된 시간 나노초 단위료 표현한다.
		 *                                long                                                                        ns 
		 *           
		 *         Instant -> Date 변환
		 *         Date -> Instant 변환
		 *         
		 *      9.    LocalDateTime -> LocalDate 변환
		 *              LocalDateTime -> LocalTime 변환   
                    
                 10. TemporalAdjusters 클래스
                        plus()/ minus() 메서드로 날짜,시간을 계산할 수 있다.
                        다음주 목요일, 
                        지난 금요일  편리한 기능(메서드)이 구현된 클래스  - TemporalAdjusters 클래스   
                      - 여러 가지 유용한 메서드가 있다 -
                      
                 11.      날짜, 시간 -> 형식      ofPatten()
                                            -> 파싱        parse() 
		 * */

	} // main

} // class











