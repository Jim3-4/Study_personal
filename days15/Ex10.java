package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 11:30:40
 * @subject 
 * @content 
 * 
 */
public class Ex10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     // MyMath 클래스		
			 MyMath math = new MyMath();
			 System.out.println(  math.sum(1, 2)   );
			 System.out.println(  math.sum(1, 2, 3)   );
			 System.out.println(  math.sum(1, 2, 3, 4, 5, 6, 7)   );
			 
			 int [] m = { 1,2,3,4,5,6,7,8,9,10,11};
			 System.out.println(  math.sum(  m )   );

			 // p 291 생성자( constructor )~ 수업

}
}