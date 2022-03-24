package days25;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 10:14:37
 * @subject 
 * @content 
 * 
 */
public class Ex02_02 {
public static void main(String[] args) {
	
	//순서 유지, 중복허용 
	//비순차적 삽입 ,삭제  
	
	LinkedList list=new LinkedList(); 
	list.add("박예린");
	list.add("이동원");
	list.add("안시은");
	
	list.addFirst("김서영");
	System.out.println(list);
	
	list.add(3,"이채영");
	System.out.println(list);

	//3 노드 
	list.get(0);
	//list.getFirst() ==list.get(0)
//	list.getLast() == list.get(list.size()-1)
	
	//제거
	list.remove(1);
	list.remove("박예린");

	System.out.println(list.size());
	
	list.iterator();
	Iterator ir=list.iterator();
	Iterator it=list.descendingIterator();
	while (ir.hasNext()) {
		String name = (String) ir.next();
		System.out.println(name);
	}
	System.out.println("+++++++");
	while (it.hasNext()) {
		String name = (String) it.next();
		System.out.println(name);
	}
	

}
}
