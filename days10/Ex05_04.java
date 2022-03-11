package day10;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오후 2:20:16
 * @subject 
 * @content 
 * 
 */
public class Ex05_04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//같은 패키지를 사용중이라면, 패키지 이름은 안적어도됨
		//패키지명. 클래스명.메소드명 
		String rrn=day10.Ex05_02.getRRN(); //980304-2234234
		System.out.println(rrn);
	//주민등록번호->생년월일
		
	String birthday=getBirth(rrn);
	System.out.println(birthday);
	}

	/**
	 * @return
	 */
	public static String getBirth(String rrn) {
		// TODO Auto-generated method stub
		/*
		 * int year=Integer.parseInt(rrn.substring(0,2)); if (year>22) {
		 * year=Integer.parseInt(rrn.substring(0,2))+1900; }else { year=
		 * Integer.parseInt(rrn.substring(0,2))+2000; } int
		 * month=Integer.parseInt(rrn.substring(2,4)); int
		 * day=Integer.parseInt(rrn.substring(4,6)); String
		 * birthday=year+"년 "+month+"월 "+day+"일"; return birthday;
		 */
		
		int year=Integer.parseInt(rrn.substring(0,2));
		int month=Integer.parseInt(rrn.substring(2,4)); //01->1
		int day=Integer.parseInt(rrn.substring(4,6));
		
		//네 자리의 연도로 만들기
		switch(rrn.charAt(7)-48) {
		case 0: case 9:
			year+=1800;
			break;
		case 1: case 2: case 5: case 6:
			year+=1900;
			break;
		default:
			year+=2000;
			break;
		}
		
		//String.format() 내가 원하는 형식의 문자열로 변환
		String birthday=String.format("%d년 %02d월 %d일",year,month,day);
		
		return birthday;
	}

}
