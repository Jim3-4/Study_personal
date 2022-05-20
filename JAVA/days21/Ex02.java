package days21;

import java.util.StringTokenizer;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 11:30:34
 * @subject   문자열 다루는 클래스  : S / SB / SB 차이점
 * @content  
 */
public class Ex02 {

	public static void main(String[] args) {
		// StringTokenizer  클래스
		// 토큰 
		String str = "홍길동, 박예린 , 김서영, 마상민";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println( st.countTokens() );  // 4
		// String st.nextToken();  다음 토큰(이름)을 반환하는 메서드, X, String
		/*
		System.out.println(  st.nextToken() );
		System.out.println(  st.nextToken() );
		System.out.println(  st.nextToken() );
		System.out.println(  st.nextToken() );
		System.out.println(  st.nextToken() );  //  java.util.NoSuchElementException
		*/
		while( st.hasMoreTokens() ) {  // 토큰이 남아있다면  이 메서드는 true 반환
			System.out.println(  st.nextToken() );
		}
		
		
		
		
		// String.split() 문자열을 구부자(regex)을 사용해서 잘라내기.     -  권장
		/*
		String [] names = str.split("\\s*,\\s*");  // String regex
		for (String name : names) {
			//System.out.printf("[%s]\n", name.trim());
			System.out.printf("[%s]\n", name );
		}
		*/
		

	} // main

} //  class















