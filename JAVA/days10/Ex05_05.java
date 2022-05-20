package day10;

import java.util.Date;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오후 3:01:38
 * @subject 
 * @content 
 * 
 */
public class Ex05_05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rrn=day10.Ex05_02.getRRN();
		int 세는나이=getAge(rrn);
		System.out.println(세는나이);
		
		int americanAge=getAmericanAge(rrn);
		System.out.println(americanAge);
		
	}

	/**
	 * @param rrn
	 * @return
	 */
	private static int getAmericanAge(String rrn) {
		// TODO Auto-generated method stub
		int age;
		Date d=new Date();
		int yearBD=Integer.parseInt(Ex05_04.getBirth(rrn).substring(0,4));
		
		//getYear는 원래년도에서 1900을 빼서 돌려줌 
		int now=d.getYear()+1900;
		age=now-yearBD+1;
		if(  ) age--;
		return age;
	}



	private static int getAge(String rrn) {
		// TODO Auto-generated method stub
		//세는나이 
		int yearBD=Integer.parseInt(Ex05_04.getBirth(rrn).substring(0,4));
		Date d=new Date();
		//getYear는 원래년도에서 1900을 빼서 돌려줌 
		int now=d.getYear()+1900;
		System.out.println("올해년도:"+now);
		int data=now-yearBD+1;
		return data;
	}

	/**
	 * @param birthday
	 * @return
	 */
	/*
	 * private static int calAge(String birthday) { // TODO Auto-generated method
	 * stub int year=Integer.parseInt(birthday.substring(0,4)); int
	 * calYear=2022-year+1; return calYear; }
	 */
	

}
