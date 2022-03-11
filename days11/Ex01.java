package days11;

/**
 * @author 지민
 * @date 2022. 3. 3. - 오전 9:07:31
 * @subject 
 * @content 
 * 
 */
public class Ex01 {
public static void main(String[] args) {
	int year, month;
	if(args.length!=2) {
		System.out.println(">java.exe Ex01 2010 5 년도 월 매개변수 할당 ");
		return;
	}
	
	year=Integer.parseInt(args[0]);
	month=Integer.parseInt(args[1]);
	System.out.printf("%d월 %d일", year, month);
	
	
	printCalendar(year, month); //메서드 호출부분
	
	//총 날짜수 %7= 요일(0~6)
	int dayOfWeek=getDayOfWeek(year, month);	 
}//main

/**
 * @param year
 * @param month
 * @return
 */
private static int getDayOfWeek(int year, int month) {
	// TODO Auto-generated method stub
	int totalDays=getTotalDays(year, month,1);
	System.out.println("총 날짜수 "+totalDays);
	int dayOfWeek=totalDays%7;
	return dayOfWeek;
}

/**
 * @param year
 * @param month
 */
private static void printCalendar(int year, int month) {
	// TODO Auto-generated method stub
	//총 날짜수 
	//총 날짜수 %7=요일 (0~6)
	
	int totalDays= getTotalDays(year, month, 1);
	System.out.println("총 날짜수 "+totalDays);
}//printCalender 

/**
 * @param year
 * @param month
 * @param i
 * @return
 */
private static int getTotalDays(int year, int month, int i) {
	// TODO Auto-generated method stub
	int totalDays=0;
	for(int j=1; j<year; j++) {
		totalDays+=(j%4==0 && i %100 !=0 || i%400==0)? 366: 365;
		//if(윤년함수있는 클래스.isLeapYear(i)
	
	}
	
	//2 ) 그년도 year(2010)의 1(3!) 2(28) 3(31) ,,, month-1(30)+1
	
	return totalDays;
}
}
