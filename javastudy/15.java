package smhrd;

import java.io.IOException;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub}
		
		int[] scores;
		scores=new int[] {83,90,87};
		int sum1=0;
		for(int i=0; i<3; i++) {
			sum1+=scores[i];
		}
		System.out.println("총합:"+sum1);
	
		int sum2=add( new int[] {83,90,87} );
		
}

	private static int add(int[] is) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0; i<is.length; i++) {
			sum+=is[i];
		}
		return 0;
	}}

