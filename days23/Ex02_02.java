package days23;

import java.text.DecimalFormat;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 9:34:42
 * @subject 
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
		double no = 10;
		
		// #0010          4자리 숫자형식으로 출력
		/*  // 1.
		String sno = String.format("%04d", no);
		System.out.println( sno );
		*/
		
		// 2. (풀이) no 자리를 계산해서 로직으로 앞에 0문자를 붙이는 방법
		
		// 3.  #0000
		//     패턴 기호 # :  10진수,   만자리의 숫자가 없을 경우엔 출력 X
		String pattern = "'#'0000";   // escape  패턴기호에서 제외시킬때  '   *****
		DecimalFormat df = new DecimalFormat( pattern );
		String sno = df.format(no);
		System.out.println( sno );
		

	} //main

} // class









