package days25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 9:32:43
 * @subject 
 * @content 
 * 
 */
public class Ex01 {
public static void main(String[] args) {
	ArrayList list=new ArrayList(5);
	Random rnd=new Random();
	for (int i = 0; i < 5; i++) {
		list.add(rnd.nextInt(100)+1);
	}
	System.out.println(list);
	Comparator c= new ListDescendingComparator();
	list.sort(c);
	System.out.println(list);
}
}
class ListDescendingComparator implements Comparator<Integer>{
public int compare(Integer o1, Integer o2) {
	return o1.compareTo(o2);
}
}