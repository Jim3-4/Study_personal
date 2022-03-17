package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 3:51:39
 * @subject p 434 finally 블럭
 * @content 
 */
public class Ex16 {

	public static void main(String[] args) {
		// 4:03 수업 시작~
		// p 435 예제  8 - 19
		
		int result =  method1();

		System.out.println("END.");
	} // main

	private static int method1() { 
		try {
			System.out.println("> method1() - [1]");
			System.out.println("> method1() - [2]");
			return 1; // 리턴값을 가지고 호출한 곳으로 리턴되더라도 
		} catch (Exception e) {
			System.out.println("> method1() - [3]");
			return -1;
		}finally { // 블럭은 반드시 처리를 한다... 
			System.out.println("> method1() - [4]");
		}
		//return 0;
	}

} // class








