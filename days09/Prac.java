package day09;

import java.util.Random;

/**
 * @author 지민
 * @date 2022. 3. 9. - 오후 5:37:17
 * @subject 
 * @content 
 * 
 */
public class Prac {

	/**
	 * @param args
	 */
public static void main(String[] args) {
//power 거듭제곱 구하는 함수 

	int[] lotto=new int[6];
	fillLotto(lotto);
	dispLotto(lotto);
	}
/**
	 * @param lotto
	 */
	private static void dispLotto(int[] lotto) {
		// TODO Auto-generated method stub
		for(int i=0; i<lotto.length; i++) {
			System.out.printf("%d",lotto[i]);
		}
	}
/**
	 * @param lotto
	 */
	private static void fillLotto(int[] lotto) {
		// TODO Auto-generated method stub
		int idx=0;
		Random rnd=new Random();
		for(int i=0; i<6; i++) {
			lotto[idx]=rnd.nextInt(45)+1;
			do {
				lotto[idx]=rnd.nextInt(45)+1;
			}while(lotto[i]==lotto[i-1]);
			
			
		}
		
	}
	
public static boolean isDuplicateLotto(int[] lotto, int idx, int temp) {

}
