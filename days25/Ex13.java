package days25;

import java.util.HashSet;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 4:16:36
 * @subject 
 * @content 
 * 
 */
public class Ex13 {
public static void main(String[] args) {
	HashSet<Integer> a= new HashSet<Integer>();
	a.add(1); a.add(2); a.add(3); a.add(4); a.add(5);
	
	HashSet<Integer> b=new HashSet<Integer>();
	b.add(4); b.add(5); b.add(6); b.add(7); b.add(8);
	
	System.out.println(a);
	System.out.println(b);
}
}
