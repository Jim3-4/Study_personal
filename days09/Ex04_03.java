package day09;

import java.util.Random;

/**
 * @author 지민
 * @date 2022. 2. 25. - 오후 2:46:37
 * @subject 
 * @content 
 * 
 */
public class Ex04_03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		boolean flag=false;
		int[] lotto=new int[6];
		
		lotto[0]=7;
		lotto[1]=32;
		lotto[2]=15;
		lotto[3]=8;
		
		int idx = 4;
        int temp ;
      do {
    	  flag=false;
         temp = rnd.nextInt(45) + 1; 
         
         for (int i = 0; i < idx; i++) {
            if( temp == lotto[i]) {
               flag = true;
               break;
            }
         }
      } while (flag );
      
      lotto[idx] = temp;
	}

}
