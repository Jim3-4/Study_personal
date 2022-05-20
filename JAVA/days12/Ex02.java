package days12;

import java.util.Random;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오전 9:41:50
 * @subject 
 * @content 
 * 
 */
public class Ex02 {
public static void main(String[] args) {
	/*
	 * for(int i='가'; i<'힣'; i++) { System.out.printf("%c\t%d\n", i,i); }
	성-128개
	 */
	Random rnd=new Random();
	System.out.print("김");
	for(int i=0; i<2; i++) {
		System.out.print((char)(rnd.nextInt(11172)+440032));
	}
	
	
	
	
	
}
}
