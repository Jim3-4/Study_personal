package smhrd;

import java.io.IOException;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub}
		
	String name1="apple";
	String name2="apple";
	if(name1==name2) {
		System.out.println("참조가 같다.");
	}else {
		System.out.println("참조가 다르다 ");
	}
	
	if(name1.equals(name2)) {
		System.out.println("문자열이 같다.");
	}
	
	String name3=new String("apple");
	String name4=new String("apple");
	if(name3==name4) {
		System.out.println("참조가 같다.");
	}else {
		System.out.println("참조가 다르다 ");
	}
	
	if(name3.equals(name4)) {
		System.out.println("문자열이 같다.");
	}
		
}}

