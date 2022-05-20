package days25;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 12:05:44
 * @subject 
 * @content 
 * 
 */
public class Ex07 {
public static void main(String[] args) {
	ArrayList<String > list=new ArrayList<String> (); 
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	/*
	 * Enumeration <String> en=list.elements(); while (en.hasMoreElements()) {
	 * String type = (String)en.nextElement(); System.out.println(type); }
	 * Iterator<String> ir=list.Iterator(); while (en.hasMoreElements()) { String
	 * string = (String) en.nextElement();
	 * 
	 * }
	 */
	
	//단방향이 아니라 뒤로도 갈수 있다. 
	ListIterator <String> ir=list.listIterator();
	while (ir.hasNext()) {
		String str= (String) ir.next();
		System.out.println(str);	
	}
	System.out.println(ir.previous());
	
	
}
}
