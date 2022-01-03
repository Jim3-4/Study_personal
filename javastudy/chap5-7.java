package smhrd;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=0;
		int[] array= {1,5,3,8,2};
		
		for(int i: array) {
			if(max<i)
				max=i;
		}
		
		System.out.println(max);
		
	}
}
