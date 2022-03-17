package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 2:19:43
 * @subject 
 * @content 
 */
public class Ex09 {

	public static void main(String[] args) {
		// p 418 예제 8-3
		
		int number = 100;
		int result = 0;
		
	
			for (int i = 0; i < 10 ; i++) {
				try {
					//  1<= (int)(Math.random()*9)+1  <=9
					// 0
					result  =     number / (int)(Math.random()*10);  // 0~9 정수
					System.out.println(  result );
				} catch (Exception e) {
					System.out.println("0");
				} // try
			} // for
		
		
		/*
		try {
			for (int i = 0; i < 10 ; i++) {
				// 0
				result  =     number / (int)(Math.random()*10);  // 0~9 정수
				System.out.println(  result );
			}
		} catch (Exception e) {
			System.out.println("0");
		}
		*/

	} // main

} // class














