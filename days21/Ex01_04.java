package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 10:36:42
 * @subject 
 * @content   앞으로 문자열 변경하는 코딩 : String x, StringBuffer, StringBuilder 사용해야 된다. 
 */
public class Ex01_04 {

	public static void main(String[] args) {
		// 문자열이 자주 변경이되면 String X, StringBuffer, StringBuilder(O)
		
		// [ 200배 이상의 속도 차이가 난다 ]
		// testString();  // >  처리 시간 : 21초 191914100ns		
		testStringBuffer(); //  >  처리 시간 : 0초 021778100ns

	} // main

	public static void testString() {
		//  long        현재 시간 1밀리세컨드 = 1/1000초   1970.1.1 ~ 밀리세컨드
		// System.out.println( System.currentTimeMillis() ); // 1647567610888ms
		long start =  System.nanoTime();  // 1 nano = 1/1000000000초
		// System.out.println( start ); // 227832016606500
		
		// 인스턴스(객체) 생성하는 코딩 - 시간 많이 걸린다. 
		// 20만번 for문 반복될 때 인스턴스(객체)가 20만개 생성-> 참조
		String sb = "a";
		for (int i = 0; i < 200000; i++) {
			sb += "a";  // sb = sb +"a";
		}
		
		long  end=  System.nanoTime(); 
		
		System.out.println( " >  처리 시간 : " + (end-start) + "ns");
	}
	public static void testStringBuffer() {
		long start =  System.nanoTime();  
		
		StringBuffer sb = new StringBuffer("a");
		
		for (int i = 0; i < 200000; i++) {
			sb.append("a");
		}
		
		long  end=  System.nanoTime(); 
		
		System.out.println( " >  처리 시간 : " + (end-start) + "ns");
	}
} // class












