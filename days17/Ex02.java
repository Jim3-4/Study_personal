package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오전 10:54:46
 * @subject 
 * @content 
 * 
 */
public class Ex02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Engine engine=new Engine();
		Car myCar=new Car();
		myCar.setEngine(engine);
		myCar.speedUp(20);
	}

}
