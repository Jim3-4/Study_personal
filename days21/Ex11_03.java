package days21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 4:32:27
 * @subject  p 508  예제 9-33
 * @content 
 */
public class Ex11_03 {

	public static void main(String[] args) {
		
		/* String.matches() 메서드 
		 String source = "02-999-9999";
		//String source = "011-1111-1111";
		String pattern = "0\\d{1,2}-\\d{3,4}-\\d{4}";		
		// System.out.println(  source.matches(pattern)  );
		*/
		
		
		/* java.util.regex 패키지 - Pattern, Matcher
		String source = "011-1111-1111";
		String pattern = "0\\d{1,2}-\\d{3,4}-\\d{4}";	
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source); 
		System.out.println(  m.matches() );
		*/
		
		// String password = "Zs0df#66";
		// String regex = ???
		
		String source = "HP:011-1111-1111, HOME:02-999-9999";
		// 정규식의 일부를 괄호를 나누어 묶어서 그룹화(grouping)할 수 있다.
		// 그룹화된 부분은 하나의 단위로 묶어서 셈이 되어서 한 번 또는 그 이상 반복을
		// 을 의미하는 + * ? {1,2}. 뒤에 오면 그룹화된 부분이 적용대상이 된다.
		// String regex = "(0\\d{1,2})-()-        ()";  // 그룹  
		//                          그룹1             그룹2      그룹3
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source); 
		
		int i = 0 ;
		
		// m.matches() 메서드 ? 
		// m.find() 메서드        ?
		while( m.find( ) ) {
			System.out.println(  m.group() + "---- " + m.group(1)  + "/ " + m.group(2) + "/ " + m.group(3));
		}

	} // main

} // class











