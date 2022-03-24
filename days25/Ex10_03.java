package days25;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 2:48:28
 * @subject 
 * @content 
 * 
 */
public class Ex10_03 {
public static void main(String[] args) {
	int gameNumber=1;
	
	Scanner sc=new Scanner(System.in);
	System.out.println("게임 횟수 입력");
	gameNumber=sc.nextInt();
	
	ArrayList<LinkedHashSet<Integer>> lottos=new ArrayList<LinkedHashSet<Integer>>(gameNumber);
	LinkedHashSet<Integer> lotto=null;

	for (int i = 0; i < gameNumber; i++) {
		lotto=new LinkedHashSet<Integer>();
		Ex10_02.fillLotto(lotto);
		lottos.add(lotto);
	}
	for (int i = 0; i <gameNumber; i++) {
		Ex10_02.dispLotto(lottos.get(i));
	}
	
}
}
