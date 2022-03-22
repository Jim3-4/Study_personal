package days23;

import java.text.DecimalFormat;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 9:19:02
 * @subject   p 540 형식화 클래스
 * @content   DecimalFormat  클래스
 *                      - 숫자(정수,실수, 금액)를    형식의 텍스트(문자열)로 변환하는 클래스
 */
public class Ex02 {

	public static void main(String[] args) {
	 
		int money = 3275600;
		// "\3,275,600" 형식을 가진 문자열로 변환
		// 1번째 방법 : String.format("\\%,d", money)
		// ㄱ.       \u00A4  통화기호
		// ㄴ.       #               10진수기호
		// ㄷ.        ,                 콤마 기호
		String pattern = "\u00A4#,###";
		DecimalFormat df = new DecimalFormat(pattern);
		
		String smoney = df.format(money);
		System.out.println(  smoney );
	 
	} // main

} // class
