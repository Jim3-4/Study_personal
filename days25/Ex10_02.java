package days25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 2:30:21
 * @subject 
 * @content 
 * 
 * 
 */
public class Ex10_02 {
public static void main(String[] args) {
//HashSet<Integer> lotto=new HashSet<Integer>();
	HashSet<Integer> lotto=new LinkedHashSet<Integer>();
	fillLotto(lotto);
	dispLotto(lotto);
	
	
}

/**
 * @param lotto
 */
public  static void dispLotto(HashSet<Integer> lotto) {
	// TODO Auto-generated method stub
	Iterator<Integer> ir=lotto.iterator();
	while (ir.hasNext()) {
		Integer n = (Integer) ir.next();
		System.out.printf("[%d]",n);
		
	}
	System.out.println();
}


/**
 * @param lotto
 */
public static void fillLotto(HashSet<Integer> lotto) {
	// TODO Auto-generated method stub
	
	Random rnd=new Random();
	while(lotto.size()<6){
		int n=rnd.nextInt(45)+1;
		System.out.println(n);
	}

}

}
