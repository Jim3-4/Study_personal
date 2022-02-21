package day06;

import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 2. 21. - 오전 10:48:27
 * @subject 
 * @content 
 * 
 */
public class Ex03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("국어점수를 입력");
int kor=sc.nextInt();
String result;
switch(kor/10) {
case 9: 
	result="수";
	System.out.println(result);
	break;
case 8:
	result="우";
	System.out.println(result);
	break;
case 7:
	result="미";
	System.out.println(result);
	break;
case 6:
	result="양";
	System.out.println(result);
	break;
default:
	result="가";
	System.out.println(result);
	break;
}
	}

}
