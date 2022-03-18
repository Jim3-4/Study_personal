package days21;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오전 10:54:40
 * @subject 
 * @content 
 */
public class Ex01_05 {

	public static void main(String[] args) {
		// 11:05  수업 시작
		// [문제] Ctrl + Alt + Del 작업관리자
		/*
		문제 설명
		길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
		예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

		제한 조건
		n은 길이 10,000이하인 자연수입니다.
		입출력 예
		n	return
		3	"수박수"
		4	"수박수박"
		*/ 
 
	   long start =  System.nanoTime(); 
	   					String answer = solution(10000);
	   long  end=  System.nanoTime(); 		
	   System.out.println( " >  처리 시간 : " + (end-start) + "ns");
	   System.out.println( answer );
		
	} // main
	
	
	public static  String solution(int n) {
	      StringBuffer  answer = new StringBuffer("");
	      
	      for (int i = 1; i <= n/2; i++) 	answer.append("수박");
	      
	      // "수박".repeat(n/2);
	      
	      
	      if( n%2 != 0 ) answer.append("수");
	      
			return answer.toString();
	  }
	

} // class

class Solution {
	  //   >  처리 시간 : 150,050,700ns
	/*
	  public String solution(int n) {
	      String answer = ""; 
	      for (int i = 1; i <= n; i++) {
			if ( i % 2 == 1) {  // 
				answer += "수";
			} else {
				answer += "박";
			}
		  }
			return answer;
	  } 
	*/
	
	 // >  처리 시간 : 1,572,200ns
	/*
	public String solution(int n) {
	      StringBuffer  answer = new StringBuffer("");
	      
	      for (int i = 1; i <= n; i++) {
			if ( i % 2 == 1) {  // 
				answer.append("수");
			} else {
				answer.append("박");
			}
		  }
			return answer.toString();
	  }
   */
	
	 // >  처리 시간 : 926,300ns
	public static  String solution(int n) {
	      StringBuffer  answer = new StringBuffer("");
	      
	      for (int i = 1; i <= n/2; i++) 	answer.append("수박");  
	      if( n%2 != 0 ) answer.append("수");
	      
			return answer.toString();
	  }
}






