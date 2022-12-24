import java.util.*;
class Solution {
		public static int[] solution(String s) {
		//정답을 반환할 배열 
		int[] answer =new int[s.length()];
		//string -> char 배열로 쪼개기  
		char[] arr=s.toCharArray();
	
		answer[0]=-1;
		for (int i = 1; i < arr.length; i++) {
			answer[i]=-1;
			for (int j = 0; j <i; j++) {			
				if(arr[i]==arr[j]) {	
					answer[i]=i-j;
				}	
			}//for-j	
		}
		return answer;
	}
}
