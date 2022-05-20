package days28;

import java.io.PrintStream;
import java.util.Date;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오후 12:36:41
 * @subject p 894 PrintStram 바이트 스트림  :  print()/println()/printf() 메서드 오버로딩 되어져 있다. 
 * @content          JDK 1.1 향상된 스트림 : PrintWriter 
 *                                             ? 다양한 언어의 문자로 출력(처리)이 가능하다.
 */
public class Ex06 {

	public static void main(String[] args) {
		String name = "홍길동";
		int age = 20;
		
		// 콘솔(화면)에 출력
		/*
		 * System.out.print(); 
		 * System.out.println(); 
		 * System.out.printf();
		 */
		
		PrintStream ps =  System.out;		
		ps.printf("이름=%s, 나이=%d\n", name, age);
		
		Date d = new Date();
		
		ps.printf("%1$tY년 %1$tm월 %1$td일   %1$tH:%1$tM:%1$tS \n", d);
		ps.printf("%1$tD \n", d);  // 03/29/22      월/일/년
		ps.printf("%1$tT \n", d);  // 12:43:39       시/분/초
		ps.printf("%1$tF \n", d);  // 2022-03-29   년/월/일
		
	} // main

} // class














