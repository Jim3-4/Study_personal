package days21;

import java.io.FileReader;
import java.util.Arrays;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 3:14:10
 * @subject p 502 예제 9-28 
 * @content   3:18 코딩
 */
public class Ex09 {

	public static void main(String[] args) {
		//  String.repeat();  JDK 11 버전~  ***
		//  문제)
		// days20.Ex01.java읽어서 
		// 알파벳 
		// A 25
		// B 11
		// 배열에 저장해서 막대그래프 그리기..
		
		String fileName = "days20\\Ex01.java";
		// 경로
		//    ㄴ 절대경로   C:\\temp\\test\\abc.txt
		//     ㄴ 상대경로 :   기준 (    .      C:\SS16Class5\JavaClass\javaPro  )
		//String 기준경로 =  System.getProperty("user.dir");
		//System.out.println(기준경로);
		
		String path = String.format("%s\\src\\%s"  
				                                    ,  System.getProperty("user.dir")
				                                                        , fileName);
		
		// C:\SS16Class5\JavaClass\javaPro\src\days20\Ex01.java
		// System.out.println( path );
		
		int [] counter = new int[26]; // A a [0]         Z   z [25]
		//                                                65 97             90 122 
		char one;  // 
		int code;
		
		// try-with-resources 문
		try (
				FileReader fr = new FileReader( path );
				){
			while(  ( code = fr.read() )  !=  -1 ) {
				// System.out.printf("%d - %c\n", code, (char)code);
				//                     Character.isAlphabetic(code)
				if(  'A' <=  code && code <= 'Z'   ||   'a' <=  code && code <= 'z' ) {
					 code =  Character.toUpperCase(code);  // 65 ~ 90
					 counter[code-65]++; 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(  Arrays.toString(  counter ) );
		
		// 막대 그래프
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("[%c] : %s(%d)\n",  i+65 , printBarGraph('*', counter[i]) , counter[i]);
		}
		
		// [단어 갯수 파악 가능 ]
		// String  5
	} // main
	
	// printBarGraph('*', 10)  **********
	public static String printBarGraph( char style, int length ) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(style);
		}
		return sb.toString();
	}

} // class

//   com.util.Rnd.java 









