package day09;

import java.util.Random;

/**
 * @author 지민
 * @date 2022. 2. 25. - 오후 3:13:55
 * @subject 
 * @content 
 * 
 */
public class Ex04_04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		boolean flag=false;
		int[] lotto=new int[6];]
		
		
	}//main
	//중복되는지 안되는 지 체크
	//랜덤하게 발생한 int값 temp
	public static boolean isDuplicateLotto(int [] lotto, int idx, int temp)
	{
	boolean flag=false;
	for (int i = 0; i < idx; i++) {
        if( temp == lotto[i]) {
           flag = true;
           break;
        }
        return flag;
     }
	}
}
