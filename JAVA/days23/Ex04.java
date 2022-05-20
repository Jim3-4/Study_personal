package days23;

import java.text.ChoiceFormat;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 11:11:19
 * @subject p 548 ChoiceFormat 클래스
 * @content           - 특정 범위에 속하는 값을 문자열로 변환해주는 형식화 클래스 
 */
public class Ex04 {

	public static void main(String[] args) {
		//  if/switch 문 사용 X
		// int kor = 88;
		// 우           80<=        <90
		int [] scores = { 100, 95, 88, 73, 52, 60, 70, 0 };
		/*
		String [] grades = {"가","양", "미","우","수"};
		double [] limits = { 0, 60, 70, 80, 90 };
		ChoiceFormat cf = new ChoiceFormat(limits, grades);
		*/
		// p548 예제 10-17        패턴기호는 2가지 뿐이다 (  #  < )  경계 포함여부
		String newPattern="0#가|60#양|70#미|80#우|90#수";
		ChoiceFormat cf = new ChoiceFormat(newPattern);
		
		for (int i = 0; i < scores.length; i++) {
			// if, switch  수/우/미/양/가
			System.out.printf("%d 점 - %s \n", scores[i],  cf.format(  scores[i]) );
		}
		
		

	} // main

} // class




