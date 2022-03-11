package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 10:24:45
 * @subject 
 * @content 
 * 
 */
public class MyPoint {
public int x;
public int y;

public void dispPoint() {
	System.out.printf("x= %d, y=%d ",x,y);
}
public void offsetPoint(int pos ) {
	x+=pos;
	y+=pos;
}
public void plusPoint(MyPoint p2) {
	x+=p2.x;
	y+=p2.y;
}
}
