package smhrd;

import java.io.IOException;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub}
		int[][] mathS=new int[2][3];
		for(int i=0; i<mathS.length; i++) {
			for(int j=0; j<mathS[i].length; j++) {
				System.out.println(mathS[i][j]);
			}
		}
		
		int[][] engS=new int[2][];
		engS[0]=new int[3];
		engS[1]=new int[3];
		for(int i=0; i<engS.length; i++) {
			for(int j=0; j<engS[i].length; j++) {
				System.out.println(engS[i][j]);
			}
		}
		
		int[][] jS= {{94,29}, {23,45,23} };
		for(int i=0; i<jS.length; i++) {
			for(int j=0; j<jS[i].length; j++) {
				System.out.println(jS[i][j]);
			}
		}
		
		
	}}

