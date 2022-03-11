package days12;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오전 10:44:02
 * @subject 
 * @content 
 * 
 */
public class Ex06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score= {79,88,91,33,100,55,95};
		
		int max=score[0], min=score[0];
		for(int i=1; i<score.length; i++) {
			/*
			 * max=max<score[i]? score[i]:max; min= min<score[i]? score[i]:min;
			 * //if(max<score[i]) max=score[i];
			 */	
			if(max<score[i]) max=score[i];
			else if(min>score[i]) min=score[i];
		}
		System.out.println("최댓값: "+max);
	}//main

}//class
