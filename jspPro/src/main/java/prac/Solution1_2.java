package prac;
import java.util.ArrayList;
import java.util.Collections;

class Solution1_2 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer =  new int[commands.length];        
		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> arr=new ArrayList<>();
			for (int j = commands[i][0]-1; j <commands[i][1]; j++) {
				arr.add(array[j]);
			}
			Collections.sort(arr);
			answer[i]=arr.get(commands[i][2]-1);
		}//for      
		return answer;   
	}
}


/* [1, 5, 2, 6, 3, 7, 4]/// [[2, 5, 3], [4, 4, 1], [1, 7, 3]] ////[5, 6, 3]
 * 1번째수가 시작점, 2번째수가 마지막점 , 3번째수가 정렬한 후 가져올수 
 *  그 수를 answer배열에 저장하자 
 *  
 *       0  1   2
 * 0 [[2, 5, 3],
 * 1  [4, 4, 1],
 * 2  [1, 7, 3]]
 *  */
