package days18;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 4:24:27
 * @subject 
 * @content 
 */
public class Ex14 {

	public static void main(String[] args) {
		/*
		<E> 제네릭, 지네릭
		ArrayList<E> 클래스
		public class ArrayList 
		          extends AbstractList
                  implements List, RandomAccess, Cloneable, java.io.Serializable
        */
		// 추상 클래스  - AbstractList
		// 인터페이스  -  List, RandomAccess, Cloneable, java.io.Serializable
		// List 인터페이스 부모 인터페이스 Collection 인터페이스 
		//Collection  list = new ArrayList();
		
		// 인터페이스 업캐스팅
		List  list = new ArrayList();
		
		disp(  list  );
		disp( new ArrayList() );
		
		                                   // 인터페이스 매개변수 다형성
		ArrayList  xx = new ArrayList(list);
	} // main
                                          // 인터페이스 매개변수 다형성
	private static void disp(  List list  ) { 
		
	}

} // class
