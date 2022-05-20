package days25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 3:30:44
 * @subject p631 11-2
 * @content 
 * 
 */
public class Ex11 {

public static void main(String[] args) {
	Set<Integer> set=new HashSet<Integer>();
	while(set.size()<25) {
		set.add((int)(Math.random()*50)+1);
	}
	int[][] bingo=new int[5][5];
	Iterator<Integer> ir = set.iterator();
	int idx=0;
	while (ir.hasNext()) {
		Integer n = (Integer) ir.next();
		 bingo[idx/5][idx%5]=n;
		 idx++;
		 System.out.printf("[%02d]",n);
		 if(idx%5==0) System.out.println();
	}
	
	
	//	int[][] board=new int [5][5];
//	
//	for (int i = 0; i < 25; i++) {
//		set.add((int)(Math.random()*50)+1);
//		
//	}
//	Iterator it =set.iterator();
//	for (int i = 0; i < board.length; i++) {
//		for (int j = 0; j < board[i].length; j++) {
//			board[i][j]=Integer.parseInt((String)it.next());
//			System.out.print((board[i][j] <10? "  ": " ")+board[i][j]);
//		}
//		System.out.println();
//	}

}
}
 