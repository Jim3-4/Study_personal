package days25;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 11:19:15
 * @subject 
 * @content 
 * 
 */
public class Ex04 {
public static void main(String[] args) {

	//큐는 인터페이스 
	//인터페이스 업캐스팅(갸능 )
	Queue q=new LinkedList();
	q.add("김희진");
	q.add("도성환");
	q.add("박단");
	
	System.out.println(q.size());
	
	String name;
	
	while( !q.isEmpty()) {
		name=(String)q.remove();
		System.out.println(name);
	}
	
	
}
}
