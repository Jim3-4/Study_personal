package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 7:54:23
 * @subject p 476 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// >21	2022-03-18(금)<
		// 9:25 수업 시작~
		//                    0    2
		String str1 = "안녕하세요. 홍길동입니다.";
		// String 클래스 선언 X        - str1 문자열을 자주 변경 -   추가, 삭제, 수정
		// 불변하는 자료형
		
		//1.    안녕 문자열 뒤에 (Hello) 문자열을  삽입(insert) =>  "안녕(Hello)하세요. 홍길동입니다."
		//   ㄱ. 안녕 위치 찾아야된다.  indexOf(), lastIndexOf()
		/*
		int findIndex = str1.indexOf("안녕");
		int index = findIndex + "안녕".length();		
		String before =  str1.substring(0, index );
		String after =  str1.substring(index );
		str1 = before + "(Hello)" + after;		
		System.out.println( str1 );
		*/
		
		// 2. 홍길동을 찾아서 "함세강"으로 수정.
		// 10:03 수업 시작~
		/*
		int findIndex = str1.indexOf("홍길동");
		int index = findIndex + "홍길동".length();		
		String before =  str1.substring(0, findIndex );  // 안녕하세요. 
		String after =  str1.substring(index ); // 입니다.
		str1 = before + "함세강" + after;		
		System.out.println( str1 );  // 안녕하세요. 함세강입니다.
		*/
		/*
		str1 = str1.replace("홍길동", "함세강");  // replaceAll( 정규표현식 , 바꿀문자열 )  replaceFirst( 정규표현식, 바꿀문자열 )
		System.out.println( str1 );
		*/
		
		// 3. 홍길동 찾아서 삭제 - "안녕하세요. 입니다.";
		/*
		int findIndex = str1.indexOf("홍길동");
		int index = findIndex + "홍길동".length();		
		String before =  str1.substring(0, findIndex );  // 안녕하세요. 
		String after =  str1.substring(index ); // 입니다.
		str1 = before + after;		
		System.out.println( str1 );  // 안녕하세요. 입니다.
		
		str1 = str1.replace("홍길동", "");  // replaceAll( 정규표현식 , 바꿀문자열 )  replaceFirst( 정규표현식, 바꿀문자열 )
		System.out.println( str1 );
		*/
		
	} // main

} // class


/*
 *                      [C 9 유용한 클래스 - 자주]    
 *                      C 10 날짜/시간
 *                      C 11 컬렉션 프레임워크
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크
 * 1. Object
 *     - 메서드   clone(), toString(), hashCode(), equals(), getClass()      + notify(), notifyAll(), wait()(3개) 스레드
 *     -             MyPoint  오버라이딩.
 * 2. 문자열 클래스
 *     ㄴ [ String ] 불변X  - 메서드          17. join() 메서드
 *     
 *     ㄴ StringBuffer
 *     ㄴ StringBuilder
 *     ㄴ StringTokenizer    
 *     
 *     5:05  ~ 팀별 복습(스터디)       5:48 줌 - 퇴실체크
 * */ 



/*
 * 1. [ String 클래스의 메서드 활용 ]
 *     String path = "C:\\SS16Class5\\JavaClass\\javaPro\\src\\days20\\SS16교육생명단.txt";
 *    위의 절대경로에서 파일명만  String fileName 변수에 저장하고            SS16교육생명단.txt
 *    파일명의 확장자만  String extender 변수에 저장하세요.                     .txt
 *    
 * 2. 객체로 부터 [Class 객체]를 얻어오는 3가지 방법에 대해서 설명하세요 .
 *     Class 객체 왜  얻어오는가 ?  
 *   ㄱ.
 *   ㄴ.
 *   ㄷ.
 *   
 * 3. 얕은복제, 깊은 복제에 대해 설명하세요 
 * 
 * 4.   String 클래스의 메서드 설명 - 기능, 매개변수, 리턴값(리턴자료형)
  ㄱ. length()  - 문자열의 길이를 반환하는 메서드, X, int
  ㄴ. charAt()  - 문자열 속에서 원하는 위치의 한 문자를 반환하는 메서드,  int index ,  char
  ㄷ. compareTo() - 문자열을 비교하는 메서드 , 비교할문자열 , 양수, 음수 , 0      
  ㄹ. equals() / equalsIgnoreCase() - 문자열을 비교하는 메서드 , 비교할문자열  , boolean   
  ㅁ. concat()   
  ㅅ. startsWith()  
  ㅇ. endWith()     
  ㅈ. indexOf()      
      lastIndexOf()  
  ㅊ. replace()     
            replaceAll( regex )
            replaceFirst(regex)
  ㅋ. String [] split()
  ㅌ. toUpperCase() / toLowerCase()
  ㅍ. trim()           
  ㅎ. valueOf()      //  ***** 
  ㄱ. join()
  ㄴ. format()  
  ㄷ. matches()
  ㄹ. substring()  문자열 속에서 내가 원하는 한 문자열을 반환 메서드,    int beginIndex, [int endIndex],  String
  :
  :    
  5. 기본형을 String 으로 변환하는 코딩을 하세요..
       
  
  6.  [p 472~473 꼭 읽어서 예제 코딩 ] 
    아래 코딩을 주석을 달아서 설명하세요.  ***  교재 예제 (정독) / 
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "가";		
		byte [] bArr = str.getBytes("UTF-8");		 // byte [] 문자열.getBytes(인코딩);
		//                                                                                문자열 -> byte[] 로 변환하는 메서드 
        //                                                                                                 왜?   메시지/파일 ->  [소켓]      네트워크( 바이트 )  ->   송/수신        
		System.out.println("UTF-8 : "  + joinByteArr(bArr));		
		System.out.println("UTF-8 : " + new String(bArr,"UTF-8"));  // String 생성자(  byte [], "인코딩");
	} 
	
	joinByteArr 선언부분
	
 7. [Object 클래스]의  equals() 메서드와   == 연산자를 비교해서 차이점을 설명하세요.
 	
 	MyPoint p1 = new MyPoint(1,2);
 	MyPoint p2 = new MyPoint(1,2);
 	
 	동일한 처리            0x100 == 0x200
 	p1 == p2           false   참조주소값 비교
 	p1.equals(p2)  false     참조주소값 비교
 	
 	int a = 1, b =2;
 	
 	a == b       false
 	a.equals(b) X
 	
 	String .equals() 오버라이딩
 	MyPoint.equals() 오버라이딩.
 * */


















