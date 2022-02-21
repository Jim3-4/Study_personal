package day06;

import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 2. 21. - 오전 11:06:07
 * @subject 
 * @content 
 * 
 */
public class Ex03_if {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("국어점수를 입력");
		int kor=sc.nextInt();
		String result;
		if(kor>=90) {
			result="수";
			System.out.println(result);
		}else if(80<=kor){
			result="우";
			System.out.println(result);
		}else if(70<=kor){
			result="미";
			System.out.println(result);
		}else if(60<=kor){
			result="양";
			System.out.println(result);
		}else {
			result="가";
			System.out.println(result);
	}

}}
