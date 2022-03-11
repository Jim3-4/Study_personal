package day10;

import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오후 12:32:54
 * @subject 
 * @content 
 * 
 */
public class Ex05_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rrn=getRRN();
		System.out.println(rrn);
		
		boolean gender=getGender(rrn);
		System.out.println(gender? "남자":"여자 ");
	}

	/**
	 * @param rrn
	 * @return
	 */
	//남자-true, 여자-false;
	private static boolean getGender(String rrn) {
		// TODO Auto-generated method stub
		return (rrn.charAt(7)-48)%2==1? true: false;
		
	}

	/**
	 * @return
	 */
	public static String getRRN() {
		// TODO Auto-generated method stub
	String rrn, temp, regex="\\d{6}-\\d{7}";
	do {
		Scanner sc=new Scanner(System.in);
		System.out.println("주민등록번호입력");
		temp=sc.next();
	} while (!temp.matches(regex));
	rrn=temp;
	return rrn;
	}
	
	

	
}
