package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 12:07:04
 * @subject 
 * @content 
 * 
 */
public class Ex05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Circle extends Point{
	int r; 
}
/*
 * class Circle{ int x; int y; //.반지름 int r; Point 원점 =null;
 * 
 * }
 */
//좌표 클래스 
class Point{
	//필드
	int x;
	int y;
	
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