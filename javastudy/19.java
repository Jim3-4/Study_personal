package smhrd;

import java.io.IOException;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub}
		String[] oldArray= {"java", "array", "copy"};
		String[] newArray=new String[4];
		
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		
		for(int i=0; i<newArray.length; i++) {
			System.out.println(newArray[i]);
		}
	}}

