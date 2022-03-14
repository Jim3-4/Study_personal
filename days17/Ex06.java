package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 12:23:04
 * @subject 
 * @content 
 * 
 */
public class Ex06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p= {
				new Point(1,1), new Point(10,100),
				new Point(120,15)
		};
		Triangle t=new Triangle(p);
	}

}
class Shape{
	String color="black";
	 
	void draw() {
		System.out.printf("color=%s",this.color);
	}


}

class Point{
	//필드
	int x,y;	
	
	Point(){
		this(0,0); 
	}
	
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	//메소드 
	String getXY() {
		return String.format("(%d, %d)",x,y);
	}
}

class Circle extends Shape{
	//원점 
	Point center ; 
	int r; 
	Circle(){
		this(new Point(0,0),100);
	}
	Circle(Point center, int r ){
		this.center=center;
		this.r=r;
	}
}

class Triangle extends Shape{
	Point[] p=new Point[3];
	Triangle(Point[] p) {
		this.p=p;
	}	

}

class Rectangle extends Shape{
	Point[] p=new Point[4];
	Rectangle(Point[] p) {
		this.p=p;
	}	
}
