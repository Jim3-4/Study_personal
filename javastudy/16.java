package smhrd;

import java.io.IOException;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub}
		
		
		int[] arr1=new int[3];
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr["+i+"]:"+arr1[i]);
		}
		
		arr1[0]=12;
		arr1[1]=154;
		arr1[2]=234;
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1["+i+"]:"+arr1[i]);
		}
		
		double[] arr2=new double[3];
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr2["+i+"]:"+arr2[i]);
		}
		arr2[0]=0.2;
		arr2[1]=0.3;
		arr2[2]=3.2;
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr2["+i+"]:"+arr2[i]);
		}
	}}

