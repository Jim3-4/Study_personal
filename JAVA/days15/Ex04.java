package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 12:01:36
 * @subject 
 * @content 
 * 
 */
public class Ex04 {
public static void main(String[] args) {
	Tv t1=new Tv();
	System.out.println(t1.channel);
	//참조타입의 매개변수를 메서드 호출 call by reference 
	changeTv(t1);
	System.out.println(t1.channel);
}

/**
 * @param t1
 */
private static void changeTv(Tv t1) {
	// TODO Auto-generated method stub
	t1.channel=100;
	
}
}
