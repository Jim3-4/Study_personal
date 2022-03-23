package days24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오후 3:28:20
 * @subject                      String [] -> ArrayList 변환
 * @content                     Arrays.asList() 메서드 를 사용하면 된다. 
 */
public class Ex08 {

	public static void main(String[] args) {
		// ( 기억 ) 
		// String [] -> ArrayList 변환
		String [] names = {"박예린","이채영","정도연","마상민","김희진"};
		/*
		ArrayList list = new ArrayList();		
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		*/
		
	    //List   a =   	 Arrays.asList(names);
		//ArrayList list = new ArrayList(a);
		
		ArrayList list = new ArrayList(Arrays.asList(names));
		
		System.out.println(   list );  // [박예린, 이채영, 정도연, 마상민, 김희진]

	} // main

} // class
