package days23;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 11:46:40
 * @subject   p 551 
 * @content 
 */
public class Ex05_03 {

	public static void main(String[] args) {
		//    *** MessageFormat 클래스 : 출력된 데이터로 부터 필요한 데이터만 뽑아내겠다. ***
//		String name  
//		int age  ;
//		boolean gender  ;
		
		String  source = "이름:kenik, 나이:20살, 성별:남자";
		
		// 파싱( parse )
		// ,     구분자  split()
		// :     구분자  split()
		//         [1] -> 가공  name, age, gender 얻어올 수 가 있다. 
		
		// MessageFormat.format(source, args)
		// parse() 메서드 
		
		String pattern = "이름:{0}, 나이:{1}살, 성별:{2}";
		MessageFormat mf = new MessageFormat(pattern );
		try {
			Object [] objs = mf.parse(source);
			for (Object a : objs) {
				System.out.println( a );
			}
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		
		
		
		

	} // main

}  // class







