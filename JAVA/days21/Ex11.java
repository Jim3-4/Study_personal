package days21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 3:56:05
 * @subject   p 505 정규표현식(  Regular Expression  == regex )
 * @content    java.util.regex 패키지  - Matcher, Pattern 클래스
 *                    
 *                     // String 클래스 - matches() 메서드 
 *                     score.mathes(regex);
 */
public class Ex11 {

	public static void main(String[] args) {
		//  4:06 수업 시작~
		// 1) java.util.regex.Matcher;
		// 2) java.util.regex.Pattern;
		
		String [] data = {"bat","baby","bonus","cA","ca","co", "c.", "c0", "car", "combat", "count", "date", "disc"};

		String regex = "c[a-z]*";
		//                       c                "cA","ca","co", "c.", "c0", "car", "combat", "count"
		//                       c[a-z]                ca		co
		//                       c[a-z]*                ca		co
		//                       c소문자*  0~여러개 
		
		/*
		//String.matches(regex)
		for (int i = 0; i < data.length; i++) {			
			if( data[i].matches(regex) ) 				System.out.println( data[i] ); 
		}
		*/
		
		// 1. Pattern 객체 생성
		// 2. Matchar 객체생성
		// 3. boolean m.matches() 메서드 
		Pattern p = Pattern.compile(regex);  // 패턴 객체
		
		for (int i = 0; i < data.length; i++) {		
		    // 패턴 일치하는 체크하는 Matcher  객체  m
			Matcher m = p.matcher(  data[i]  );
			if( m.matches())  System.out.println( data[i] );
		}
		
		/*
		ca
		co
		car
		combat
		count
		*/
	} // main

} // class
