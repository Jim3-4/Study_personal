package days20;

import java.util.Arrays;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 2:02:22
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// [ String 클래스 메서드 정리 ] 
		String name1 = new String("abc");
		String name2 = new String("Abc");
		
		// System.out.println( name1.hashCode() );  // 54150062
		// System.out.println( name2.hashCode() );  // 54150062
		
		// 1. 두 문자열을 비교할 때는  == 연산자 사용하지 않고   equals() 메서드 사용한다. 
		System.out.println(    name1.equals(name2)  );                    // false
		// 2. 대소문자 구분하지 않고 두 문자열 비교                   equalsIgnoreCase()
		System.out.println(    name1.equalsIgnoreCase(name2)  );   // true
		 
		// 3. null / ""
		String a = null;
		String b = "";
		
		// 4. 문자열 길이 메서드  length()
		String msg = "안녕하세요. Kenik입니다.";
		
		// [문제] 한글은 제거하고 알파벳만 문자열로 만드세요.   ". Kenik."
		/*
		char [] chs = new char[8];
		int idx = 0;
		for (int i = 0; i < msg.length(); i++) {
			 // System.out.println( "'"+ msg.charAt(i) +"'" );
			 char one = msg.charAt(i) ;
			 if(      !( '가' <= one  && one  <= '힣' )        ) {
			 // if(       '가' > one  ||  one  > '힣'         ) {
				 // System.out.println( one );
				 chs[idx++] = one;
			 }
		}
		*/
		/*
		char [] msgCharArray = msg.toCharArray();
		for (int i = 0; i < msgCharArray.length; i++) {
			msgCharArray[i]
		}
		*/
		
		
		// char [] -> String 변환
		//System.out.println(   new String( chs )  );
		
		
		
		/*
		System.out.println(  msg.length() );  // 14
  
		//int [] m = new int[5];
		//System.out.println(   m.length   ); // 배열크기     length 속성(필드)
		
		// float 기본형    Float 래퍼(Wrapper)클래스
		
		// 5. charAt(index)
		System.out.println(  msg.charAt(1) );  // '녕'
		// msg 문자열 속에서 마지막 한 문자 얻어와서 출력.
		System.out.println(  msg.charAt(msg.length()-1) );  // '.'
		
		// 6. 문자열 대/소문자 변환하는 메서드 
		System.out.println(  msg.toUpperCase() );  // 안녕하세요. KENIK입니다.
		// 소문자 변경
		System.out.println(  msg.toLowerCase());  // 안녕하세요. kenik입니다.
		
		// System.out.println(  msg );  // "안녕하세요. Kenik입니다"
		
		// 7. substring()
		String rrn = "780123-1700001";
		// ㄱ.  주민번호 앞자리 6자리
		System.out.println(   rrn.substring(0, 6) );  // "780123"
		// ㄴ. 주민번호 뒷자리 7자리
		//System.out.println(   rrn.substring(7, 14) );  // "1700001"
		//System.out.println(   rrn.substring(7, rrn.length() ) );  // "1700001"
		System.out.println(   rrn.substring(7) );  // "1700001"
		
		// 8.  split()
		String []  rrns= rrn.split("-");
		System.out.println( Arrays.toString(rrns));  // [780123, 1700001]
		
		// 8-2. split( regex , int limit)
		String [] cards = "1234-2342-2356-9484".split("-", 3);
		System.out.println( Arrays.toString( cards )); // [1234, 2342, 2356-9484]
		
		// 9. String -> char [] 왜 ?    toCharArray() 메서드 
		rrn = "780123-1700001";
		*/
		
		// 10.  안녕하세요. Xenik입니다.
		System.out.println( msg.replace('K', 'X')  ); 
		// CharSequence 인터페이스  String
		// 업캐스팅 ,     인터페이스 다형성
		System.out.println( msg.replace("안녕", "Hello") );
		// regex  정규표현식
		System.out.println(  msg.replaceAll( "[가-힣]", "")   );  // ". Kenik."
		

		
	} // main

} // class





















