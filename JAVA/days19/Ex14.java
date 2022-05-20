package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 3:31:37
 * @subject 
 * @content 
 */
public class Ex14 {

	public static void main(String[] args) throws Exception {
		// 429 예제 8-12
       // try {
			method1();
		//} catch (Exception e) { 
		//	e.printStackTrace();
		//}
	} // main

	private static void method1() throws Exception {
		//try {
			method2();
		//} catch (Exception e) { 
		//	e.printStackTrace();
		//}
		System.out.println(" > method1() 호출됨.");
	}

	private static void method2() throws Exception {
		System.out.println(" > method2() 호출됨.");
		
		throw new Exception();  // 컴파일러가 예외 처리 체크  "checked 예외"
	}

} // class













