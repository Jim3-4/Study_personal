package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 10:42:31
 * @subject 
 * @content 
 * 
 */
public class Ex03_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t1=new Tv();
		t1.channel=11;
		t1.power();
		
		Tv t2=new Tv();
		t2.channel=100;
		
		Tv t3=t2;
		t2.channel=5;
		System.out.println(t3.channel);
		
		
	}

}
