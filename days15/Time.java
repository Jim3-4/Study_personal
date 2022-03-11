package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 10:21:05
 * @subject 
 * @content 
 * 
 */
public class Time {
	private int hour;
	int minute;
	protected int second;
	public int milisecond;
	public int nano;
	
	public void printTime() {
		hour=12; // private 같은 클래스 내부에서 접근 가능
	}
}
