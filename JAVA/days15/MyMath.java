package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 10:22:55
 * @subject 
 * @content 
 * 
 */
public class MyMath {
	public int sum(int...m) {
		int result=0;
		for(int i=0; i<m.length; i++) {
			result+=m[i];
		}
		return result;
	}
}
