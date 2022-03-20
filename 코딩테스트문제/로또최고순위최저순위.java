package days21;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 지민
 * @date 2022. 3. 20. - 오후 12:18:27
 * @subject 
 * @content 
 * 
 */
 class LottoPrac {
public static void main(String[] args) {
	
}
public static int[] solution(int[] lottos, int[] win_nums) {
	int zeroNum=0; //0의 수가 몇개인지 
	int count=0; //같은 것이 몇개인지 
	
	Arrays.sort(lottos); 
	Arrays.sort(win_nums);
	for(int i: lottos) {		
			if(Arrays.binarySearch(win_nums, i) >=0) count++;
			if(i==0) zeroNum++;
	
	}
	
     int[] answer = {Math.min(7-(count+zeroNum),6),Math.min
    		 (7-count, 6)};
     return answer;
}
	 
}
