package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 2:29:12
 * @subject 
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		// p 419 try~catch문 흐름( 처리 과정 )
		
		System.out.println("1 코딩");
		System.out.println("2 코딩");
		
		try {
			System.out.println("3 코딩");
			System.out.println( 100 /  10); //  10
			System.out.println("4 코딩");
		} catch (Exception e) {
			System.out.println("5 코딩");
		} finally {  // 반드시 있어야 할 문은 아니다. 
			// [  예외 발생 여부에 상관없이 항상 처리하는 블럭 : finally {} ]
			// 예) 파일 열어서......            ... 파일닫기
			//       DB   Open ......CRUD...... Close
			System.out.println(" finally {}  ...");
		}
		
		System.out.println("6 코딩");
		System.out.println("정상적 종료!!!");
		
		// e.printStackTrace() : 메서드 정보와 예외 메시지 를 화면에 출력하는 메서드
		// e.getMessage()        : 예외 메시지를 반환하는 메서드 

	} // main
 
} // class

















