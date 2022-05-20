package days23;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 9:52:24
 * @subject 
 * @content 
 */
public class Ex02_03 {

	public static void main(String[] args) {
		// p 542 예제 10-10 수업 종료 후 코딩..
		// p 543 예제 10-11          10:04 수업시작~
		
		String smoney = "1,234,400";
		
		/*  1.
		int money =    Integer.parseInt( smoney.replaceAll(",", "") ) ;
		System.out.println( money );
		*/
		
		// 2.
		String pattern = "";
		DecimalFormat df = new DecimalFormat(pattern);
		// 문자열 = df.format(숫자형)
		
		// 숫자형(Number)  df.parse(문자열)
		// 숫자 래퍼클래스의 부모클래스 Number
		try {
		   Number  num	= df.parse(smoney);
		   int money =   num.intValue(); //  Number타입 -> int 변환하는 메서드 : intValue() 메서드
		   System.out.println( money );
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		

	} // main

} // class









