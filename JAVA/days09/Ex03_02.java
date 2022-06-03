
/**
 * @author 지민
 * @date 2022. 2. 25. - 오전 11:37:53
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
		int i=-3;
		i=Math.abs(i);
		System.out.println(i);
	
	}
	private static int abs(int i) {
		if(i<0) i*=-1;
		return i; 
	}
}
