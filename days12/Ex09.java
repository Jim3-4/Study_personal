package days12;

import java.util.Arrays;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오후 2:38:44
 * @subject 
 * @content 
 * 
 */
public class Ex09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m=new int[30];
		for(int i=0; i<m.length; i++) {
			m[i]=(int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(m));
		
		int count;
		for(int i=0; i<=9; i++) {
			count=0;{
			for(int j=0; j<m.length; j++) {
				if(i==m[j]) count++;
		
			}
			System.out.printf("%d의 갯수 : %d\n", i, count);
			}}
	
	}//main

}//class 
