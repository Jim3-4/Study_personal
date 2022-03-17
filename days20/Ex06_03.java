package days20;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 2:50:12
 * @subject 
 * @content 
 */
public class Ex06_03 {

	public static void main(String[] args) {
		// [String 클래스 메서드 정리]
		// 11. trim()                                                     ltrim() rtrim()
		String str = "    abc   ";     // id "kenik "
		System.out.printf("[%s]\n",   str.trim()   );  //  "abc"
		
		// 12.  concat() 문자열 연결하는 메서드
		// 3:05 수업 시작~
		
		String a = "123";
		String b  ="456";		
		// String c = a + b;  // + 문자열 연결 연산자      "123456"
		// String c =  a.concat(b);
		String c = "789";
		
		// String result = a + b + c;  // "123456789"
		String result =  a.concat(b).concat(c);
		
		// 13. int indexOf() /  int  lastIndexOf()
		//                    0               7       10       15     18
		String msg = "안녕하세요. 홍길동입니다. 홍길동은 무엇을 잘 합니다. ";
		// [ 문제 ] 홍길동을 뒤에서 부터 찾아서 인덱스를 모두 출력하세요.
		// 15
		// 7
		int findIndex, fromIndex = msg.length()-1 ;
		while(  (findIndex =  msg.lastIndexOf("홍길동", fromIndex)) !=  -1) {
			System.out.println(	findIndex   );
			fromIndex = findIndex  -1;
		} 
		
		
		/*
		int findIndex =  msg.lastIndexOf("홍길동" );
		System.out.println( findIndex);  //15
		
		int fromIndex = findIndex -1;
		findIndex =  msg.lastIndexOf("홍길동", fromIndex );
		System.out.println( findIndex);  //7
		
		fromIndex = findIndex -1;
		findIndex =  msg.lastIndexOf("홍길동", fromIndex );
		System.out.println( findIndex);  //-1
		*/
		
		// [ 문제 ] 홍길동을 앞에서 부터 찾아서 인덱스를 모두 출력하세요. 
		/*
		int findIndex, fromIndex = 0 ;
		while(  (findIndex =  msg.indexOf("홍길동", fromIndex)) !=  -1) {
			System.out.println(	findIndex   );
			fromIndex = findIndex + "홍길동".length();
		} 
		*/
		/*
		int findIndex =  msg.indexOf("홍길동") ;
	    System.out.println(	findIndex   );
	    int fromIndex = findIndex + "홍길동".length();  // 7 + 3 = 10
	    findIndex =  msg.indexOf("홍길동", fromIndex);
	    System.out.println(	findIndex   );
	    
	    fromIndex = findIndex + "홍길동".length();  // 15 + 3 = 10
	    findIndex =  msg.indexOf("홍길동", fromIndex);
	    System.out.println(	findIndex   );
	    */
  
	} // main

} // class







