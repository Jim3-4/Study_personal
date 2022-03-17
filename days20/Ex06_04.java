package days20;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 3:30:27
 * @subject 
 * @content 
 */
public class Ex06_04 {

	public static void main(String[] args) {
		//  14. compareTo()
		/*
		String a = "kbs";
		String b = "kcs";		
		// 두 문자열을 비교               boolean equals(), equalsIgnoreCase() ,     양수, 0(두 문자열 같다), 음수 compareTo() 
		System.out.println( a.compareTo(b));  // -8  음수
		System.out.println( b.compareTo(a));  // 8    양수
		*/
		
		// 15. startsWith(), endsWith()
		/*
		String url = "http://www.naver.com"; //     반드시  "http://"  문자열로 시작을 해야지 올바른 URL 이다.  
        // 정규표현식 ^http://.*
		String prefix = "http://"; //  접두사
		System.out.println( url.startsWith(prefix) );  // false
		
		String suffix = ".com"; // 접미사
		System.out.println(url.endsWith(suffix) ); 
		*/
		
		/*
		// [문제] 파일 열어서 읽기         -> 파일의 경로
		// dir 문자열의 마지막에   문자가   '\'  확인 하는 코딩을 하세요. 
		// 
		String dir = "C:\\temp\\test";
		String filename = "aaa.html";
		
		String fullPath = dir  +  (  dir.endsWith("\\") ? "" : "\\"  )+   filename;
		
		System.out.println( fullPath );
		*/
		
		// 16. join()  기억해 두세요~ JSP/Spring
		String [] names = {"안시은","박단","김재우", "유환재","김기태"};
		
		// static 메서드 - 클래스명.메서드명()
		String result = "<ol><li>"+String.join("</li><li>", names ) + "</li></ol>";
		System.out.println(result );
		
		/*
		String result = "<ol>";
		for (int i = 0; i < names.length; i++) {
			result +="<li>";
			result += names[i];
			result +="</li>";
		}
		result += "</ol>";
		System.out.println( result );
		*/
		//  "<ol><li>안시은</li><li>박단</li><li>김재우</li><li>유환재</li><li>김기태</li></ol>"
		/*
			<ol>
					  <li>안시은</li>
					  <li>박단</li>
					  <li>김재우</li>
					  <li>유환재</li>
					  <li>김기태</li>
			 </ol>
		 * */
		

		// 17.  "".matches(정규표현식)
	} // main

} // class











