package day10;

import java.util.Date;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오후 3:36:57
 * @subject 
 * @content 
 * 
 */
public class Ex05_06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//현재 시스템의 년도를 얻어오는 코딩 
	    
	      /*
	       * 만 나이                    - 태어날 일을 기준으로 1년이 지나야지 1살을 먹는다. 
	       * 세는 나이(햇수 나이) - 태어나자마자 1살을 먹고 새해 1월1일되면 1살 더 먹는다.
	       * 
	       *   A사람                           2019.12.31    2020.1.1   2020.12.29   2020.12.30   2021.1.1
	       *   2019.12.30 태어남         
	       *   
	       *                  만나이                0살              0살             0살          1살                1살              생일 지났냐? 여부
	       *                  세는나이             1살               2살              2살         2살                 3살
	       * */ 
	      
	      String rrn =  Ex05_02.getRRN(); 
	      
	      //int countingAge = getCountingAge( rrn );
	      // System.out.println( countingAge );
	      
	      int americanAge = getAmericanAge( rrn );
	      System.out.println( americanAge ); 
	      
	      
	      // [질문] 메서드 차이점 - 3가지 파악( 기능, 매개변수, 리턴값 )
	      // void     System.out.pritnf("출력형식", 출력값...)              기능, 매개변수 O,리턴값(리턴자료형)  void
	      // String String.format("출력형식", 출력값...)                     기능, 매개변수 O,리턴값(리턴자료형)  String      
	    
	   } // main

	   // 주민등록번호로부터 만나이를 반환하는 메서드
	   private static int getAmericanAge(String rrn) {
	      //  만 나이 = 올해(2022) - 생일년도 + 1 
	      //  만 나이 ?  2019.1.13    2020.1.13(1살)  2021.1.13(2살)  2022.1.13(3살)
	      //  계산방법 1)    몫(나이) ==  총산일수 / 365.25
	      //  계산방법 2)    올해 - 생일년도                                   - 1 ( 생일 지났는지 여부 )
	      //                      2022 - 2019
	      //      생일이 지나지 않은 경우                         3살 -1 = 2살
	      //              " 지난 경우                                    3살
	       int age;  // age 나이
	        Date d = new Date();
	         int now =  d.getYear() + 1900; // 올해  2022         
	         int yearBD =  Integer.parseInt(     Ex05_04.getBirth(rrn).substring(0, 4)    );  // 1999 <-  "1999" <-  "1999년 01월 12일"         
	         age = now - yearBD ; 
	         
	            //     올해 3월 29일         생일 월 4월1일
	         // A 학생 X
//	          if (nowMonth <= monthBD && nowDate < dateBD) age -= 1;
	         
	         // B 학생 ( 정답 )
	         // 생일 월    >= 올해 월
	         //      3                4
	         /*
	         if(monthBD>= month) {
	             if(dateBD>=date) {
	                age = year-yearBD;
	             }
	          }else age = year -yearBD -1;
	          */ 
	         // 삼항연산자 age = now - yearBD -(monthBD >= month ? (dateBD >= date ? 0 :1) : 1) ;
	         
	         //      생일이 지나지 않은 경우의 조건식
	         /*
	         int monthBD =  Integer.parseInt (    Ex05_04.getBirth(rrn).substring(6, 8)  )    ; // 1        <=  "1999년 01월 12일"        
	         int dateBD =  Integer.parseInt(Ex05_04.getBirth(rrn).substring(10, 12));             // 12
	         int month = d.getMonth() + 1;  //   1월(0) ~ 12월(11) 
	         int date = d.getDate();
	         if( !( monthBD>= month  && dateBD>=date ) )   age--;
	         */
	         
	         // C 학생           "890112-XXXX" 비전공자
	         int birthMD =  Integer.parseInt( "0112") ;  // 112
	         int nowMD = Integer.parseInt( "0302" );  // 302         
	         if(  birthMD  < nowMD )  age--;
	         
	         // 강사          Date 클래스의 객체
	         // true/false 생일날짜객체.before(  현재날짜객체 )
	         // d.after(d2)
	         // d.before(d)
	         
	         // 
	      return age;
	   }


	   private static int getCountingAge(String rrn) {      
	       // 세는 나이 = 올해(2022) - 생일년도 + 1 
	        int age;  // age 나이
	        Date d = new Date();
	         int now =  d.getYear() + 1900; // 올해  2022
	         int yearBD =  Integer.parseInt(     Ex05_04.getBirth(rrn).substring(0, 4)    );  // 1999 <-  "1999" <-  "1999년 01월 12일" 
	         age = now - yearBD + 1;  // 2022 - 1989 + 1
	         return age;

	}

}
