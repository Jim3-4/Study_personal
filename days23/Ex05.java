package days23;

import java.text.MessageFormat;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 11:37:28
 * @subject  p 549 MessageFormat 클래스
 * @content          데이터를 형식에 맞춰서 출력하는 클래스 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 
		String name ="kenik";
		int age = 20;
		boolean gender = true;
		
		// 이름:kenik, 나이:20살, 성별:남자
		/*// 권장
		String message = String.format("이름:%s, 나이:%d살, 성별:%s"
				 , name, age, gender ? "남자" : "여자");
		System.out.println( message );
		*/
		
		// [	MessageFormat 클래스]
		/* 아래와 같이 코딩을 하지 않아도 된다.    이유 ? 
		String pattern = "";
		MessageFormat mf = new MessageFormat(pattern);
		String message = mf.format(  );
		System.out.println( message );
		*/
		
		// 이유 ? static 메서드이기 때문에                        C# 언어
		String message = MessageFormat.format("이름:{0}, 나이:{1}, 성별:{2}"
				                                                                    , name, age, gender ? "남자" : "여자");
		System.out.println( message );
		

	} // main

} // class





