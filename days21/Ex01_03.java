package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 10:16:16
 * @subject 
 * @content                StringBuilder 클래스의 차이점 - 스레드에 안전하다( == [동기화 처리]가 되어져 있다 )
 *                                  StringBuffer  클래스의 차이점
 *                                  
 *                                  동기화 
 *                                  예) A 사람(스레드),            B 사람(스레드)
 *                                  
 *                                  
 *                                  
 *                                                화장실 1개(공유자원)
 *                                                잠금(lock) - 화장실 문고리 잠금          - 동기화처리
 *                                                A 사람 ( 대변기 )
 */
public class Ex01_03 {

	public static void main(String[] args) {
		// 문자열을 수정,삭제,추가 등등 변경 자주 -> String X,  StringBuffer, StringBuilder  사용...
		String str1 = "안녕하세요. 홍길동입니다.";
		// 버퍼(buffer)
		// toString() 메서드 오버라이딩(재정의)
		
		StringBuilder sb = new StringBuilder(str1);
		
		// System.out.println(  sb.toString() );  // 자신 정보 문자열로 반환하는 메서드
		System.out.println(  sb );
		
		// 1. 안녕 + (Hello)  삽입 -  insert()
		// System.out.println( sb.reverse() );
		int idx = sb.indexOf("안녕") + "안녕".length();
		System.out.println( sb.insert( idx , "(Hello)") );
		
		// 2. 홍길동 삭제             - delete()
		int start = sb.indexOf("홍길동");
		int end = start + "홍길동".length();
		//System.out.println( sb.delete(start, end)  );
		
		// 3. 홍길동 -> 함세강  수정
		System.out.println( sb.replace(start, end, "함세강") );
		
	} // 

}
