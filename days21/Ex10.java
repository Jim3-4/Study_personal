package days21;

import java.util.Arrays;

import com.util.Rnd;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 3:52:24
 * @subject  클래스 라이브러리( 패키지 com.util.Rnd 클래스 + 클래스 + 클래스 )    =>  random.jar   모듈화
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		int [] m = new int[20];		
		m = Rnd.fillRand(m, 5, 20);		
		System.out.println(  Arrays.toString(m) );
		
		
	}

}
