package days19;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 2:48:41
 * @subject  p 425 예외 발생시키기
 * @content            개발자가 고의로 예외를 발생 시킬 수 있다. 
 *                              왜 ?
 *                              throw문 사용.
 *                              
 *                              1) 예외 객체 생성
 *                              2) throw 예외객체;
 */
public class Ex12 {

	public static void main(String[] args) {
		// 3:00 수업 시작~
		int a = 10;
		int b = 20;
		
		//NullPointerException e = new NullPointerException("강제 널 예외 발생");
		//throw e;		
		// throw new NullPointerException("강제 널 예외 발생");
		
		// throw new RuntimeException();
		
		//int c = a + b;
		//System.out.printf("%d+%d=%d\n", a,b,c);
		
		//System.out.println("정상적 종료!!");

	} // main

} // class














