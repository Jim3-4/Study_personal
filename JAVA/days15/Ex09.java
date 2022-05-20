package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 11:30:11
 * @subject 
 * @content 
 * 
 */
public class Ex09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 4:06 수업 시작~
		// MyPoint 클래스 추가
		MyPoint p1 = new MyPoint();
		p1.x = 10;
		p1.y = 20;
		p1.dispPoint();
		
		// 기본형  int   5   == 기본형 매개변수
		p1.offsetPoint(5);		
		p1.dispPoint();
		
		// p1.x=15, p1.y=25
		
		MyPoint p2 = new MyPoint();
		p2.x = 1;
		p2.y = 2;
		
		//              MyPoint p2 == 참조형 매개변수
		p1.plusPoint(  p2  );  
		// p1.x = p1.x + p2.x
		// p1.y = p1.y + p2.y;
		
		p1.dispPoint();  // > x=16, y=27
	}

}
