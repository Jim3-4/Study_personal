package days21;

import java.util.Random;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 2:56:38
 * @subject   p 500 Random 클래스 
 * @content    3:07 수업시작~
 */
public class Ex08 {

	public static void main(String[] args) {
		//  
		long seed =  System.nanoTime();
		Random rnd = new Random(seed);
		
		// 0<=  임의의값(난수)정수 < bound
		int bound = 101;
		//rnd.nextInt(bound);  // 0~정수~100		
		// rnd.nextBoolean(); // 임의의  true/false
		
		rnd.nextInt();   // -21억~ 21억
		// rnd.nextBytes(byte []);
		

	}  // main

} // class
