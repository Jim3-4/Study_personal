package days15;

import java.awt.Point;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 12:22:14
 * @subject 
 * @content 
 * 
 */
public class Ex04_02 {
	public static void main(String[] args) {
	Point2 p1=new Point2();
	p1.x=10;
	p1.y=20;
	
	p1.printPoint();
	swap(p1);
	p1.printPoint();
			
			
}
	/**
	 * @param p1
	 */
	private static void swap(Point2 p1) {
		// TODO Auto-generated method stub
		int temp=p1.x;
		p1.x=p1.y;
		p1.y=temp;
	}
	class Point2{
		public int x;
		 public int y;
		 public void printPoint() {
			 System.out.printf("> x=%d, y=%d\n", x, y);
		 }
	}
	}